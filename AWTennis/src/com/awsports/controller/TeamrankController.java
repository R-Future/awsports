package com.awsports.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.Teampoint;
import com.awsports.pojo.Teamrank;
import com.awsports.pojo.Teamrankest;
import com.awsports.pojo.TeamQuery;
import com.awsports.pojo.TeamrankQuery;
import com.awsports.service.TeamService;
import com.awsports.service.TeampointService;
import com.awsports.service.TeamrankService;
import com.awsports.service.TeamrankestService;
import com.awsports.util.CustomDate;
import com.awsports.util.CustomException;
import com.awsports.util.EntryEnum;
import com.awsports.util.TeamrankComparator;
import com.awsports.util.TypeMap;

@Controller
@RequestMapping("/teamrank")
public class TeamrankController {
	@Autowired
	private TeamrankService teamrankService;
	@Autowired
	private TeamrankestService teamrankestService;
	@Autowired
	private TeampointService teampointService;
	@Autowired
	private TeamService teamService;
	
	private Map<Integer,String> teamEntryTypes=TypeMap.teamEntryType();
	private double totalPoints;
	private int totalMatchs;
	private int totalWins;
	private int totalMarginBureaus;
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月24日 下午6:25:41
	 * @param model
	 * @param teamrankQuery
	 * @throws Exception
	 * @Return: String
	 * @Description: 组合排名列表
	 *
	 */
	@RequestMapping("/list")
	public String list(Model model,TeamrankQuery teamrankQuery) throws Exception{
		List<TeamrankQuery> teamrankQuerys=teamrankService.findAll(teamrankQuery);
		model.addAttribute("teamrankQuerys", teamrankQuerys);
		//获取组合参赛类型信息
		model.addAttribute("teamEntryTypes", teamEntryTypes);
		return "teamrank/list";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月24日 下午6:26:03
	 * @param model
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 更新或添加组合排名记录
	 *
	 */
	@RequestMapping("/update")
	public String update(Model model, Integer id) throws Exception{
		Teamrank teamrank=null;
		if(id!=null){
			//更新数据
			teamrank=teamrankService.findById(id);
		}else{
			//添加数据
			teamrank=new Teamrank();
		}
		model.addAttribute("teamrank", teamrank);
		//获取组合信息
		List<TeamQuery> teamQuerys=teamService.findAll(null);
		model.addAttribute("teamQuerys", teamQuerys);
		//获取组合参赛类型信息
		model.addAttribute("teamEntryTypes", teamEntryTypes);
		return "teamrank/update";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月24日 下午6:26:32
	 * @param teamrank
	 * @param br
	 * @param model
	 * @throws Exception
	 * @Return: String
	 * @Description: 保存修改后的排名记录
	 *
	 */
	@RequestMapping("/save")
	public String save(@Validated Teamrank teamrank, BindingResult br,Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "redirect:update";
		}else{
			CustomDate customDate=new CustomDate();
			teamrank.setYear(customDate.getYear());
			teamrank.setWeek(customDate.getWeek());
			if(teamrank.getId()!=null){
				//更新数据
				teamrankService.updateById(teamrank);
			}else{
				//添加数据
				teamrankService.insertOne(teamrank);
			}
			return "redirect:list";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月24日 下午6:26:49
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 删除排名记录
	 *
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{
			//删除teamrankest表中数据
			Teamrank teamrank=teamrankService.findById(id);
			Teamrankest teamrankest=new Teamrankest();
			teamrankest.setTeamid(teamrank.getTeamid());
			teamrankest.setEntry(teamrank.getEntry());
			Integer teamrankestId=teamrankestService.findByTeamidEntry(teamrankest).getId();
			if(teamrankestId!=null){
				//如果存在相应数据，则删除
				teamrankestService.deleteById(teamrankestId);
			}else{
				//...
			}		
			teamrankService.deleteById(id);
			return "redirect:list";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月24日 下午6:28:02
	 * @param entrys
	 * @throws Exception
	 * @Return: String
	 * @Description: 更新组合排名
	 *
	 */
	@RequestMapping("/updateRank")
	public String updateRank(Integer[] entrys) throws Exception{
		if(entrys==null||entrys.length==0){
			throw new CustomException("未注明要更新的参赛类型（如男双，女双等）！");
		}else{
			List<Teampoint> teampoints=null;
			//获取当前年份和周
			CustomDate customDate=new CustomDate();
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
								teamrank=teamrankService.findByTeamidEntry(teamrank);
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
								teamrank.setWeek(customDate.getWeek());
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
					finalTeam=teamrankService.findByTeamidEntry(finalTeam);
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
					finalTeam.setWeek(customDate.getWeek());
					rawRanks.add(finalTeam);
					//排序
					TeamrankComparator teamrankComparator=new TeamrankComparator();
					Collections.sort(rawRanks,teamrankComparator);
					
					if(rawRanks.size()>0){
						
						//排名第一的用户
						Teamrank first=(Teamrank)rawRanks.get(0);
						int newRank=1;
						int oldRank=0;
						//统计排名变化
						if(first.getId()!=null){
							//更新数据
							oldRank=first.getCurrentrank().intValue();
							first.setRankingchange(oldRank-newRank);
							first.setCurrentrank(newRank);
							teamrankService.updateById(first);
						}else{
							//新增数据
							oldRank=0;
							first.setRankingchange(0);
							first.setCurrentrank(newRank);
							teamrankService.insertOne(first);
						}
						//更新排名‘最’记录
						updateRankest(first,newRank,oldRank);
						
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
								//之前有排名
								oldRank=next.getCurrentrank().intValue();
								next.setRankingchange(oldRank-newRank);
								next.setCurrentrank(newRank);
								teamrankService.updateById(next);
							}else{
								//之前无排名
								oldRank=0;
								next.setRankingchange(0);
								next.setCurrentrank(newRank);
								teamrankService.insertOne(next);
							}
							//更新排名‘最’记录
							updateRankest(next,newRank,oldRank);
						}
					}else{
						//...
					}
				}
			}
			return "forward:list";
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
	private void initializer(){
		totalPoints=0;
		totalMatchs=0;
		totalWins=0;
		totalMarginBureaus=0;
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月25日 上午1:25:30
	 * @param teamid
	 * @param entry
	 * @param newRank
	 * @param oldRank
	 * @throws Exception
	 * @Return: void
	 * @Description: 更新组合排名‘最’记录
	 *
	 */
	private void updateRankest(Teamrank teamrank,int newRank,int oldRank) throws Exception{
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
				teamrankest.setHrstartedat((new Date()));
			}else{
				//之前最高排名比当前新的排名高
			}
			if(newRank!=1){
				//当前新的排名不是第一
				if(oldRank==1){
					//上周排名第一
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
				teamrankest.setNo1weeks(teamrankest.getNo1weeks().intValue()+1);
				if(oldRank==1){
					//上周排名第一
					teamrankest.setNo1continiousweeks(teamrankest.getNo1continiousweeks().intValue()+1);
				}else{
					//上周排名不是第一
					teamrankest.setNo1continiousweeks(1);
				}
			}
			teamrankestService.updateById(teamrankest);
		}else{
			//数据库中无记录或者之前记录无效
			teamrankest=new Teamrankest();
			teamrankest.setTeamid(teamid);
			teamrankest.setEntry(entry);
			teamrankest.setHighestranking(newRank);
			teamrankest.setHrstartedat((new Date()));
			if(newRank==1){
				teamrankest.setNo1weeks(1);
				teamrankest.setNo1continiousweeks(1);
			}else{
				teamrankest.setNo1weeks(0);
				teamrankest.setNo1continiousweeks(0);
			}
			teamrankest.setNo1longestcontiniousweeks(0);
			teamrankestService.insertOne(teamrankest);
		}

	}
}
 