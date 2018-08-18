package com.awsports.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.Individualpoint;
import com.awsports.pojo.TournamentQuery;
import com.awsports.pojo.UserQuery;
import com.awsports.service.IndividualpointService;
import com.awsports.service.TournamentService;
import com.awsports.service.UserService;
import com.awsports.util.CustomDate;
import com.awsports.util.TypeMap;

@Controller
@RequestMapping("/award")
public class AwardController {
	
	@Autowired
	private IndividualpointService individualpointService;
	@Autowired
	private UserService userService;
	@Autowired
	private TournamentService tournamentService;
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年8月20日 下午4:05:09
	 * @param model
	 * @param userId
	 * @param matchTime
	 * @param tournamentId
	 * @param entry
	 * @param point
	 * @throws Exception
	 * @Return: String
	 * @Description: 比赛积分奖励，比如团赛获胜，每个队员奖励10分个人积分
	 *
	 */
	@RequestMapping("/addPoint")
	public String addPoint(Model model,Integer userId,String matchTime,Integer tournamentId,Integer entry,Integer point) throws Exception{
		List<UserQuery> userQuerys = userService.findAll(null);
		List<TournamentQuery> tournamentQuerys = tournamentService.findAll(null);
		Map<Integer,String> individualEntrys = TypeMap.individualEntryType();
		model.addAttribute("userQuerys", userQuerys);
		model.addAttribute("tournamentQuerys", tournamentQuerys);
		model.addAttribute("individualEntrys", individualEntrys);
		if(userId == null || matchTime == null || matchTime.isEmpty() ||tournamentId == null || entry == null || point == null){
//			throw new CustomException("非法操作，请确保输入参数正确...");
			return "award/addPoint";
		}else{
			CustomDate date = new CustomDate(matchTime+" 00:00:00");
			Individualpoint individualpoint = new Individualpoint();
			individualpoint.setUserid(userId);
			individualpoint.setYear(date.getYear());
			individualpoint.setWeek(date.getWeek());
			individualpoint.setEntry(entry);
			individualpoint.setTournamentid(tournamentId);
			individualpoint = individualpointService.findByUseridYearWeekTournamentidEntry(individualpoint);
			if(individualpoint != null){
				individualpoint.setPoints(individualpoint.getPoints().intValue() + point);
				individualpointService.updateById(individualpoint);
				model.addAttribute("hint", "积分更新成功");
				return "award/addPoint";
			}else{
				model.addAttribute("hint", "未找到记录，请确保输入参数正确");
				return "award/addPoint";
			}
		}
	}
}
