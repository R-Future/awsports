package com.awsports.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.Individualpoint;
import com.awsports.pojo.Punishment;
import com.awsports.pojo.Qualificationrank;
import com.awsports.pojo.QualificationrankQuery;
import com.awsports.pojo.TournamentQuery;
import com.awsports.pojo.UserQuery;
import com.awsports.service.IndividualpointService;
import com.awsports.service.PunishmentService;
import com.awsports.service.QualificationrankService;
import com.awsports.service.TournamentService;
import com.awsports.service.UserService;
import com.awsports.util.CustomDate;
import com.awsports.util.CustomException;
import com.awsports.util.QualificationrankComparator;
import com.awsports.util.TypeMap;

/**
 * 
 * @Version: 0.1.4
 * @Author: peRFect
 * @Date: 2017年7月15日 下午10:19:03
 * @Description: 资格赛排名
 *
 */
@Controller
@RequestMapping("/qualificationrank")
public class QualificationrankController {
	
	@Autowired
	private QualificationrankService qualificationrankService;
	@Autowired
	private UserService userService;
	@Autowired
	private IndividualpointService individualpointService;
	@Autowired
	private PunishmentService punishmentService;
	@Autowired
	private TournamentService tournamentService;
	
	private double totalPoints;
	private int totalMatchs;
	private int totalWins;
	private int totalMarginBureaus;
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月15日 下午10:19:22
	 * @param model
	 * @param qualificationrankQuery
	 * @return
	 * @throws Exception
	 * @Return: String
	 * @Description: 排名列表
	 *
	 */
	@RequestMapping("/list")
	public String list(Model model, QualificationrankQuery qualificationrankQuery) throws Exception{
		List<QualificationrankQuery> qualificationrankQuerys = qualificationrankService.findAll(qualificationrankQuery);
		model.addAttribute("qualificationrankQuerys", qualificationrankQuerys);
		//获取性别类型
		model.addAttribute("sexTypes", TypeMap.sexType());
		//获取赛事信息
		List<TournamentQuery> tournamentQuerys = tournamentService.findAll(null); 
		model.addAttribute("tournamentQuerys", tournamentQuerys);
		return "qualificationrank/list";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月15日 下午10:21:21
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 * @Return: String
	 * @Description: 更新或新增排名记录
	 *
	 */
	@RequestMapping("/update")
	public String update(Model model, Integer id) throws Exception{
		Qualificationrank qualificationrank=null;
		if(id!=null){
			//更新数据
			qualificationrank=qualificationrankService.findById(id);
		}else{
			//添加数据
			qualificationrank=new Qualificationrank();
		}
		model.addAttribute("qualificationrank", qualificationrank);
		//获取用户名
		List<UserQuery> userQuerys=userService.findAll(null);
		model.addAttribute("userQuerys", userQuerys);
		//获取赛事信息
		List<TournamentQuery> tournamentQuerys = tournamentService.findAll(null); 
		model.addAttribute("tournamentQuerys", tournamentQuerys);
		return "qualificationrank/update";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月15日 下午10:24:25
	 * @param qualificationrank
	 * @param br
	 * @param model
	 * @return
	 * @throws Exception
	 * @Return: String
	 * @Description: 保存修改后记录
	 *
	 */
	@RequestMapping("/save")
	public String save(@Validated Qualificationrank qualificationrank, BindingResult br,Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "forward:update";
		}else{
			CustomDate customDate=new CustomDate();
			qualificationrank.setYear(customDate.getYear());
			qualificationrank.setWeek(customDate.getWeek());
			if(qualificationrank.getId()!=null){
				//更新数据
				qualificationrankService.updateById(qualificationrank);
			}else{
				//添加数据
				qualificationrankService.insertOne(qualificationrank);
			}
			return "redirect:list";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月15日 下午10:25:55
	 * @param id
	 * @return
	 * @throws Exception
	 * @Return: String
	 * @Description: 删除某个排名记录
	 *
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{	
			qualificationrankService.deleteById(id);
			return "redirect:list";
		}
	}
	
	@RequestMapping("/updateRank")
	public String updateRank(Integer[] tournamentids) throws Exception{
		if(tournamentids == null || tournamentids.length == 0){
			throw new CustomException("未注明要更新的参赛类型（如男单，女单等）！");
		}else{
			List<Individualpoint> individualpoints = null;
			//获取当前年份和周
			CustomDate customDate=new CustomDate();
			//用于查询数据库的查询条件
			Individualpoint individualpoint=new Individualpoint();
			individualpoint.setYear(customDate.getYear());
			//individualpoint.setLastYear(customDate.getYear()-1);
			//individualpoint.setWeek(customDate.getWeek());
			//更新排名
			for(Integer tournamentid:tournamentids){
				individualpoint.setTournamentid(tournamentid);
				individualpoints = individualpointService.findByTournamentidYearWeek(individualpoint);
				if(individualpoints==null||individualpoints.size()<=0){
					continue;
				}else{
					//更新个人排名
					int userid=individualpoints.get(0).getUserid().intValue();
					//初始化变量
					initializer();
					//临时存储计算后的用户排名记录，用于排序
					List<Qualificationrank> rawRanks=new ArrayList<Qualificationrank>();
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
								Qualificationrank qualificationrank=new Qualificationrank();
								qualificationrank.setUserid(userid);
								qualificationrank.setTournamentid(tournamentid);
								qualificationrank=qualificationrankService.findByUseridTournamentid(qualificationrank);
								if(qualificationrank==null||qualificationrank.getInvalid().booleanValue()){//无记录
									qualificationrank=new Qualificationrank();
									qualificationrank.setUserid(userid);
									qualificationrank.setTournamentid(tournamentid);			
								}
								//扣除个人退赛扣分
								Punishment punishment=new Punishment();
								punishment.setUserid(userid);
								punishment.setTournamentid(tournamentid);
								punishment.setCurrentYear(customDate.getYear());
								punishment.setInvalid(false);
								Integer punishmentPoints=punishmentService.findSumByUseridTournamentidYear(punishment);
								if(punishmentPoints!=null){
									//存在退赛记录
									totalPoints-=punishmentPoints.intValue();
								}else{
									//...
								}
								
								qualificationrank.setTotalpoint(totalPoints);
								qualificationrank.setTotalmatchs(totalMatchs);
								qualificationrank.setTotalmarginbureau(totalMarginBureaus);
								qualificationrank.setTotalwins(totalWins);
//								qualificationrank.setRankingchange(0);
								//更新年份和周，即每项赛事每个用户在数据库中只有一条记录
								qualificationrank.setYear(customDate.getYear());
								qualificationrank.setWeek(customDate.getWeek());
								rawRanks.add(qualificationrank);
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
					Qualificationrank finalUser=new Qualificationrank();
					finalUser.setUserid(userid);
					finalUser.setTournamentid(tournamentid);
					finalUser=qualificationrankService.findByUseridTournamentid(finalUser);
					if(finalUser==null||finalUser.getInvalid().booleanValue()){//无记录
						finalUser=new Qualificationrank();
						finalUser.setUserid(userid);
						finalUser.setTournamentid(tournamentid);						
//						qualificationrank.setRankingchange(0);						
					}else{
						//...
					}
					//扣除个人退赛扣分
					Punishment punishment=new Punishment();
					punishment.setUserid(userid);
					punishment.setTournamentid(tournamentid);
					punishment.setCurrentYear(customDate.getYear());
					punishment.setInvalid(false);
					Integer punishmentPoints=punishmentService.findSumByUseridTournamentidYear(punishment);
					if(punishmentPoints!=null){
						//存在退赛记录
						totalPoints-=punishmentPoints.intValue();
					}else{
						//...
					}
					finalUser.setTotalpoint(totalPoints);
					finalUser.setTotalmatchs(totalMatchs);
					finalUser.setTotalmarginbureau(totalMarginBureaus);
					finalUser.setTotalwins(totalWins);
					finalUser.setYear(customDate.getYear());
					finalUser.setWeek(customDate.getWeek());
					rawRanks.add(finalUser);
					
					//排序
					QualificationrankComparator qualificationrankComparator=new QualificationrankComparator();
					Collections.sort(rawRanks,qualificationrankComparator);
					if(rawRanks.size()>0){
						
						//排名第一的用户
						Qualificationrank first=(Qualificationrank)rawRanks.get(0);
						int newRank=1;
						int oldRank=0;
						if(first.getId()!=null){
							//更新记录
							//统计排名变化
							oldRank=first.getCurrentrank().intValue();
							first.setRankingchange(oldRank-newRank);
							//更新排名
							first.setCurrentrank(newRank);
							qualificationrankService.updateById(first);
						}else{
							//添加记录
							oldRank=0;
							first.setRankingchange(0);
							first.setCurrentrank(newRank);
							qualificationrankService.insertOne(first);
						}
						//更新排名‘最’记录
						//updateRankest(first,newRank,oldRank);

						//重置其它用户排名
						Qualificationrank last=null;
						Qualificationrank next=null;
						for(int i=1;i<rawRanks.size();i++){
							last=(Qualificationrank)rawRanks.get(i-1);
							next=(Qualificationrank)rawRanks.get(i);
							//对同排名进行处理
							if(qualificationrankComparator.compare(last, next)==0){
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
								qualificationrankService.updateById(next);
							}else{
								//之前无排名
								oldRank=0;
								next.setRankingchange(0);
								next.setCurrentrank(newRank);
								qualificationrankService.insertOne(next);
							}
							//更新排名‘最’记录
							//updateRankest(next,newRank,oldRank);
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
	 * @Datetime: 2017年7月15日 下午10:49:20
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

}
