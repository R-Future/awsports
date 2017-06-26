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

import com.awsports.pojo.Individualpoint;
import com.awsports.pojo.Individualrank;
import com.awsports.pojo.IndividualrankQuery;
import com.awsports.pojo.Individualrankest;
import com.awsports.pojo.User;
import com.awsports.service.IndividualpointService;
import com.awsports.service.IndividualrankService;
import com.awsports.service.IndividualrankestService;
import com.awsports.service.UserService;
import com.awsports.util.CustomDate;
import com.awsports.util.CustomException;
import com.awsports.util.EntryEnum;
import com.awsports.util.IndividualrankComparator;
import com.awsports.util.TypeMap;

@Controller
@RequestMapping("/individualrank")
public class IndividualrankController {
	@Autowired
	private IndividualrankService individualrankService;
	@Autowired
	private IndividualrankestService individualrankestService;
	@Autowired
	private UserService userService;
	@Autowired
	private IndividualpointService individualpointService;
	
	private Map<Integer,String> individualEntryTypes=TypeMap.individualEntryType();
	private double totalPoints;
	private int totalMatchs;
	private int totalWins;
	private int totalMarginBureaus;
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月24日 下午12:19:12
	 * @param model
	 * @param individualrankQuery
	 * @throws Exception
	 * @Return: String
	 * @Description: 个人排名列表
	 *
	 */
	@RequestMapping("/list")
	public String list(Model model,IndividualrankQuery individualrankQuery) throws Exception{
		List<IndividualrankQuery> individualrankQuerys=individualrankService.findAll(individualrankQuery);
		model.addAttribute("individualrankQuerys", individualrankQuerys);
		//获取个人参赛类型
		model.addAttribute("individualEntryTypes", individualEntryTypes);
		return "individualrank/list";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月24日 下午12:20:21
	 * @param model
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 更新或新增排名记录
	 *
	 */
	@RequestMapping("/update")
	public String update(Model model, Integer id) throws Exception{
		Individualrank individualrank=null;
		if(id!=null){
			//更新数据
			individualrank=individualrankService.findById(id);
		}else{
			//添加数据
			individualrank=new Individualrank();
		}
		model.addAttribute("individualrank", individualrank);
		//获取个人参赛类型
		model.addAttribute("individualEntryTypes", individualEntryTypes);
		//获取用户名
		List<User> users=userService.findAll(null);
		model.addAttribute("users", users);
		return "individualrank/update";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月24日 下午12:20:09
	 * @param individualrank
	 * @param br
	 * @param model
	 * @throws Exception
	 * @Return: String
	 * @Description: 保存修改后的排名记录
	 *
	 */
	@RequestMapping("/save")
	public String save(@Validated Individualrank individualrank, BindingResult br,Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "redirect:update";
		}else{
			CustomDate customDate=new CustomDate();
			individualrank.setYear(customDate.getYear());
			individualrank.setWeek(customDate.getWeek());
			if(individualrank.getId()!=null){
				//更新数据
				individualrankService.updateById(individualrank);
			}else{
				//添加数据
				individualrankService.insertOne(individualrank);
			}
			return "redirect:list";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月24日 下午12:21:04
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 删除某条记录
	 *
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{
			individualrankService.deleteById(id);
			return "redirect:list";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月24日 下午12:18:38
	 * @param entry
	 * @throws Exception
	 * @Return: String
	 * @Description: 更新个人排名
	 *
	 */
	@RequestMapping("/updateRank")
	public String updateRank(Integer[] entrys) throws Exception{
		if(entrys==null||entrys.length==0){
			throw new CustomException("未注明要更新的参赛类型（如男单，女单等）！");
		}else{
			List<Individualpoint> individualpoints=null;
			//获取当前年份和周
			CustomDate customDate=new CustomDate();
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
								individualrank=individualrankService.findByUseridEntry(individualrank);
								if(individualrank==null||individualrank.getInvalid().booleanValue()){//无记录
									individualrank=new Individualrank();
									individualrank.setUserid(userid);
									individualrank.setEntry(entry);			
								}
								individualrank.setTotalpoint(totalPoints);
								individualrank.setTotalmatchs(totalMatchs);
								individualrank.setTotalmarginbureau(totalMarginBureaus);
								individualrank.setWins(totalWins);
//								individualrank.setRankingchange(0);
								individualrank.setYear(customDate.getYear());
								individualrank.setWeek(customDate.getWeek());
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
					finalUser=individualrankService.findByUseridEntry(finalUser);
					if(finalUser==null||finalUser.getInvalid().booleanValue()){//无记录
						finalUser=new Individualrank();
						finalUser.setUserid(userid);
						finalUser.setEntry(entry);						
//						individualrank.setRankingchange(0);						
					}else{
						//...
					}
					finalUser.setTotalpoint(totalPoints);
					finalUser.setTotalmatchs(totalMatchs);
					finalUser.setTotalmarginbureau(totalMarginBureaus);
					finalUser.setWins(totalWins);
					finalUser.setYear(customDate.getYear());
					finalUser.setWeek(customDate.getWeek());
					rawRanks.add(finalUser);
					
					//排序
					IndividualrankComparator individualrankComparator=new IndividualrankComparator();
					Collections.sort(rawRanks,individualrankComparator);
					if(rawRanks.size()>0){
						
						//排名第一的用户
						Individualrank first=(Individualrank)rawRanks.get(0);
						int newRank=1;
						int oldRank=0;
						if(first.getId()!=null){
							//更新记录
							//统计排名变化
							oldRank=first.getCurrentrank().intValue();
							first.setRankingchange(oldRank-newRank);
							//更新排名
							first.setCurrentrank(newRank);
							individualrankService.updateById(first);
						}else{
							//添加记录
							oldRank=0;
							first.setRankingchange(0);
							first.setCurrentrank(newRank);
							individualrankService.insertOne(first);
						}
						//更新排名‘最’记录
						updateRankest(first,newRank,oldRank);

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
								//之前有排名
								oldRank=next.getCurrentrank().intValue();
								next.setRankingchange(oldRank-newRank);
								next.setCurrentrank(newRank);
								individualrankService.updateById(next);
							}else{
								//之前无排名
								oldRank=0;
								next.setRankingchange(0);
								next.setCurrentrank(newRank);
								individualrankService.insertOne(next);
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
	private void updateRankest(Individualrank individualrank,int newRank,int oldRank) throws Exception{
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
				individualrankest.setHrstartedat((new Date()));
			}else{
				//之前最高排名比当前新的排名高
			}
			if(newRank!=1){
				//当前新的排名不是第一
				if(oldRank==1){
					//上周排名第一
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
				individualrankest.setNo1weeks(individualrankest.getNo1weeks().intValue()+1);
				if(oldRank==1){
					//上期排名第一
					individualrankest.setNo1continiousweeks(individualrankest.getNo1continiousweeks().intValue()+1);
				}else{
					//上周排名不是第一
					individualrankest.setNo1continiousweeks(1);
				}
			}
			individualrankestService.updateById(individualrankest);
		}else{
			//数据库中无记录或者之前记录无效
			individualrankest=new Individualrankest();
			individualrankest.setUserid(userid);
			individualrankest.setEntry(entry);
			individualrankest.setHighestranking(newRank);
			individualrankest.setHrstartedat((new Date()));
			if(newRank==1){
				individualrankest.setNo1weeks(1);
				individualrankest.setNo1continiousweeks(1);
			}else{
				individualrankest.setNo1weeks(0);
				individualrankest.setNo1continiousweeks(0);
			}
			individualrankest.setNo1longestcontiniousweeks(0);
			individualrankestService.insertOne(individualrankest);
		}
	}
}
 