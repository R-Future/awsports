package com.awsports.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.awsports.pojo.Individualpoint;
import com.awsports.pojo.Individualrank;
import com.awsports.pojo.Individualrankest;
import com.awsports.pojo.Punishment;
import com.awsports.pojo.Teampoint;
import com.awsports.pojo.Teamrank;
import com.awsports.pojo.Teamrankest;
import com.awsports.service.IndividualpointService;
import com.awsports.service.IndividualrankService;
import com.awsports.service.IndividualrankestService;
import com.awsports.service.PunishmentService;
import com.awsports.service.TeampointService;
import com.awsports.service.TeamrankService;
import com.awsports.service.TeamrankestService;

public class UpdateRankUtil {
	
	private static double totalPoints;
	private static int totalMatchs;
	private static int totalWins;
	private static int totalMarginBureaus;
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年8月14日 下午10:34:47
	 * @param matchtime
	 * @param entrys
	 * @param individualrankService
	 * @param individualrankestService
	 * @param punishmentService
	 * @param individualpointService
	 * @throws Exception
	 * @Return: void
	 * @Description: 个人排名 
	 *
	 */
	public static void updateRank(String matchtime,
								  Integer[] entrys,
								  IndividualrankService individualrankService,
								  IndividualrankestService individualrankestService,
								  PunishmentService punishmentService,
								  IndividualpointService individualpointService) throws Exception{
		if(entrys==null||entrys.length==0){
			throw new CustomException("未注明要更新的参赛类型（如男单，女单等）！");
		}else{
			List<Individualpoint> individualpoints=null;
			//获取当前年份和周
			CustomDate customDate=new CustomDate(matchtime+" 00:00:00");
			//用于查询数据库的查询条件
			Individualpoint individualpoint=new Individualpoint();
			individualpoint.setYear(customDate.getYear());
			individualpoint.setLastYear(customDate.getYear()-1);
			individualpoint.setWeek(customDate.getWeek());
			for(Integer entry:entrys){
				individualpoint.setEntry(entry);
				//获取查询结果
				if(entry.equals(EntryEnum.MIXEDSINGLE.getValue())){
					//更新的排名类型为混合单打,则需加入男单和女单
					individualpoint.setManSingleEntry(EntryEnum.MANSINGLE.getValue());
					individualpoint.setWomanSingleEntry(EntryEnum.WOMANSINGLE.getValue());
				}else{
					//其它情况则只统计单项
					individualpoint.setManSingleEntry(0);
					individualpoint.setWomanSingleEntry(0);
				}
				individualpoints=individualpointService.findByEntryYearWeek(individualpoint);
				if(individualpoints==null||individualpoints.size()<=0){
					continue;
				}else{
					//更新个人排名
					int userid=individualpoints.get(0).getUserid().intValue();
					//初始化变量
					initializer();
					//临时存储计算后的用户排名记录，用于排序
					List<Individualrank> rawRanks=new ArrayList<Individualrank>();
					for(Individualpoint ip:individualpoints){
						if(ip.getInvalid().booleanValue()){//数据无效
							continue;
						}else{
							if(ip.getUserid().intValue()==userid){//同一个用户
								totalPoints+=ip.getPoints().doubleValue();
								totalMatchs+=ip.getMatchs().intValue();
								totalWins+=ip.getWins().intValue();
								totalMarginBureaus+=ip.getMarginbureau().intValue();
							}else{//下一个用户
								//保存上一个用户的最新排名记录
								Individualrank individualrank=new Individualrank();
								individualrank.setUserid(userid);
								individualrank.setEntry(entry);
								individualrank.setYear(customDate.getYear());
								individualrank=individualrankService.findByUseridEntryYear(individualrank);
								if(individualrank==null||individualrank.getInvalid().booleanValue()){//无记录
									individualrank=new Individualrank();
									individualrank.setUserid(userid);
									individualrank.setEntry(entry);			
								}
								//扣除个人退赛扣分
								Punishment punishment=new Punishment();
								punishment.setUserid(userid);
								punishment.setEntry(entry);
								punishment.setInvalid(false);
								Integer punishmentPoints=punishmentService.findSumByUseridEntry(punishment);
								if(punishmentPoints!=null){
									//存在退赛记录
									totalPoints-=punishmentPoints.intValue();
								}else{
									//...
								}
								individualrank.setTotalpoint(totalPoints);
								individualrank.setTotalmatchs(totalMatchs);
								individualrank.setTotalmarginbureau(totalMarginBureaus);
								individualrank.setWins(totalWins);
//								individualrank.setRankingchange(0);
								individualrank.setYear(customDate.getYear());
//								individualrank.setWeek(customDate.getWeek());
								rawRanks.add(individualrank);
								//初始化变量
								initializer();
								//统计下一个用户
								userid=ip.getUserid().intValue();
								totalPoints+=ip.getPoints().doubleValue();
								totalMatchs+=ip.getMatchs().intValue();
								totalWins+=ip.getWins().intValue();
								totalMarginBureaus+=ip.getMarginbureau().intValue();
							}
						}
					}//end for
					//保存最后一个用户的最新排名记录
					Individualrank finalUser=new Individualrank();
					finalUser.setUserid(userid);
					finalUser.setEntry(entry);
					finalUser.setYear(customDate.getYear());
					finalUser=individualrankService.findByUseridEntryYear(finalUser);
					if(finalUser==null||finalUser.getInvalid().booleanValue()){//无记录
						finalUser=new Individualrank();
						finalUser.setUserid(userid);
						finalUser.setEntry(entry);						
//						individualrank.setRankingchange(0);						
					}else{
						//...
					}
					//扣除个人退赛扣分
					Punishment punishment=new Punishment();
					punishment.setUserid(userid);
					punishment.setEntry(entry);
					punishment.setInvalid(false);
					Integer punishmentPoints=punishmentService.findSumByUseridEntry(punishment);
					if(punishmentPoints!=null){
						//存在退赛记录
						totalPoints-=punishmentPoints.intValue();
					}else{
						//...
					}
					finalUser.setTotalpoint(totalPoints);
					finalUser.setTotalmatchs(totalMatchs);
					finalUser.setTotalmarginbureau(totalMarginBureaus);
					finalUser.setWins(totalWins);
					finalUser.setYear(customDate.getYear());
//					finalUser.setWeek(customDate.getWeek());
					rawRanks.add(finalUser);
					
					//排序
					IndividualrankComparator individualrankComparator=new IndividualrankComparator();
					Collections.sort(rawRanks,individualrankComparator);
					int intervalWeek = 0;
					
					if(rawRanks.size()>0){
						
						//排名第一的用户
						Individualrank first=(Individualrank)rawRanks.get(0);
						int newRank=1;
						int oldRank=0;
						if(first.getId()!=null){
							//old record
							intervalWeek = customDate.getWeek() - first.getWeek().intValue();
							first.setWeek(customDate.getWeek());
							//更新记录
							//统计排名变化
							oldRank=first.getCurrentrank().intValue();
							first.setRankingchange(oldRank-newRank);
							//更新排名
							first.setCurrentrank(newRank);
							individualrankService.updateById(first);
						}else{
							//new record
							intervalWeek = customDate.getWeek();
							first.setWeek(customDate.getWeek());
							//添加记录
							oldRank=0;
							first.setRankingchange(0);
							first.setCurrentrank(newRank);
							individualrankService.insertOne(first);
						}
						//更新排名‘最’记录
						updateRankest(individualrankestService,first,intervalWeek,newRank,oldRank,matchtime);

						//重置其它用户排名
						Individualrank last=null;
						Individualrank next=null;
						for(int i=1;i<rawRanks.size();i++){
							last=(Individualrank)rawRanks.get(i-1);
							next=(Individualrank)rawRanks.get(i);
							//对同排名进行处理
							if(individualrankComparator.compare(last, next)==0){
								//与前一位排名相同
								newRank=last.getCurrentrank().intValue();
							}else{
								newRank=i+1;			
							}
							//统计排名变化
							if(next.getId()!=null){
								//old record
								intervalWeek = customDate.getWeek() - next.getWeek().intValue();
								next.setWeek(customDate.getWeek());
								//之前有排名
								oldRank=next.getCurrentrank().intValue();
								next.setRankingchange(oldRank-newRank);
								next.setCurrentrank(newRank);
								individualrankService.updateById(next);
							}else{
								//new record
								intervalWeek = customDate.getWeek();
								next.setWeek(customDate.getWeek());
								//之前无排名
								oldRank=0;
								next.setRankingchange(0);
								next.setCurrentrank(newRank);
								individualrankService.insertOne(next);
							}
							//更新排名‘最’记录
							updateRankest(individualrankestService,next,intervalWeek,newRank,oldRank,matchtime);
						}
					}else{
						//...
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年8月14日 下午10:36:43
	 * @param entrys
	 * @return
	 * @throws Exception
	 * @Return: String
	 * @Description: 组合排名 
	 *
	 */
	public static void updateRank(String matchtime,
							 Integer[] entrys,
							 TeamrankService teamrankService,
							 TeamrankestService teamrankestService,
							 TeampointService teampointService) throws Exception{
		if(entrys==null||entrys.length==0){
			throw new CustomException("未注明要更新的参赛类型（如男双，女双等）！");
		}else{
			List<Teampoint> teampoints=null;
			//获取当前年份和周
			CustomDate customDate=new CustomDate(matchtime+" 00:00:00");
			//用于查询数据库的查询条件
			Teampoint teampoint=new Teampoint();
			teampoint.setYear(customDate.getYear());
			teampoint.setLastYear(customDate.getYear()-1);
			teampoint.setWeek(customDate.getWeek());
			for(Integer entry:entrys){
				teampoint.setEntry(entry);
				if(entry.equals(EntryEnum.MIXEDDOUBLE.getValue())){
					//如果更新的混双比赛的排名，则同时统计男双和女双
					teampoint.setManDoubleEntry(EntryEnum.MANDOUBLE.getValue());
					teampoint.setWomanDoubleEntry(EntryEnum.WOMANDOUBLE.getValue());
				}else{
					//否则，只统计单项
					teampoint.setManDoubleEntry(0);
					teampoint.setWomanDoubleEntry(0);
				}
				//获取查询结果
				teampoints=teampointService.findByEntryYearWeek(teampoint);
				if(teampoints==null||teampoints.size()<=0){
					continue;
				}else{
					//更新个人排名
					int teamid=teampoints.get(0).getTeamid().intValue();
					//初始化变量
					initializer();
					//临时存储计算后的用户排名记录，用于排序
					List<Teamrank> rawRanks=new ArrayList<Teamrank>();
					
					for(Teampoint tp:teampoints){
						if(tp.getInvalid().booleanValue()){//数据无效
							continue;
						}else{
							if(tp.getTeamid().intValue()==teamid){//同一个用户
								totalPoints+=tp.getPoints().doubleValue();
								totalMatchs+=tp.getMatchs().intValue();
								totalWins+=tp.getWins().intValue();
								totalMarginBureaus+=tp.getMarginbureau().intValue();
							}else{//下一个用户
								//保存上一个用户的最新排名记录
								Teamrank teamrank=new Teamrank();
								teamrank.setTeamid(teamid);
								teamrank.setEntry(entry);
								teamrank.setYear(customDate.getYear());
								teamrank=teamrankService.findByTeamidEntryYear(teamrank);
								if(teamrank==null||teamrank.getInvalid().booleanValue()){//无记录
									teamrank=new Teamrank();
									teamrank.setTeamid(teamid);
									teamrank.setEntry(entry);											
								}else{
									//...
								}
								teamrank.setTotalpoint(totalPoints);
								teamrank.setTotalmatchs(totalMatchs);
								teamrank.setTotalmarginbureau(totalMarginBureaus);
								teamrank.setWins(totalWins);
//								teamrank.setRankingchange(0);
								teamrank.setYear(customDate.getYear());
//								teamrank.setWeek(customDate.getWeek());
								rawRanks.add(teamrank);
								//初始化变量
								initializer();
								//统计下一个用户
								teamid=tp.getTeamid().intValue();
								totalPoints+=tp.getPoints().doubleValue();
								totalMatchs+=tp.getMatchs().intValue();
								totalWins+=tp.getWins().intValue();
								totalMarginBureaus+=tp.getMarginbureau().intValue();
							}
						}
					}
					//保存最后一个用户的最新排名记录
					Teamrank finalTeam=new Teamrank();
					finalTeam.setTeamid(teamid);
					finalTeam.setEntry(entry);
					finalTeam.setYear(customDate.getYear());
					finalTeam=teamrankService.findByTeamidEntryYear(finalTeam);
					if(finalTeam==null||finalTeam.getInvalid().booleanValue()){//无记录
						finalTeam=new Teamrank();
						finalTeam.setTeamid(teamid);
						finalTeam.setEntry(entry);							
					}else{
						//。。。
					}
					finalTeam.setTotalpoint(totalPoints);
					finalTeam.setTotalmatchs(totalMatchs);
					finalTeam.setTotalmarginbureau(totalMarginBureaus);
					finalTeam.setWins(totalWins);
					finalTeam.setYear(customDate.getYear());
//					finalTeam.setWeek(customDate.getWeek());
					rawRanks.add(finalTeam);
					//排序
					TeamrankComparator teamrankComparator=new TeamrankComparator();
					Collections.sort(rawRanks,teamrankComparator);
					int intervalWeek = 0;
					
					if(rawRanks.size()>0){
						
						//排名第一的用户
						Teamrank first=(Teamrank)rawRanks.get(0);
						int newRank=1;
						int oldRank=0;
						//统计排名变化
						if(first.getId()!=null){
							//old record
							intervalWeek = customDate.getWeek() - first.getWeek().intValue();
							first.setWeek(customDate.getWeek());
							//更新数据
							oldRank=first.getCurrentrank().intValue();
							first.setRankingchange(oldRank-newRank);
							first.setCurrentrank(newRank);
							teamrankService.updateById(first);
						}else{
							//new record
							intervalWeek = customDate.getWeek();
							first.setWeek(customDate.getWeek());
							//新增数据
							oldRank=0;
							first.setRankingchange(0);
							first.setCurrentrank(newRank);
							teamrankService.insertOne(first);
						}
						//更新排名‘最’记录
						updateRankest(teamrankestService,first,intervalWeek,newRank,oldRank,matchtime);
						
						//重置其它用户排名
						Teamrank last=null;
						Teamrank next=null;
						for(int i=1;i<rawRanks.size();i++){
							last=(Teamrank)rawRanks.get(i-1);
							next=(Teamrank)rawRanks.get(i);
							//对同排名进行处理
							if(teamrankComparator.compare(last, next)==0){
								//与前一位排名相同
								newRank=last.getCurrentrank().intValue();
							}else{
								newRank=i+1;			
							}
							//统计排名变化
							if(next.getId()!=null){
								//old record
								intervalWeek = customDate.getWeek() - next.getWeek().intValue();
								next.setWeek(customDate.getWeek());
								//之前有排名
								oldRank=next.getCurrentrank().intValue();
								next.setRankingchange(oldRank-newRank);
								next.setCurrentrank(newRank);
								teamrankService.updateById(next);
							}else{
								//new record
								intervalWeek = customDate.getWeek();
								next.setWeek(customDate.getWeek());
								//之前无排名
								oldRank=0;
								next.setRankingchange(0);
								next.setCurrentrank(newRank);
								teamrankService.insertOne(next);
							}
							//更新排名‘最’记录
							updateRankest(teamrankestService,next,intervalWeek,newRank,oldRank,matchtime);
						}
					}else{
						//...
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月24日 下午1:36:44
	 * @Return: void
	 * @Description: 初始化变量
	 *
	 */
	private static void initializer(){
		totalPoints=0;
		totalMatchs=0;
		totalWins=0;
		totalMarginBureaus=0;
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月25日 上午12:26:11
	 * @param userid
	 * @param entry
	 * @param newRank
	 * @param oldRank
	 * @throws Exception
	 * @Return: void
	 * @Description: 更新个人排名‘最’记录
	 *
	 */
	private static void updateRankest(IndividualrankestService individualrankestService,
									  Individualrank individualrank,
									  int intervalWeek,
									  int newRank,
									  int oldRank,
									  String matchtime) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(matchtime);
		Integer userid=individualrank.getUserid();
		Integer entry=individualrank.getEntry();
		Individualrankest individualrankest=new Individualrankest();
		individualrankest.setUserid(userid);
		individualrankest.setEntry(entry);
		individualrankest=individualrankestService.findByUseridEntry(individualrankest);
		if(individualrankest!=null&&!individualrankest.getInvalid().booleanValue()){
			//记录存在且有效
			if(individualrankest.getHighestranking().compareTo(newRank)>0){
				//之前最高排名比当前新的排名低
				individualrankest.setHighestranking(newRank);
				individualrankest.setHrstartedat(date);
			}else{
				//之前最高排名比当前新的排名高
			}
			if(newRank!=1){
				//当前新的排名不是第一
				if(oldRank==1){
					//上周排名第一
					individualrankest.setNo1weeks(individualrankest.getNo1weeks().intValue()+intervalWeek);
					individualrankest.setNo1continiousweeks(individualrankest.getNo1continiousweeks().intValue()+intervalWeek);
					if(individualrankest.getNo1continiousweeks().compareTo(individualrankest.getNo1longestcontiniousweeks())>0){
						//连续第一周数大于最长连续第一周数
						individualrankest.setNo1longestcontiniousweeks(individualrankest.getNo1continiousweeks());
					}else{
						//连续第一周数小于最长连续第一周数
					}
					individualrankest.setNo1continiousweeks(0);
				}else{
					//上周排名不是第一
				}
			}else{
				//当前新的排名是第一
				if(oldRank==1){
					//上期排名第一
					individualrankest.setNo1weeks(individualrankest.getNo1weeks().intValue()+intervalWeek);
					individualrankest.setNo1continiousweeks(individualrankest.getNo1continiousweeks().intValue()+intervalWeek);
				}else{
					//上周排名不是第一
					individualrankest.setNo1continiousweeks(0);
				}
			}
			individualrankestService.updateById(individualrankest);
		}else{
			//数据库中无记录或者之前记录无效
			individualrankest=new Individualrankest();
			individualrankest.setUserid(userid);
			individualrankest.setEntry(entry);
			individualrankest.setHighestranking(newRank);
			individualrankest.setHrstartedat(date);
			individualrankest.setNo1weeks(0);
			individualrankest.setNo1continiousweeks(0);
			individualrankest.setNo1longestcontiniousweeks(0);
			individualrankestService.insertOne(individualrankest);
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年8月14日 下午10:39:29
	 * @param teamrank
	 * @param newRank
	 * @param oldRank
	 * @throws Exception
	 * @Return: void
	 * @Description: 更新组合排名‘最’记录
	 *
	 */
	private static void updateRankest(TeamrankestService teamrankestService,
			  				   Teamrank teamrank,
			  				   int intervalWeek,
			  				   int newRank,
			  				   int oldRank,
			  				   String matchtime) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(matchtime);
		Integer teamid=teamrank.getTeamid();
		Integer entry=teamrank.getEntry();
		Teamrankest teamrankest=new Teamrankest();
		teamrankest.setTeamid(teamid);
		teamrankest.setEntry(entry);
		teamrankest=teamrankestService.findByTeamidEntry(teamrankest);
		if(teamrankest!=null&&!teamrankest.getInvalid().booleanValue()){
			//记录存在且有效
			if(teamrankest.getHighestranking().compareTo(newRank)>0){
				//之前最高排名比当前新的排名低
				teamrankest.setHighestranking(newRank);
				teamrankest.setHrstartedat(date);
			}else{
				//之前最高排名比当前新的排名高
			}
			if(newRank!=1){
				//当前新的排名不是第一
				if(oldRank==1){
					//上周排名第一
					teamrankest.setNo1weeks(teamrankest.getNo1weeks().intValue()+intervalWeek);
					teamrankest.setNo1continiousweeks(teamrankest.getNo1continiousweeks().intValue()+intervalWeek);
					if(teamrankest.getNo1continiousweeks().compareTo(teamrankest.getNo1longestcontiniousweeks())>0){
						//连续第一周数大于最长连续第一周数
						teamrankest.setNo1longestcontiniousweeks(teamrankest.getNo1continiousweeks());
					}else{
						//连续第一周数小于最长连续第一周数
					}
					teamrankest.setNo1continiousweeks(0);
				}else{
					//上周排名不是第一
				}
			}else{
				//当前新的排名是第一
				if(oldRank==1){
					//上周排名第一
					teamrankest.setNo1weeks(teamrankest.getNo1weeks().intValue()+intervalWeek);
					teamrankest.setNo1continiousweeks(teamrankest.getNo1continiousweeks().intValue()+intervalWeek);
				}else{
					//上周排名不是第一
					teamrankest.setNo1continiousweeks(0);
				}
			}
			teamrankestService.updateById(teamrankest);
		}else{
			//数据库中无记录或者之前记录无效
			teamrankest=new Teamrankest();
			teamrankest.setTeamid(teamid);
			teamrankest.setEntry(entry);
			teamrankest.setHighestranking(newRank);
			teamrankest.setHrstartedat(date);
			teamrankest.setNo1weeks(0);
			teamrankest.setNo1continiousweeks(0);
			teamrankest.setNo1longestcontiniousweeks(0);
			teamrankestService.insertOne(teamrankest);
		}

	}
}