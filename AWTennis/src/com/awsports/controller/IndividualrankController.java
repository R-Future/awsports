package com.awsports.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
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
import com.awsports.pojo.Punishment;
import com.awsports.pojo.UserQuery;
import com.awsports.service.IndividualpointService;
import com.awsports.service.IndividualrankService;
import com.awsports.service.IndividualrankestService;
import com.awsports.service.PunishmentService;
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
	@Autowired
	private PunishmentService punishmentService;
	
	private Map<Integer,String> individualEntryTypes=TypeMap.individualEntryType();
	private double totalPoints;
	private int totalMatchs;
	private int totalWins;
	private int totalMarginBureaus;
	
	//logger
	private Logger log = Logger.getLogger(IndividualrankController.class);
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
		//默认只显示当前年份的个人排名
		if(individualrankQuery.getIndividualrank() == null){
			individualrankQuery = new IndividualrankQuery();
			Individualrank individualrank = new Individualrank();
			individualrank.setYear(Calendar.getInstance().get(Calendar.YEAR));
			individualrankQuery.setIndividualrank(individualrank);
		}
		List<IndividualrankQuery> individualrankQuerys=individualrankService.findAll(individualrankQuery);
		model.addAttribute("individualrankQuerys", individualrankQuerys);
		//获取个人参赛类型
		model.addAttribute("individualEntryTypes", individualEntryTypes);
		//获取性别类型
		model.addAttribute("sexTypes", TypeMap.sexType());
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
		List<UserQuery> userQuerys=userService.findAll(null);
		model.addAttribute("userQuerys", userQuerys);
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
			model.addAttribute("id", individualrank.getId());
			return "forward:update";
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
			//删除individualrankest表中数据
			Individualrank individualrank=individualrankService.findById(id);
			Individualrankest individualrankest=new Individualrankest();
			individualrankest.setUserid(individualrank.getUserid());
			individualrankest.setEntry(individualrank.getEntry());
			Integer individualrankestId=individualrankestService.findByUseridEntry(individualrankest).getId();
			if(individualrankestId!=null){
				//如果存在相应数据，则删除
				individualrankestService.deleteById(individualrankestId);
			}else{
				//...
			}		
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
			try{
				updateRankCore(entrys);
				log.info("["+Calendar.getInstance().getTime().toString()+"] 手动更新个人排名成功");
			}catch(Exception e){
				log.error("["+Calendar.getInstance().getTime().toString()+"] 手动更新个人排名失败");
			}
			return "forward:list";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年10月12日 下午9:58:10
	 * @param code
	 * @Return: void
	 * @Description: 用于定时自动更新排名
	 *
	 */
	@RequestMapping("/autoUpdate")
	public String autoUpdate(String code){
		if ("awtennis@2014ForIndividualRank".equals(code)) {
			Integer[] entrys = { EntryEnum.MANSINGLE.getValue(), EntryEnum.WOMANSINGLE.getValue(),
					EntryEnum.MIXEDSINGLE.getValue(), EntryEnum.DOUBLEMANINDIVIDUAL.getValue(),
					EntryEnum.DOUBLEWOMANINDIVIDUAL.getValue() };
			try{
				updateRankCore(entrys);
				log.info(Calendar.getInstance().getTime().toString()+"-自动更新个人排名成功");
			}catch(Exception e){
				log.error(Calendar.getInstance().getTime().toString()+"-自动更新个人排名失败");
			}
		}else{
			log.error(Calendar.getInstance().getTime().toString()+"-个人排名自动更新链接遭到入侵");
		}
		return "404";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年10月12日 下午9:44:00
	 * @param entrys
	 * @throws Exception
	 * @Return: void
	 * @Description: 计算排名
	 *
	 */
	private void updateRankCore(Integer[] entrys) throws Exception{
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
				//for log
				//String userName=userService.findById(userid).getName();
				//初始化变量
				initializer();
				//临时存储计算后的用户排名记录，用于排序
				List<Individualrank> rawRanks=new ArrayList<Individualrank>();
				//log
				//log.info("更新日期: "+customDate.getTime());
				for(Individualpoint ip:individualpoints){
					if(ip.getInvalid().booleanValue()){//数据无效
						continue;
					}else{
						if(ip.getUserid().intValue()==userid){//同一个用户
							totalPoints+=ip.getPoints().doubleValue();
							totalMatchs+=ip.getMatchs().intValue();
							totalWins+=ip.getWins().intValue();
							totalMarginBureaus+=ip.getMarginbureau().intValue();
							//log
							//log.info("user: "+userName+"/entry: "+ip.getEntry()+"/year: "+ip.getYear()+"/week: "+ip.getWeek()+"/points: "+ip.getPoints());
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
//							individualrank.setRankingchange(0);
							individualrank.setYear(customDate.getYear());
//							individualrank.setWeek(customDate.getWeek());
							rawRanks.add(individualrank);
							//初始化变量
							initializer();
							//统计下一个用户
							userid=ip.getUserid().intValue();
							totalPoints+=ip.getPoints().doubleValue();
							totalMatchs+=ip.getMatchs().intValue();
							totalWins+=ip.getWins().intValue();
							totalMarginBureaus+=ip.getMarginbureau().intValue();
							//log
							//userName=userService.findById(userid).getName();
							//log.info("user: "+userName+"/entry: "+ip.getEntry()+"/year: "+ip.getYear()+"/week: "+ip.getWeek()+"/points: "+ip.getPoints());
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
//					individualrank.setRankingchange(0);
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
//				finalUser.setWeek(customDate.getWeek());
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
					updateRankest(first,intervalWeek,newRank,oldRank);

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
						updateRankest(next,intervalWeek,newRank,oldRank);
					}
				}else{
					//...
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
	private void updateRankest(Individualrank individualrank,int intervalWeek,int newRank,int oldRank) throws Exception{
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
					individualrankest.setNo1weeks(individualrankest.getNo1weeks().intValue()+intervalWeek);
					individualrankest.setNo1continuousweeks(individualrankest.getNo1continuousweeks().intValue()+intervalWeek);
					if(individualrankest.getNo1continuousweeks().compareTo(individualrankest.getNo1longestcontinuousweeks())>0){
						//连续第一周数大于最长连续第一周数
						individualrankest.setNo1longestcontinuousweeks(individualrankest.getNo1continuousweeks());
					}else{
						//连续第一周数小于最长连续第一周数
					}
					individualrankest.setNo1continuousweeks(0);
				}else{
					//上周排名不是第一
				}
			}else{
				//当前新的排名是第一
				if(oldRank==1){
					//上期排名第一]
					individualrankest.setNo1weeks(individualrankest.getNo1weeks().intValue()+intervalWeek);
					individualrankest.setNo1continuousweeks(individualrankest.getNo1continuousweeks().intValue()+intervalWeek);
				}else{
					//上周排名不是第一
					individualrankest.setNo1continuousweeks(0);
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
			individualrankest.setNo1weeks(0);
			individualrankest.setNo1continuousweeks(0);
			individualrankest.setNo1longestcontinuousweeks(0);
			individualrankestService.insertOne(individualrankest);
		}
	}
}
 