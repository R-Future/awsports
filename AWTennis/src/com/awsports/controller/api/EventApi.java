package com.awsports.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awsports.pojo.DoublesMatch;
import com.awsports.pojo.DoublesMatchQuery;
import com.awsports.pojo.Event;
import com.awsports.pojo.EventPlayer;
import com.awsports.pojo.EventQuery;
import com.awsports.pojo.EventWorker;
import com.awsports.pojo.SinglesMatch;
import com.awsports.pojo.SinglesMatchQuery;
import com.awsports.pojo.Statistic;
import com.awsports.pojo.StatisticQuery;
import com.awsports.pojo.User;
import com.awsports.service.DoublesMatchService;
import com.awsports.service.EventPlayerService;
import com.awsports.service.EventService;
import com.awsports.service.EventWorkerService;
import com.awsports.service.SinglesMatchService;
import com.awsports.service.StatisticService;
import com.awsports.service.TeamService;
import com.awsports.service.UserService;
import com.awsports.util.ResponseInfo;
import com.awsports.util.RegexPattern;
import com.awsports.util.StatusEnum;

@Controller
@RequestMapping("/api")
public class EventApi extends BaseApi {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private EventPlayerService eventPlayerService;
	@Autowired
	private EventWorkerService eventWorkerService;
	@Autowired
	private SinglesMatchService singlesMatchService;
	@Autowired
	private DoublesMatchService doublesMatchService;
	@Autowired
	private StatisticService statisticService;
	@Autowired
	private UserService userService;
	@Autowired
	private TeamService teamService;
	
	
	protected boolean verifyParam(HttpServletRequest request, String sign, HashMap<String, Object[]> params) {
		return super.verifyParam(request, sign, params);
	}
	
	protected Object setCondition(String className, HttpServletRequest request, HashMap<String, Object[]> params) throws Exception {
		return super.setCondition(className, request, params);
	}
	
	protected void initialize() {
		super.initialize();
	}
	
