package com.awsports.controller.tennisFellow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.MatchStatistic;
import com.awsports.pojo.Statistic;
import com.awsports.pojo.StatisticQuery;
import com.awsports.service.StatisticService;
import com.awsports.service.UserService;
import com.awsports.util.CustomException;

@Controller
@RequestMapping("/statistic")
public class StatisticController {
	
	@Autowired
	private StatisticService statisticService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/update")
	public String update(Model model, Integer eventId, String matchId, Integer homeId, Integer guestId) throws Exception {
		if(eventId==null||matchId==null||homeId==null||guestId==null){
			throw new CustomException("Please select a match firstly!");
		}else{
			StatisticQuery homeStatistic;
			StatisticQuery guestStatistic;
			//update a record
			Statistic condition = new Statistic();
			condition.setMatchid(matchId);

			if(statisticService.findByMatchMirror(matchId).isEmpty()){
				//add a new record				
				homeStatistic = new StatisticQuery();
				condition.setUserid(homeId);
				homeStatistic.setStatistic(condition);
				homeStatistic.setUser(userService.findById(homeId));
				
				guestStatistic = new StatisticQuery();
				condition.setUserid(guestId);
				guestStatistic.setStatistic(condition);
				guestStatistic.setUser(userService.findById(guestId));
			}else{
				condition.setUserid(homeId);
				homeStatistic = statisticService.findByCondition(condition).get(0);
				
				condition.setUserid(guestId);
				guestStatistic = statisticService.findByCondition(condition).get(0);
			}
			MatchStatistic matchStatistic = new MatchStatistic();
			matchStatistic.setHomeStatistic(homeStatistic);
			matchStatistic.setGuestStatistic(guestStatistic);
			model.addAttribute("matchStatistic", matchStatistic);
			model.addAttribute("eventId", eventId);
			return "statistic/update";
		}
	}
	
	@RequestMapping(value="/save")
	public String save(@Validated MatchStatistic matchStatistic, Integer eventId, BindingResult br, Model model) throws Exception {
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			model.addAttribute("matchId", matchStatistic.getHomeStatistic().getStatistic().getMatchid());
			model.addAttribute("home", matchStatistic.getHomeStatistic().getUser());
			model.addAttribute("guest", matchStatistic.getGuestStatistic().getUser());
			return "forward:update";
		}else{
			if(matchStatistic.getHomeStatistic().getStatistic().getId()==null&&matchStatistic.getGuestStatistic().getStatistic().getId()==null){
				//add a new record
				statisticService.insertOne(matchStatistic.getHomeStatistic().getStatistic());
				statisticService.insertOne(matchStatistic.getGuestStatistic().getStatistic());
			}else{
				//update record
				statisticService.updateById(matchStatistic.getHomeStatistic().getStatistic());
				statisticService.updateById(matchStatistic.getGuestStatistic().getStatistic());
			}
			model.addAttribute("matchId", matchStatistic.getHomeStatistic().getStatistic().getMatchid());
			model.addAttribute("eventId", eventId);
			model.addAttribute("homeId", matchStatistic.getHomeStatistic().getUser().getId());
			model.addAttribute("guestId", matchStatistic.getGuestStatistic().getUser().getId());
			return "forward:update";
		}
	}
	
	
}
