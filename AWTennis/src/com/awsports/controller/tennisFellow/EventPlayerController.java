package com.awsports.controller.tennisFellow;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awsports.pojo.EventPlayer;
import com.awsports.pojo.User;
import com.awsports.pojo.UserQuery;
import com.awsports.service.EventPlayerService;
import com.awsports.service.UserService;
import com.awsports.util.CustomException;

/**
 * 
 * @Company: aiwangsports.com
 * @Version: 
 * @Author: peRFect
 * @Date: 2018年7月8日 下午6:12:55
 * @Package: com.awsports.controller.tennisFellow
 * @Description: some operations on table aw_event_player
 *
 */
@Controller
@RequestMapping("/eventPlayer")
public class EventPlayerController {
	
	@Autowired
	private EventPlayerService eventPlayerService;
	@Autowired
	private UserService userService;
	
	//log
	private Log logger = LogFactory.getLog(getClass());
	private String logPrefix = "class[EventPlayerController], ";
	
//	@RequestMapping(value="/playerList", method=RequestMethod.GET)
//	public String playerList(Model model, Integer eventId) throws Exception {
//		logPrefix += "method[public String playerList(Model model, Integer eventId)], ";
//		if(eventId == null){
//			logger.info(logPrefix+"parameter[eventId = null], invalid query");
//			throw new CustomException("invalid query!");
//		}else{
//			List<EventPlayer> players = eventPlayerService.findByEventId(eventId);
//			logger.info(logPrefix+"eventPlayerService.findByEventId(eventId)"+players.toString());
//			model.addAttribute("players", players);
//			return "eventPlayer/playerList";
//		}
//	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月8日 下午4:39:12
	 * @param model
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: update player of the match 
	 *
	 */
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(Model model, Integer id, Integer eventId) throws Exception {
		logPrefix += "method[public String update(Model model, Integer id)], ";
		EventPlayer eventPlayer;
		if(id == null){
			//add new one
			logger.info(logPrefix+"add a new player for the event");
			eventPlayer = new EventPlayer();
			eventPlayer.setEventid(eventId);
		}else{
			//update
			logger.info(logPrefix+"update a player's information in the event");
			eventPlayer = eventPlayerService.findById(id);
		}
		List<UserQuery> userQuerys= userService.findAll(null);
		model.addAttribute("eventPlayer", eventPlayer);
		model.addAttribute("userQuerys", userQuerys);
		return "eventPlayer/update";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月8日 下午4:39:41
	 * @param eventPlayer
	 * @param br
	 * @param model
	 * @throws Exception
	 * @Return: String
	 * @Description: save the modification of a record
	 *
	 */
	@RequestMapping(value="/save")
	public String save(@Validated EventPlayer eventPlayer, BindingResult br, Model model) throws Exception {
		logPrefix += "method[public String save(@Validated EventPlayer eventPlayer, BindingResult br, Model model)], ";
		if(br.hasErrors()){
			logger.info(logPrefix+"fail to validate some variables, "+br.toString());
			model.addAttribute("errors", br);
			return "forward:upate";
		}else{
			
			User user = userService.findById(eventPlayer.getUserid());
			eventPlayer.setUsername(user.getName());
			eventPlayer.setUseravatar(user.getPortrait());
			
			if(eventPlayer.getId() == null){
				//add a new one
				eventPlayerService.insertOne(eventPlayer);
			}else{
				//update
				eventPlayerService.updateById(eventPlayer);
			}
			logger.info(logPrefix+"update, "+eventPlayer.toString());
			model.addAttribute("id", eventPlayer.getEventid());
			return "redirect:/event/detail";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月8日 下午4:40:07
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: delete a record by id and redirect to event/detail
	 *
	 */
	@RequestMapping(value="/delete")
	public String delete(Model model, Integer id, Integer eventId) throws Exception {
		logPrefix += "method[public String delete(Integer id)], ";
		if(id == null){
			logger.info(logPrefix+"parameter[id = null], invalid delete");
			throw new CustomException("Fail to delete a record! Please check ...");
		}else{
			eventPlayerService.deleteById(id);
			logger.info(logPrefix+"delete one player in the match id = "+id.toString());
			model.addAttribute("id", eventId);
			return "redirect:/event/detail";
		}

	}
	
}