	protected void respond(HttpServletResponse response) {
		super.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 上午12:09:17
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: informations of event
	 *
	 */
	@RequestMapping(value="/events", method=RequestMethod.GET)
	public void getEvents(String sign, HttpServletRequest request, HttpServletResponse response){
		this.initialize();
		//计算md5
			//1. 判断参数是否参在
			//2. 验证参数是否符合要求
			//3. 对参数进行字典排序
			//5. 拼接参数，计算MD5
		//比较MD5值是否与sign一致，不一致返回错误信息，否则调取数据
		
		//all parameters of API
		//false, Pattern.compile(RegexPattern.INTEGER), "setPublisher", "Integer"
		//  |                      |                           |            |
		//isRequired,          validation,                set method, parameter type
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("publisher", new Object[]{false, Pattern.compile(RegexPattern.INTEGER), "setPublisher", "Integer"});
		params.put("year", new Object[]{false, Pattern.compile(RegexPattern.INTEGER), "setYear", "Integer"});
		
		//validate parameters successfully
		if(this.verifyParam(request, sign, params)){
			try {
				//通过反射机制获取condition
				//有可能因为无参数而导致condition=null		
				Event condition = (Event)setCondition(Event.class.getName(), request, params);
				EventQuery eventCond = null;
				if(null!=condition){
					eventCond = new EventQuery();
					eventCond.setEvent(condition);
				}
				try {
					List<EventQuery> eventQuerys = eventService.findAll(eventCond);
					if(null==eventQuerys)
					{
						super.status = StatusEnum.NOT_FOUND.getValue();
						super.msg = NOT_FOUND;
					}else{
						super.status = StatusEnum.GET_SUCCESS.getValue();
						super.msg = GET_SUCCESS;
						for(EventQuery eventQuery : eventQuerys){
							super.data.add(ResponseInfo.getEventInfo(eventQuery));
						}
					}
				} catch (Exception e) {
					//fail to query database
					super.error = "no record";
					super.msg = NOT_FOUND;
					super.status = StatusEnum.NOT_FOUND.getValue();
				}
			} catch (Exception e1) {
				//invalid request
				super.error = "invalid parameter";
				super.msg = INVALID_REQUEST;
				super.status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 下午10:06:01
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 更新或添加event
	 *
	 */
	@RequestMapping(value="/event", method=RequestMethod.POST)
	public void updateEvent(String sign, HttpServletRequest request, HttpServletResponse response){
		//initialize response
		this.initialize();
		
		//the parameters should be verified
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("id", new Object[]{false, Pattern.compile(RegexPattern.INTEGER), "setId", "Integer"});
		params.put("publisher", new Object[]{true, Pattern.compile(RegexPattern.INTEGER), "setPublisher", "Integer"});
		params.put("contact", new Object[]{true, Pattern.compile(RegexPattern.validateString(1, 15)), "setContact", "String"});
		params.put("contactInfo", new Object[]{false, Pattern.compile(RegexPattern.validateString(0, 255)), "setContactinfo", "String"});
		//封面.jpg/png/gif
		params.put("cover", new Object[]{false, null, "setCover", "String"});
		//赛事名称，字符长度和类型限制{60/字母，汉字，-}
		params.put("name", new Object[]{true, Pattern.compile(RegexPattern.validateString(1, 60)), "setName", "String"});
		//赛事地点，字符长度限制{300}
		params.put("place", new Object[]{true, Pattern.compile(RegexPattern.validateString(1, 300)), "setPlace", "String"});
		//赛事类型
		params.put("type", new Object[]{true, null, "setType", "String"});
		//主办方，字符长度限制{255}
		params.put("sponsor", new Object[]{false, Pattern.compile(RegexPattern.validateString(0, 255)), "setSponsor", "String"});
		params.put("detail", new Object[]{true, null, "setDetail", "String"});
		params.put("numberOfPlayer", new Object[]{true, Pattern.compile(RegexPattern.INTEGER), "setNumberofplayer", "Integer"});
		params.put("startTime", new Object[]{true, null, "setStarttime", "String"});
		params.put("endTime", new Object[]{true, null, "setEndtime", "String"});
		params.put("cost", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setCost", "Double"});
		params.put("enrollingTime", new Object[]{true, null, "setEnrollingtime", "String"});
		params.put("closingTime", new Object[]{true, null, "setClosingtime", "String"});
		params.put("draw", new Object[]{false, null, "setDraw", "String"});
		params.put("schedule", new Object[]{false, null, "setSchedule", "String"});
		params.put("note", new Object[]{false, null, "setNote", "String"});
		
		//verify parameters
		if(this.verifyParam(request, sign, params)){
			try {
				Event event = (Event)this.setCondition(Event.class.getName(), request, params);
				if(null!=event){
					if(null!=event.getId()){
						//update event
						eventService.updateById(event);
					}else{
						//create event
						eventService.insertOne(event);
					}
					msg = POST_SUCCESS;
					status = StatusEnum.POST_SUCCESS.getValue();
					data.add(ResponseInfo.getEventInfo(eventService.findById(event.getId())));
				}else{
					msg = INVALID_REQUEST;
					status = StatusEnum.INVALID_REQUEST.getValue();
				}
			} catch (Exception e) {
				//e.printStackTrace();
				error = e.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 下午10:06:59
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 删除event
	 *
	 */
	@RequestMapping(value="/event", method=RequestMethod.DELETE)
	public void deleteEvent(String sign, HttpServletRequest request, HttpServletResponse response){
		//initialize response
		this.initialize();
		
		//the parameters should be verified
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("id", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setId", "Integer"});
		
		//verify parameters
		if(this.verifyParam(request, sign, params)){
			try {
				Event event = (Event)this.setCondition(Event.class.getName(), request, params);
				if(null!=event){
					try {
						//delete worker
						eventWorkerService.deleteByEventId(event.getId());
						//delete player
						eventPlayerService.deleteByEventId(event.getId());
						//delete statistic
						List<SinglesMatchQuery> singlesMatchQuerys = singlesMatchService.findByEventId(event.getId());
						List<DoublesMatchQuery> doublesMatchQuerys = doublesMatchService.findByEventId(event.getId());
						if(null!=singlesMatchQuerys&&!singlesMatchQuerys.isEmpty()){
							for(SinglesMatchQuery singlesMatchQuery:singlesMatchQuerys){
								statisticService.deleteByMatchMirror(singlesMatchQuery.getSinglesMatch().getMirror());
							}
						}
						if(null!=doublesMatchQuerys&&!doublesMatchQuerys.isEmpty()){
							for(DoublesMatchQuery doublesMatchQuery:doublesMatchQuerys){
								statisticService.deleteByMatchMirror(doublesMatchQuery.getDoublesMatch().getMirror());
							}
						}
						//delete match
						singlesMatchService.deleteByEventId(event.getId());
						doublesMatchService.deleteByEventId(event.getId());
						//delete event
						eventService.deleteById(event.getId());
						//delete success
						msg = DELETE_SUCCESS;
						status = StatusEnum.DELETE_SUCCESS.getValue();
					} catch (Exception e) {
						//invalid request
						error = e.toString();
						msg = INVALID_REQUEST;
						status = StatusEnum.INVALID_REQUEST.getValue();
					}
				}else{
					//404 not found
					msg = NOT_FOUND;
					status = StatusEnum.NOT_FOUND.getValue();
				}
			} catch (Exception e1) {
				//invalid request
				error = e1.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 下午10:07:12
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 查询event的报名人员
	 *
	 */
	@RequestMapping(value="/event/players", method=RequestMethod.GET)
	public void getEventPlayers(String sign, HttpServletRequest request, HttpServletResponse response){
		//initialize response
		this.initialize();
		
		//the parameters should be verified
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("eventId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setEventid", "Integer"});
		
		//verify parameters
		if(this.verifyParam(request, sign, params)){
			try {
				EventPlayer condition = (EventPlayer)this.setCondition(EventPlayer.class.getName(), request, params);
				if(null!=condition){
					List<EventPlayer> eventPlayers = eventPlayerService.findByEventId(condition.getEventid());
					for(EventPlayer eventPlayer:eventPlayers){
						data.add(ResponseInfo.getEventPlayerInfo(eventPlayer));
					}
					msg = GET_SUCCESS;
					status = StatusEnum.GET_SUCCESS.getValue();
				}else{
					//not found
					msg = NOT_FOUND;
					status = StatusEnum.NOT_FOUND.getValue();
				}
			} catch (Exception e) {
				//invalid request
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 下午10:07:48
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 添加event的报名人员
	 *
	 */
	@RequestMapping(value="/event/player", method=RequestMethod.POST)
	public void updateEventPlayer(String sign, HttpServletRequest request, HttpServletResponse response){
		//initialize response
		this.initialize();
		
		//the parameters should be verified
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("eventId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setEventid", "Integer"});
		params.put("userId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setUserid", "Integer"});
		
		//verify parameters
		if(this.verifyParam(request, sign, params)){
			try {
				EventPlayer condition = (EventPlayer)this.setCondition(EventPlayer.class.getName(), request, params);
				if(null!=condition){
					User user = userService.findById(condition.getUserid());
					if(null!=user){
						//add a new player
						condition.setUsername(user.getName());
						condition.setUseravatar(user.getPortrait());
						eventPlayerService.insertOne(condition);
						msg = POST_SUCCESS;
						status = StatusEnum.POST_SUCCESS.getValue();
						data.add(ResponseInfo.getEventPlayerInfo(condition));
					}else{
						msg = NOT_FOUND;
						status = StatusEnum.NOT_FOUND.getValue();
					}
				}else{
					msg = NOT_FOUND;
					status = StatusEnum.NOT_FOUND.getValue();
				}
			} catch (Exception e) {
				error = e.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 下午10:09:15
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 删除event的参赛人员
	 *
	 */
	@RequestMapping(value="/event/player", method=RequestMethod.DELETE)
	public void deleteEventPlayer(String sign, HttpServletRequest request, HttpServletResponse response){
		//initialize response
		this.initialize();
		
		//the parameters should be verified
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("eventId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setEventid", "Integer"});
		params.put("id", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setId", "Integer"});
		
		//verify parameters
		if(this.verifyParam(request, sign, params)){
			try {
				EventPlayer condition = (EventPlayer)this.setCondition(EventPlayer.class.getName(), request, params);
				if(null!=condition){
					eventPlayerService.deleteById(condition.getId());
					msg = DELETE_SUCCESS;
					status = StatusEnum.DELETE_SUCCESS.getValue();
				}else{
					msg = NOT_FOUND;
					status = StatusEnum.NOT_FOUND.getValue();
				}
			} catch (Exception e) {
				error = e.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 下午10:09:40
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 查询event的工作人员
	 *
	 */
	@RequestMapping(value="/event/workers", method=RequestMethod.GET)
	public void getEventWorkers(String sign, HttpServletRequest request, HttpServletResponse response){
		//initialize response
		this.initialize();
		
		//the parameters should be verified
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("eventId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setEventid", "Integer"});
		
		//verify parameters
		if(this.verifyParam(request, sign, params)){
			try {
				EventWorker condition = (EventWorker)this.setCondition(EventWorker.class.getName(), request, params);
				if(null!=condition){
					List<EventWorker> eventWorkers = eventWorkerService.findByEventId(condition.getEventid());
					for(EventWorker eventWorker:eventWorkers){
						data.add(ResponseInfo.getEventWorkerInfo(eventWorker));
					}
					msg = GET_SUCCESS;
					status = StatusEnum.GET_SUCCESS.getValue();
				}else{
					//not found
					msg = NOT_FOUND;
					status = StatusEnum.NOT_FOUND.getValue();
				}
			} catch (Exception e) {
				//invalid request
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 下午10:09:58
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 添加event的工作人员
	 *
	 */
	@RequestMapping(value="/event/worker", method=RequestMethod.POST)
	public void updateEventWorker(String sign, HttpServletRequest request, HttpServletResponse response){
		//initialize response
		this.initialize();
		
		//the parameters should be verified
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("eventId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setEventid", "Integer"});
		params.put("userId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setUserid", "Integer"});
		
		//verify parameters
		if(this.verifyParam(request, sign, params)){
			try {
				EventWorker condition = (EventWorker)this.setCondition(EventWorker.class.getName(), request, params);
				if(null!=condition){
					User user = userService.findById(condition.getUserid());
					if(null!=user){
						//add a new player
						condition.setUsername(user.getName());
						condition.setUseravatar(user.getPortrait());
						eventWorkerService.insertOne(condition);
						msg = POST_SUCCESS;
						status = StatusEnum.POST_SUCCESS.getValue();
						data.add(ResponseInfo.getEventWorkerInfo(condition));
					}else{
						msg = NOT_FOUND;
						status = StatusEnum.NOT_FOUND.getValue();
					}
				}else{
					msg = NOT_FOUND;
					status = StatusEnum.NOT_FOUND.getValue();
				}
			} catch (Exception e) {
				error = e.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 下午10:10:11
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 删除event的工作人员
	 *
	 */
	@RequestMapping(value="/event/worker", method=RequestMethod.DELETE)
	public void deleteEventWorker(String sign, HttpServletRequest request, HttpServletResponse response){
		//initialize response
		this.initialize();
		
		//the parameters should be verified
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("eventId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setEventid", "Integer"});
		params.put("id", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setId", "Integer"});
		
		//verify parameters
		if(this.verifyParam(request, sign, params)){
			try {
				EventWorker condition = (EventWorker)this.setCondition(EventWorker.class.getName(), request, params);
				if(null!=condition){
					eventWorkerService.deleteById(condition.getId());
					msg = DELETE_SUCCESS;
					status = StatusEnum.DELETE_SUCCESS.getValue();
				}else{
					msg = NOT_FOUND;
					status = StatusEnum.NOT_FOUND.getValue();
				}
			} catch (Exception e) {
				error = e.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 下午10:10:25
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 查询event的比赛记录
	 *
	 */
	@RequestMapping(value="/event/matches", method=RequestMethod.GET)
	public void getEventMatches(String sign, HttpServletRequest request, HttpServletResponse response){
		//initialize response
		this.initialize();
		
		//the parameters should be verified
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("eventId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setMatchid", "Integer"});
		
		//verify parameters
		if(this.verifyParam(request, sign, params)){
			try {
				HashMap<String, Object> matches = new HashMap<String, Object>();
				//singles match
				SinglesMatch sCondition = (SinglesMatch)this.setCondition(SinglesMatch.class.getName(), request, params);
				if(null!=sCondition){
					List<Object> singlesMatches = new ArrayList<Object>();
					List<SinglesMatchQuery> singlesMatchQuerys = singlesMatchService.findByEventId(sCondition.getEventid());
					for(SinglesMatchQuery singlesMatchQuery:singlesMatchQuerys){
						singlesMatches.add(ResponseInfo.getSinglesMatchInfo(singlesMatchQuery));
					}
					matches.put("singlesMatch", singlesMatches);
				}
				//doubles match
				DoublesMatch dCondition = (DoublesMatch)this.setCondition(DoublesMatch.class.getName(), request, params);
				if(null!=dCondition){
					List<Object> doublesMatches = new ArrayList<Object>();
					List<DoublesMatchQuery> doublesMatchQuerys = doublesMatchService.findByEventId(dCondition.getEventid());
					for(DoublesMatchQuery doublesMatchQuery:doublesMatchQuerys){
						doublesMatches.add(ResponseInfo.getDoublesMatchInfo(doublesMatchQuery));
					}
					matches.put("doublesMatch", doublesMatches);
				}
				msg = GET_SUCCESS;
				status = StatusEnum.GET_SUCCESS.getValue();
				data.add(matches);
			} catch(Exception e) {
				error = e.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 下午10:10:47
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 更新或添加event的比赛记录
	 *
	 */
	@RequestMapping(value="/event/match", method=RequestMethod.POST)
	public void updateEventMatch(String sign, String type, HttpServletRequest request, HttpServletResponse response){
		//initialize response
		this.initialize();
		
		//the parameters should be verified
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("id", new Object[]{false, Pattern.compile(RegexPattern.NUMBERIC), "setId", "Integer"});
		params.put("eventId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setEventid", "Integer"});
		params.put("homeId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setHomeid", "Integer"});
		params.put("guestId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setGuestid", "Integer"});
		params.put("type", new Object[]{true, Pattern.compile(RegexPattern.validateString(1, 15)), "setType", "String"});
		params.put("score", new Object[]{true, Pattern.compile(RegexPattern.validateString(1, 30)), "setScore", "String"});
		params.put("round", new Object[]{false, Pattern.compile(RegexPattern.validateString(1, 30)), "setRound", "String"});
		params.put("isHomeRetired", new Object[]{false, Pattern.compile(RegexPattern.BOOLEAN), "setIshomeretired", "Boolean"});
		params.put("isGuestRetired", new Object[]{false, Pattern.compile(RegexPattern.BOOLEAN), "setIsguestretired", "Boolean"});
		params.put("homePoint", new Object[]{false, Pattern.compile(RegexPattern.NUMBERIC), "setHomepoint", "Integer"});
		params.put("guestPoint", new Object[]{false, Pattern.compile(RegexPattern.NUMBERIC), "setGuestpoint", "Integer"});
		params.put("isHomeWin", new Object[]{true, Pattern.compile(RegexPattern.BOOLEAN), "setIshomewin", "Boolean"});
		params.put("note", new Object[]{false, null, "setNote", "String"});
		
		//verify parameters
		if(this.verifyParam(request, sign, params)){
			try{
				if("singlesmatch".equals(type)){
					SinglesMatch condition = (SinglesMatch)this.setCondition(SinglesMatch.class.getName(), request, params);
					if(null!=condition){
						if(null!=condition.getId()){
							//update
							singlesMatchService.updateById(condition);
						}else{
							//create
							singlesMatchService.insertOne(condition);
						}
						msg = POST_SUCCESS;
						status = StatusEnum.POST_SUCCESS.getValue();
						SinglesMatchQuery singlesMatchQuery = new SinglesMatchQuery();
						singlesMatchQuery.setSinglesMatch(condition);
						singlesMatchQuery.setHome(userService.findById(condition.getHomeid()));
						singlesMatchQuery.setGuest(userService.findById(condition.getGuestid()));
						data.add(ResponseInfo.getSinglesMatchInfo(singlesMatchQuery));
					}else{
						msg = NOT_FOUND;
						status = StatusEnum.NOT_FOUND.getValue();
					}
				}else if("doublesmatch".equals(type)){
					DoublesMatch condition = (DoublesMatch)this.setCondition(DoublesMatch.class.getName(), request, params);
					if(null!=condition){
						if(null!=condition.getId()){
							//update
							doublesMatchService.updateById(condition);
						}else{
							//create
							doublesMatchService.insertOne(condition);
						}
						msg = POST_SUCCESS;
						status = StatusEnum.POST_SUCCESS.getValue();
						DoublesMatchQuery doublesMatchQuery = new DoublesMatchQuery();
						doublesMatchQuery.setDoublesMatch(condition);
						doublesMatchQuery.setHome(teamService.findById(condition.getHomeid()));
						doublesMatchQuery.setGuest(teamService.findById(condition.getGuestid()));
						data.add(ResponseInfo.getDoublesMatchInfo(doublesMatchQuery));
					}else{
						msg = NOT_FOUND;
						status = StatusEnum.NOT_FOUND.getValue();
					}
				}
			}catch(Exception e){
				error = e.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 下午10:11:07
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 删除event的比赛记录
	 *
	 */
	@RequestMapping(value="/event/match", method=RequestMethod.DELETE)
	public void deleteEventMatch(String sign, String type, HttpServletRequest request, HttpServletResponse response){
		//initialize response
		this.initialize();
		
		//the parameters should be verified
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("eventId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setEventid", "Integer"});
		params.put("id", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setId", "Integer"});
		
		//verify parameters
		if(this.verifyParam(request, sign, params)){
			try{
				if("singlesmatch".equals(type)){
					SinglesMatch condition = (SinglesMatch)this.setCondition(SinglesMatch.class.getName(), request, params);
					if(null!=condition){
						SinglesMatch singlesMatch = singlesMatchService.findById(condition.getId());
						//delete statistic
						statisticService.deleteByMatchMirror(singlesMatch.getMirror());
						//delete match
						singlesMatchService.deleteByMirror(singlesMatch.getMirror());
						msg = DELETE_SUCCESS;
						status = StatusEnum.DELETE_SUCCESS.getValue();
					}else{
						msg = NOT_FOUND;
						status = StatusEnum.NOT_FOUND.getValue();
					}
				}else if("doublesmatch".equals(type)){
					DoublesMatch condition = (DoublesMatch)this.setCondition(DoublesMatch.class.getName(), request, params);
					if(null!=condition){
						DoublesMatch doublesMatch = doublesMatchService.findById(condition.getId());
						//delete statistic
						statisticService.deleteByMatchMirror(doublesMatch.getMirror());
						//delete match
						doublesMatchService.deleteByMirror(doublesMatch.getMirror());
						msg = DELETE_SUCCESS;
						status = StatusEnum.DELETE_SUCCESS.getValue();
					}else{
						msg = NOT_FOUND;
						status = StatusEnum.NOT_FOUND.getValue();
					}
				}
			}catch(Exception e){
				error = e.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 下午10:11:22
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 查看比赛记录的数据统计
	 * 				 statistic.matchId = match.mirror 
	 *
	 */
	@RequestMapping(value="/event/match/statistic", method=RequestMethod.GET)
	public void getMatchStatistic(String sign, HttpServletRequest request, HttpServletResponse response){
		//initialize response
		this.initialize();
		
		//the parameters should be verified
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("matchId", new Object[]{true, Pattern.compile(RegexPattern.validateString(1, 50)), "setMatchid", "String"});
		params.put("eventId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setEventid", "Integer"});
		
		//verify parameters
		if(this.verifyParam(request, sign, params)){
			try{
				Statistic condition = (Statistic)this.setCondition(Statistic.class.getName(), request, params);
				if(null!=condition){
					List<StatisticQuery> statisticQuerys = statisticService.findByMatchMirror(condition.getMatchid());
					for(StatisticQuery statisticQuery:statisticQuerys){
						data.add(ResponseInfo.getStatisticInfo(statisticQuery));
					}
					msg = GET_SUCCESS;
					status = StatusEnum.GET_SUCCESS.getValue();
				}else{
					msg = NOT_FOUND;
					status = StatusEnum.NOT_FOUND.getValue();
				}
			}catch(Exception e){
				error = e.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 下午10:11:42
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 更新或添加比赛记录的数据统计
	 *
	 */
	@RequestMapping(value="/event/match/statistic", method=RequestMethod.POST)
	public void updateMatchStatistic(String sign, HttpServletRequest request, HttpServletResponse response){
		//initialize response
		this.initialize();
		
		//the parameters should be verified
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("id", new Object[]{false, Pattern.compile(RegexPattern.NUMBERIC), "setId", "Integer"});
		params.put("matchId", new Object[]{true, Pattern.compile(RegexPattern.validateString(1, 50)), "setMatchid", "String"});
		params.put("eventId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setEventid", "Integer"});
		params.put("userId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setUserid", "Integer"});
		params.put("aces", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setAces", "Integer"});
		params.put("firstServices", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setFirstservices", "Integer"});
		params.put("secondServices", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setSecondservices", "Integer"});
		params.put("doubleFaults", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setDoublefaults", "Integer"});
		params.put("firstGoals", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setFirstgoals", "Integer"});
		params.put("secondGoals", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setSecondgoals", "Integer"});
		params.put("saveBreakPoints", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setSavebreakpoints", "Integer"});
		params.put("breakPoints", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setBreakpoints", "Integer"});
		params.put("serviceBreakPoints", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setServicebreakpoints", "Integer"});
		params.put("receiveBreakPoints", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setReceivebreakpoints", "Integer"});
		params.put("firstReturnGoals", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setFirstreturngoals", "Integer"});
		params.put("secondReturnGoals", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setSecondreturngoals", "Integer"});
		params.put("services", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setServices", "Integer"});
		params.put("note", new Object[]{false, null, "setNote", "String"});
		
		//verify parameters
		if(this.verifyParam(request, sign, params)){
			try{
				Statistic condition = (Statistic)this.setCondition(Statistic.class.getName(), request, params);
				if(null!=condition){
					if(null!=condition.getId()){
						//update
						statisticService.updateById(condition);
					}else{
						statisticService.insertOne(condition);
					}
					StatisticQuery statisticQuery = new StatisticQuery();
					statisticQuery.setStatistic(condition);
					statisticQuery.setUser(userService.findById(condition.getUserid()));
					data.add(ResponseInfo.getStatisticInfo(statisticQuery));
					msg = POST_SUCCESS;
					status = StatusEnum.POST_SUCCESS.getValue();
				}else{
					msg = NOT_FOUND;
					status = StatusEnum.NOT_FOUND.getValue();
				}
			}catch(Exception e){
				error = e.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月15日 下午10:12:07
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 删除比赛记录的数据统计
	 *
	 */
	@RequestMapping(value="/event/match/statistic", method=RequestMethod.DELETE)
	public void deleteMatchStatistic(String sign, HttpServletRequest request, HttpServletResponse response){
		//initialize response
		this.initialize();
		
		//the parameters should be verified
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("eventId", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setEventid", "Integer"});
		params.put("matchId", new Object[]{true, Pattern.compile(RegexPattern.validateString(1, 50)), "setMatchid", "String"});
		
		//verify parameters
		if(this.verifyParam(request, sign, params)){
			try{
				Statistic condition = (Statistic)this.setCondition(Statistic.class.getName(), request, params);
				if(null!=condition){
					statisticService.deleteByMatchMirror(condition.getMatchid());
					msg = DELETE_SUCCESS;
					status = StatusEnum.DELETE_SUCCESS.getValue();
				}else{
					msg = NOT_FOUND;
					status = StatusEnum.NOT_FOUND.getValue();
				}
			}catch(Exception e){
				error = e.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		//send response
		this.respond(response);
	}
}	
