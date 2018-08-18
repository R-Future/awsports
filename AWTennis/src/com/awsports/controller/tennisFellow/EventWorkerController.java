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

import com.awsports.pojo.EventWorker;
import com.awsports.pojo.User;
import com.awsports.pojo.UserQuery;
import com.awsports.service.EventWorkerService;
import com.awsports.service.UserService;
import com.awsports.util.CustomException;

/**
 * 
 * @Company: aiwangsports.com
 * @Version: 
 * @Author: peRFect
 * @Date: 2018年7月8日 下午6:11:58
 * @Package: com.awsports.controller.tennisFellow
 * @Description: some operations on table aw_event_worker
 *
 */
@Controller
@RequestMapping("/eventWorker")
public class EventWorkerController {
	
	@Autowired
	private EventWorkerService eventWorkerService;
	@Autowired
	private UserService userService;
	
	//log
	private Log logger = LogFactory.getLog(getClass());
	private String logPrefix = "class[EventWorkerController], ";
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月8日 下午6:10:32
	 * @param model
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: update a record by id
	 *
	 */
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(Model model, Integer id, Integer eventId) throws Exception {
		logPrefix += "method[public String update(Model model, Integer id)], ";
		EventWorker eventWorker;
		if(id == null){
			//add a new one
			logger.info(logPrefix+"add a new worker for the event");
			eventWorker = new EventWorker();
			eventWorker.setEventid(eventId);
		}else{
			logger.info(logPrefix+"update a worker's info");
			eventWorker = eventWorkerService.findById(id);
		}
		List<UserQuery> userQuerys = userService.findAll(null);
		model.addAttribute("userQuerys", userQuerys);
		model.addAttribute("eventWorker", eventWorker);
		return "eventWorker/update";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月8日 下午6:11:08
	 * @param eventWorker
	 * @param br
	 * @param model
	 * @throws Exception
	 * @Return: String
	 * @Description: save the modification of a record
	 *
	 */
	@RequestMapping(value="/save")
	public String save(@Validated EventWorker eventWorker, BindingResult br, Model model) throws Exception {
		logPrefix += "method[public String save(@Validated EventWorker eventWorker, BindingResult br, Model model)], ";
		if(br.hasErrors()){
			logger.info(logPrefix+"fail to validate: "+br.toString());
			model.addAttribute("errors", br);
			return "forward:update";
		}else{
				
			User user = userService.findById(eventWorker.getUserid());
			eventWorker.setUsername(user.getName());
			eventWorker.setUseravatar(user.getPortrait());
			
			if(eventWorker.getId() == null){
				//add a new one
				eventWorkerService.insertOne(eventWorker);
			}else{
				eventWorkerService.updateById(eventWorker);
			}

			logger.info(logPrefix+"update event worker: "+eventWorker.toString());
			model.addAttribute("id", eventWorker.getEventid());
			return "redirect:/event/detail";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月8日 下午6:11:25
	 * @param model
	 * @param id
	 * @param eventId
	 * @throws Exception
	 * @Return: String
	 * @Description: delete a record by id, and redirect to event/detail.jsp
	 *
	 */
	@RequestMapping(value="/delete")
	public String delete(Model model, Integer id, Integer eventId) throws Exception {
		logPrefix += "method[public String delete(Model model, Integer id, Integer eventId)], ";
		if(id == null){
			logger.info(logPrefix+"parameter[id = null], invalid delete");
			throw new CustomException("Fail to delete a record! Please check ...");
		}else{
			eventWorkerService.deleteById(id);
			model.addAttribute("id", eventId);
			return "redirect:/event/detail";
		}
	}
	
}
