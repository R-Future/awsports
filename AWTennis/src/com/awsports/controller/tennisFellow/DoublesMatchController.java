package com.awsports.controller.tennisFellow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.DoublesMatch;
import com.awsports.pojo.Team;
import com.awsports.service.DoublesMatchService;
import com.awsports.service.StatisticService;
import com.awsports.service.TeamService;
import com.awsports.util.CustomException;

@Controller
@RequestMapping("/doublesMatch")
public class DoublesMatchController {
	
	@Autowired
	private DoublesMatchService doublesMatchService;
	@Autowired
	private StatisticService statisticService;
	@Autowired
	private TeamService teamService;
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月13日 下午11:25:15
	 * @param model
	 * @param id
	 * @param eventId
	 * @throws Exception
	 * @Return: String
	 * @Description: update or add a record
	 *
	 */
	@RequestMapping(value="/update")
	public String update(Model model, Integer id, Integer eventId) throws Exception {
		DoublesMatch doublesMatch;
		if(id == null){
			//add a new record
			doublesMatch = new DoublesMatch();
			if(eventId != null){
				doublesMatch.setEventid(eventId);
			}else{
				throw new CustomException("Does this match belong to an event? Please confirm ...");
			}
		}else{
			//update a record
			doublesMatch = doublesMatchService.findById(id);
		}

		List<Team> teams = teamService.findByEventId(eventId);
		
		model.addAttribute("doublesMatch", doublesMatch);
		model.addAttribute("players", teams);
		
		return "doublesMatch/update";
	}

	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月13日 下午11:25:43
	 * @param doublesMatch
	 * @param br
	 * @param model
	 * @throws Exception
	 * @Return: String
	 * @Description: save the modified record, and redirect to event/detail
	 *
	 */
	@RequestMapping(value="/save")
	public String save(@Validated DoublesMatch doublesMatch, BindingResult br, Model model) throws Exception {
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "forward:update";
		}else{
			if(doublesMatch.getId() == null){
				//add a new record
				doublesMatchService.insertOne(doublesMatch);
			}else{
				//update a record
				doublesMatchService.updateById(doublesMatch);
			}
			model.addAttribute("id", doublesMatch.getEventid());
			return "redirect:event/detail";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月13日 下午11:26:01
	 * @param model
	 * @param id
	 * @param eventId
	 * @throws Exception
	 * @Return: String
	 * @Description: delete a record by id and redirect to event/detail
	 *
	 */
	@RequestMapping(value="/delete")
	public String delete(Model model, Integer id, Integer eventId) throws Exception {
		if(id == null){
			throw new CustomException("Fail to delete a record! Please check ...");
		}else{
			DoublesMatch doublesMatch = doublesMatchService.findById(id);
			statisticService.deleteByMatchMirror(doublesMatch.getMirror());
			doublesMatchService.deleteByMirror(doublesMatch.getMirror());;
			model.addAttribute("id", eventId);
			return "redirect:event/detail";
		}
	}
}
