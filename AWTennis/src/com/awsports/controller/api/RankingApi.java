package com.awsports.controller.api;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awsports.pojo.Individualrank;
import com.awsports.pojo.IndividualrankQuery;
import com.awsports.pojo.Teamrank;
import com.awsports.pojo.TeamrankQuery;
import com.awsports.service.IndividualrankService;
import com.awsports.service.TeamrankService;
import com.awsports.util.EntryEnum;
import com.awsports.util.MD5;
import com.awsports.util.StatusEnum;
import com.awsports.util.TypeMap;

@Controller
@RequestMapping("/api/ranking")
public class RankingApi extends BaseApi {

	@Autowired
	private IndividualrankService individualrankService;
	@Autowired
	private TeamrankService teamrankService;
	
	protected void initialize(){
		super.initialize();
	}
	
	protected void respond(HttpServletResponse response){
		super.respond(response);
	}
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年11月14日 下午9:19:00
	 * @param year
	 * @param entry
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 获取排名
	 *
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public void getRank(Integer year, Integer entry, String sign, HttpServletRequest request, HttpServletResponse response){
		
		this.initialize();
		
		if(entry == null){
			//entry是必选参数
			msg = INVALID_REQUEST;
			status = StatusEnum.INVALID_REQUEST.getValue();
			error = "entry is missing";
		}else{
			if(sign == null){
				//非法请求
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
				error = "sign is missing";
			}else{
				int currentYear = date.getYear();

				//默认查询最新排名
				if(year == null){
					mySign = MD5.Encode("entry="+entry+"&token="+token).toUpperCase();
					year = currentYear;
				}else{
					mySign = MD5.Encode("entry="+entry+"&year="+year+"&token="+token).toUpperCase();
				}
				//如果当前周为当年第一周，则最新排名在去年最后一周
				if(date.getWeek() == 1){
					year--;
				} 
				//验证参数合法性，是否被篡改
				if(!mySign.equals(sign)){
					msg = INVALID_REQUEST;
					status = StatusEnum.INVALID_REQUEST.getValue();
					error = "verfication failed";
				}else{
					//参数校验通过
					getRankCore(year,entry);
				}
			}
		}
		//响应请求
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年11月14日 下午10:19:13
	 * @param year
	 * @param entry
	 * @Return: void
	 * @Description: 获取排名信息
	 *
	 */
	private void getRankCore(int year, int entry){
		int rankingWeek;
		HashMap<String, Object> rankInfo;
		if(entry <= EntryEnum.DOUBLEWOMANINDIVIDUAL.getValue().intValue()){
			//查询个人排名
			Individualrank condition = new Individualrank();
			condition.setYear(year);
			condition.setEntry(entry);
			IndividualrankQuery individualrankQuery = new IndividualrankQuery();
			individualrankQuery.setIndividualrank(condition);
			try {
				List<IndividualrankQuery> individualrankQuerys = individualrankService.findAll(individualrankQuery);
				if(individualrankQuerys != null){
					//查询数据成功
					data.clear();
					rankingWeek = individualrankQuerys.get(0).getIndividualrank().getWeek();
					for(IndividualrankQuery irq : individualrankQuerys){
						//只显示当前活跃球员
						if(rankingWeek == irq.getIndividualrank().getWeek().intValue()){
							rankInfo = new HashMap<String, Object>(); 
							rankInfo.put("player", irq.getUserQuery().getUser().getName());
							rankInfo.put("sex", TypeMap.sexType().get(irq.getUserQuery().getUser().getSex()));
							rankInfo.put("group", irq.getUserQuery().getLevel().getChinese());
							rankInfo.put("rankingChange", irq.getIndividualrank().getRankingchange());
							rankInfo.put("currentRank", irq.getIndividualrank().getCurrentrank());
							rankInfo.put("totalMarginbureau", irq.getIndividualrank().getTotalmarginbureau());
							rankInfo.put("totalMatchs", irq.getIndividualrank().getTotalmatchs());
							rankInfo.put("wins", irq.getIndividualrank().getWins());
							rankInfo.put("winningProbability", String.format("%.2f",(irq.getIndividualrank().getWins().doubleValue()/irq.getIndividualrank().getTotalmatchs().doubleValue())*100)+"%");
							rankInfo.put("totalPoint", irq.getIndividualrank().getTotalpoint());
							data.add(rankInfo);
						}
					}
					msg = GET_SUCCESS;
					status = StatusEnum.GET_SUCCESS.getValue();
				}else{
					//未查询到数据
					status = StatusEnum.NOT_FOUND.getValue();
					msg = NOT_FOUND;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("数据库访问异常");
			}
		}else{
			//查询组合排名
			Teamrank condition = new Teamrank();
			condition.setYear(year);
			condition.setEntry(entry);
			TeamrankQuery teamrankQuery = new TeamrankQuery();
			teamrankQuery.setTeamrank(condition);
			try {
				List<TeamrankQuery> teamrankQuerys = teamrankService.findAll(teamrankQuery);
				if(teamrankQuerys != null){
					//查询数据成功
					data.clear();
					rankingWeek = teamrankQuerys.get(0).getTeamrank().getWeek();
					for(TeamrankQuery trq : teamrankQuerys){
						//只显示当前活跃球员
						if(rankingWeek == trq.getTeamrank().getWeek().intValue()){
							rankInfo = new HashMap<String, Object>();
							rankInfo.put("player", trq.getTeam().getName());
							rankInfo.put("sex", TypeMap.entryType().get(trq.getTeam().getEntry()));
							rankInfo.put("rankingChange", trq.getTeamrank().getRankingchange());
							rankInfo.put("currentRank", trq.getTeamrank().getCurrentrank());
							rankInfo.put("totalMarginbureau", trq.getTeamrank().getTotalmarginbureau());
							rankInfo.put("totalMatchs", trq.getTeamrank().getTotalmatchs());
							rankInfo.put("wins", trq.getTeamrank().getWins());
							rankInfo.put("winningProbability", String.format("%.2f", (trq.getTeamrank().getWins().doubleValue()/trq.getTeamrank().getTotalmatchs().doubleValue())*100)+"%");
							rankInfo.put("totalPoint", trq.getTeamrank().getTotalpoint().intValue());
							data.add(rankInfo);
						}
					}
					msg = GET_SUCCESS;
					status = StatusEnum.GET_SUCCESS.getValue();
				}else{
					//未查询到数据
					status = StatusEnum.NOT_FOUND.getValue();
					msg = NOT_FOUND;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("数据库访问异常");
			}
		}
	}
}
