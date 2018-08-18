package com.awsports.controller.tennisFellow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.EventPlayer;
import com.awsports.pojo.SinglesMatch;
import com.awsports.service.EventPlayerService;
import com.awsports.service.SinglesMatchService;
import com.awsports.service.StatisticService;
import com.awsports.util.CustomException;

@Controller
@RequestMapping("/singlesMatch")
public class SinglesMatchController {
	
	@Autowired
	private SinglesMatchService singlesMatchService;
	@Autowired
	private StatisticService statisticService;
	@Autowired
	private EventPlayerService eventPlayerService;
	
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
		SinglesMatch singlesMatch;
		if(id == null){
			//add a new record
			singlesMatch = new SinglesMatch();
			if(eventId != null){
				singlesMatch.setEventid(eventId);
			}else{
				throw new CustomException("Does this match belong to an event? Please confirm ...");
			}
		}else{
			//update a record
			singlesMatch = singlesMatchService.findById(id);
		}

		List<EventPlayer> players = eventPlayerService.findByEventId(eventId);
		
		model.addAttribute("singlesMatch", singlesMatch);
		model.addAttribute("players", players);
		
		return "singlesMatch/update";
	}

	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月13日 下午11:25:43
	 * @param singlesMatch
	 * @param br
	 * @param model
	 * @throws Exception
	 * @Return: String
	 * @Description: save the modified record, and redirect to event/detail
	 *
	 */
	@RequestMapping(value="/save")
	public String save(@Validated SinglesMatch singlesMatch, BindingResult br, Model model) throws Exception {
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "forward:update";
		}else{
//			singlesMatch.setMirror(mirror);
			if(singlesMatch.getId() == null){
				//add a new record
				singlesMatchService.insertOne(singlesMatch);
			}else{
				//update a record
				singlesMatchService.updateById(singlesMatch);
			}
			model.addAttribute("id", singlesMatch.getEventid());
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
			SinglesMatch singlesMatch = singlesMatchService.findById(id);
			statisticService.deleteByMatchMirror(singlesMatch.getMirror());
			singlesMatchService.deleteByMirror(singlesMatch.getMirror());;
			model.addAttribute("id", eventId);
			return "redirect:event/detail";
		}
	}
}
