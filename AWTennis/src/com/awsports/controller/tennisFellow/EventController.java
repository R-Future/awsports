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

import com.awsports.pojo.Event;
import com.awsports.pojo.EventPlayer;
import com.awsports.pojo.EventQuery;
import com.awsports.pojo.EventWorker;
import com.awsports.pojo.SinglesMatch;
import com.awsports.pojo.SinglesMatchQuery;
import com.awsports.pojo.User;
import com.awsports.service.EventPlayerService;
import com.awsports.service.EventService;
import com.awsports.service.EventWorkerService;
import com.awsports.service.SinglesMatchService;
import com.awsports.service.UserService;
import com.awsports.util.CustomException;

/**
 * 
 * @Company: aiwangsports.com
 * @Version: 1.1
 * @Author: peRFect
 * @Date: 2018年7月7日 下午1:51:23
 * @Package: com.awsports.controller
 * @Description: the management of events
 *
 */
@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private UserService userService;
	@Autowired
	private EventPlayerService eventPlayerService;
	@Autowired
	private EventWorkerService eventWorkerService;
	@Autowired
	private SinglesMatchService matchRecordService;
	
	//log
	private Log logger = LogFactory.getLog(getClass()); 
	private String logPrefix = "class[EventController], ";
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月7日 下午7:52:00
	 * @param model
	 * @param eventQuery
	 * @throws Exception
	 * @Return: String
	 * @Description: get all events 
	 *
	 */
	@RequestMapping(value="/list", method={RequestMethod.GET})
	public String list(Model model, EventQuery eventQuery) throws Exception {
		logPrefix += "method[public String list(Model model, EventQuery eventQuery)], ";
		List<EventQuery> eventQuerys = eventService.findAll(eventQuery);
		logger.info(logPrefix+"eventQuery info: "+eventQuerys.toString());
		model.addAttribute("eventQuerys", eventQuerys);
		return "event/list";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月8日 下午5:17:42
	 * @param model
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: show detail of event 
	 *
	 */
	@RequestMapping(value="detail")
	public String detail(Model model, Integer id) throws Exception {
		logPrefix += "method[public String detail(Model model, Integer id)], ";
		if(id == null){
			logger.info(logPrefix+"parameter[id = null], invaild query");
			throw new CustomException("invalid query");
		}else{
			EventQuery eventQuery = eventService.findById(id);
			Event event = eventQuery.getEvent();
			logger.info(logPrefix+"event info: "+event.toString());
			List<EventPlayer> eventPlayers = eventPlayerService.findByEventId(id);
			logger.info(logPrefix+"player info: "+eventPlayers.toString());
			List<EventWorker> eventWorkers = eventWorkerService.findByEventId(id);
			logger.info(logPrefix+"worker info: "+eventWorkers.toString());
			
			User userPublisher = eventQuery.getUserPublisher();
			User userContact = eventQuery.getUserContact();
			
			SinglesMatch conditions = new SinglesMatch();
			//singles match
			conditions.setEventid(event.getId());
			conditions.setType("singlesmatch");
			List<SinglesMatchQuery> singlesMatchs = matchRecordService.findByConditions(conditions);
			//doubles match
			conditions.setType("doublesmatch");
			List<SinglesMatchQuery> doublesMatchs = matchRecordService.findByConditions(conditions);
			
			model.addAttribute("event", event);
			model.addAttribute("userPublisher", userPublisher);
			model.addAttribute("userContact", userContact);
			model.addAttribute("eventPlayers", eventPlayers);
			model.addAttribute("eventWorkers", eventWorkers);
			model.addAttribute("singlesMatchs", singlesMatchs);
			model.addAttribute("doublesMatchs", doublesMatchs);
			return "event/detail";
		}

	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月7日 下午7:52:28
	 * @param model
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: update event 
	 *
	 */
	@RequestMapping(value="/update")
	public String update(Model model, Integer id) throws Exception {
		Event event;
		if(id!=null){
			//update event
			event = eventService.findById(id).getEvent();
		}else{
			//add a new event
			event = new Event();
		}
		model.addAttribute("event", event);
		model.addAttribute("userQuerys", userService.findAll(null));
		return "event/update";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月7日 下午7:52:49
	 * @param event
	 * @param br
	 * @param model
	 * @throws Exception
	 * @Return: String
	 * @Description: save the modified event
	 *
	 */
	@RequestMapping(value="/save")
	public String save(@Validated Event event, BindingResult br, Model model) throws Exception {
		if(br.hasErrors()){
			//there is something invalid when validating the variables input by user
			model.addAttribute("errors", br);
			model.addAttribute("id", event.getId());
			return "forward:update";
		}else{
			if(event.getId()!=null){
				//update event
				eventService.updateById(event);
			}else{
				//add a new one
				eventService.insertOne(event);
			}
		}
		return "redirect:list";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月7日 下午7:53:09
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: delete event by id
	 *
	 */
	@RequestMapping(value="/delete")
	public String delete(Integer id) throws Exception {
		if(id==null){
			throw new CustomException("非法操作，删除失败！");
		}else{
			eventService.deleteById(id);
		}
		return "redirect:list";
	}
}
