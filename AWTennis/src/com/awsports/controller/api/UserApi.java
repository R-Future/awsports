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

import com.awsports.pojo.DoublematchQuery;
import com.awsports.pojo.Individualrank;
import com.awsports.pojo.Individualrankest;
import com.awsports.pojo.SinglematchQuery;
import com.awsports.pojo.Team;
import com.awsports.pojo.User;
import com.awsports.pojo.UserQuery;
import com.awsports.service.DoublematchService;
import com.awsports.service.IndividualrankService;
import com.awsports.service.IndividualrankestService;
import com.awsports.service.SinglematchService;
import com.awsports.service.TeamService;
import com.awsports.service.TeamrankService;
import com.awsports.service.TeamrankestService;
import com.awsports.service.UserService;
import com.awsports.util.GenerateCardNumber;
import com.awsports.util.MD5;
import com.awsports.util.RegexPattern;
import com.awsports.util.ResponseInfo;
import com.awsports.util.StatusEnum;

@Controller
@RequestMapping("/api")
public class UserApi extends BaseApi{

	@Autowired
	private UserService userService;
	@Autowired
	private IndividualrankService individualrankService;
	@Autowired
	private IndividualrankestService individualrankestService;
	@Autowired
	private TeamrankService teamrankService;
	@Autowired
	private TeamrankestService teamrankestService;
	@Autowired
	private SinglematchService singlematchService;
	@Autowired
	private DoublematchService doublematchService;
	@Autowired
	private TeamService teamService;

	private HashMap<String, Object> userInfo;
	private HashMap<String, Object> profileInfo;
	private HashMap<String, Object> individualrankInfo;
	private HashMap<String, Object> teamrankInfo;
	private List<HashMap<String, Object>> singlematchInfo;
	private List<HashMap<String, Object>> doublematchInfo;
	
//	private SimpleDateFormat simpleDateFormat;
	
//	public UserApi(){
		//构造函数不运行
//		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		userInfo = new HashMap<String, Object>();
//		profileInfo = new HashMap<String, Object>();
//		individualrankInfo = new HashMap<String, Object>();
//		teamrankInfo = new HashMap<String, Object>();
//		singlematchInfo = new ArrayList<HashMap<String, Object>>();
//		doublematchInfo = new ArrayList<HashMap<String, Object>>();
//	}
	
	protected void initialize(){
		super.initialize();
		userInfo = new HashMap<String, Object>();
		profileInfo = new HashMap<String, Object>();
		individualrankInfo = new HashMap<String, Object>();
		teamrankInfo = new HashMap<String, Object>();
		singlematchInfo = new ArrayList<HashMap<String, Object>>();
		doublematchInfo = new ArrayList<HashMap<String, Object>>();
	}
	
	protected void destoryJSONData(){
		super.destoryJSONData();
		userInfo.clear();
		profileInfo.clear();
		individualrankInfo.clear();
		teamrankInfo.clear();
		singlematchInfo.clear();
		doublematchInfo.clear();
	}
	
	protected boolean verifyParam(HttpServletRequest request, String sign, HashMap<String, Object[]> params){
		return super.verifyParam(request, sign, params);
	}
	
	protected Object setCondition(String className, HttpServletRequest request, HashMap<String, Object[]> params) throws Exception{
		return super.setCondition(className, request, params);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年11月18日 下午6:14:06
	 * @param response
	 * @Return: void
	 * @Description: 响应请求，返回json数据
	 *
	 */
	protected void respond(HttpServletResponse response){
		super.respond(response);
		//销毁数据，以免内存溢出
	    this.destoryJSONData();
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年11月16日 下午9:41:31
	 * @param id
	 * @param sign
	 * @param response
	 * @throws Exception
	 * @Return: void
	 * @Description: 获取会员信息
	 *
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public void getOne(String sign, HttpServletRequest request, HttpServletResponse response){
		this.initialize();
		
		//arguments need to be validated
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("id", new Object[]{true, Pattern.compile(RegexPattern.NUMBERIC), "setId", "Integer"});
		
		if(this.verifyParam(request, sign, params)){
			try{
				User condition = (User)this.setCondition(User.class.getName(), request, params);
				if(null != condition){
					User user = userService.findById(condition.getId());
					if (user == null) {
						status = StatusEnum.NOT_FOUND.getValue();
						msg = "NOT_FOUND";
					} else {
						userInfo.put("profile", ResponseInfo.getProfileInfo(user));
						//获取该用户其它相关信息
						//当前排名
						Individualrank irkCondition = new Individualrank();
						irkCondition.setUserid(user.getId());
						irkCondition.setYear(date.getYear());
						List<Individualrank> individualranks = individualrankService.findUserRank(irkCondition);
						//最高排名记录
						List<Individualrankest> individualrankests = individualrankestService.findByUser(user);
						userInfo.put("individualRank", ResponseInfo.getIndividualrankInfo(individualranks, individualrankests));
						
						//获取组合信息
						List<Team> teams = teamService.findByUser(user);
						userInfo.put("teamRank", ResponseInfo.getTeamrankInfo(teams, teamrankService, teamrankestService));
						
						//获取单打比赛记录
						List<SinglematchQuery> singlematchQuerys = singlematchService.findByUser(user);
						userInfo.put("singlematch", ResponseInfo.getSinglematchInfo(singlematchQuerys));
						//获取双打比赛记录
						List<DoublematchQuery> doublematchQuerys = doublematchService.findByUser(user);
						userInfo.put("doublematch", ResponseInfo.getDoublematchInfo(doublematchQuerys, user.getId()));
						
						status = StatusEnum.GET_SUCCESS.getValue();
						msg = "GET_SUCCESS";
						data.add(userInfo);
					}
				}else{
					status = StatusEnum.NOT_FOUND.getValue();
					msg = "NOT_FOUND";
				}
			}catch(Exception e){
				error = e.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}

	    this.respond(response);
		
	}

	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年11月16日 下午9:41:46
	 * @param request
	 * @param response
	 * @param sign
	 * @throws Exception
	 * @Return: void
	 * @Description: 绑定会员
	 *
	 */
	@RequestMapping(value = "/user/bind", method = RequestMethod.POST)
	public void bind(String sign, HttpServletRequest request, HttpServletResponse response){
		logger.info("绑定会员");
		this.initialize();
		
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("phone", new Object[]{true, Pattern.compile(RegexPattern.PHONE), "setPhone", "String"});
		params.put("cardNum", new Object[]{false, Pattern.compile(RegexPattern.validateString(15, 15)), "setCardnum", "String"});
		
		if(this.verifyParam(request, sign, params)){
			try{
				User condition = (User)this.setCondition(User.class.getName(), request, params);
				if(null!=condition){
					UserQuery userQuery = new UserQuery();
					userQuery.setUser(condition);
					List<UserQuery> userQuerys = userService.findAll(userQuery);
					if(userQuerys == null || userQuerys.isEmpty()){
						//not found
						status = StatusEnum.NOT_FOUND.getValue();
						msg = NOT_FOUND;
					}else{
						status = StatusEnum.GET_SUCCESS.getValue();
						msg = GET_SUCCESS;
						//如果用户是通过手机绑定成功，但没有会员卡号，则生成一个会员卡号并更新到数据库
						User user = userQuerys.get(0).getUser();
						if(user.getCardnum() == null || user.getCardnum().isEmpty()){
							user.setCardnum(GenerateCardNumber.generate(user.getId()));
							userService.updateById(user);
						}
						data.add(ResponseInfo.getProfileInfo(user));
					}
				}else{
					//not found
					status = StatusEnum.NOT_FOUND.getValue();
					msg = NOT_FOUND;
				}
			}catch(Exception e){
				error = e.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年11月18日 下午12:44:24
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: 会员注册
	 *
	 */
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public void register(String sign, HttpServletRequest request, HttpServletResponse response){
		//initialize response body
		this.initialize();
		
		//set parameters that need to be validated
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("id", new Object[]{false, Pattern.compile(RegexPattern.NUMBERIC), "setId", "Integer"});
		params.put("name", new Object[]{true, Pattern.compile(RegexPattern.NAME), "setName", "String"});
		params.put("password", new Object[]{true, Pattern.compile(RegexPattern.validateString(32, 32)), "setPassword", "String"});
		params.put("phone", new Object[]{true, Pattern.compile(RegexPattern.PHONE), "setPhone", "String"});
		params.put("sex", new Object[]{true, Pattern.compile(RegexPattern.BOOLEAN), "setSex", "Boolean"});
		params.put("email", new Object[]{false, Pattern.compile(RegexPattern.EMAIL), "setEmail", "String"});
		params.put("nickname", new Object[]{false, Pattern.compile(RegexPattern.validateString(1, 15)), "setNickname", "String"});
		params.put("realName", new Object[]{false, Pattern.compile(RegexPattern.validateString(1, 15)), "setRealname", "String"});
		params.put("idCard", new Object[]{false, Pattern.compile(RegexPattern.IDCARD), "setIdcard", "String"});
		params.put("address", new Object[]{false, Pattern.compile(RegexPattern.ADDRESS), "setAddress", "String"});
		params.put("height", new Object[]{false, Pattern.compile(RegexPattern.NUMBERIC), "setHeight", "Double"});
		params.put("weight", new Object[]{false, Pattern.compile(RegexPattern.NUMBERIC), "setWeight", "Double"});
		params.put("level", new Object[]{false, Pattern.compile(RegexPattern.TENNIS_LEVEL), "setLevel", "Double"});
		params.put("grade", new Object[]{false, Pattern.compile(RegexPattern.NUMBERIC), "setGrade", "Integer"});
		params.put("playedYears", new Object[]{false, Pattern.compile(RegexPattern.NUMBERIC), "setPlayedyears", "Double"});
		params.put("forehand", new Object[]{false, Pattern.compile(RegexPattern.NUMBERIC), "setForehand", "Integer"});
		params.put("backhand", new Object[]{false, Pattern.compile(RegexPattern.BOOLEAN), "setBackhand", "Boolean"});
		
		//check parameters
		if(this.verifyParam(request, sign, params)){
			try{
				User user = (User)this.setCondition(User.class.getName(), request, params);
				if(null!=user){
					if(null==user.getId()){
						//new user
						userService.insertOne(user);
						user.setCardnum(GenerateCardNumber.generate(user.getId()));
						userService.updateById(user);
					}else{
						//old user
						userService.updateById(user);
						user = userService.findById(user.getId());
					}
					status = StatusEnum.POST_SUCCESS.getValue();
					msg = POST_SUCCESS;
					data.add(ResponseInfo.getProfileInfo(user));
				}else{
					msg = INVALID_REQUEST;
					status = StatusEnum.INVALID_REQUEST.getValue();
				}
			}catch(Exception e){
				error = e.toString();
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
			}
		}
		
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年9月23日 上午11:02:23
	 * @param sign
	 * @param request
	 * @param response
	 * @Return: void
	 * @Description: login
	 *
	 */
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public void login(String sign, HttpServletRequest request, HttpServletResponse response){
		this.initialize();
		
		HashMap<String, Object[]> params = new HashMap<String, Object[]>();
		params.put("name", new Object[]{true, Pattern.compile(RegexPattern.NAME), "setName", "String"});
		params.put("password", new Object[]{true, Pattern.compile(RegexPattern.validateString(32, 32)), "setPassword", "String"});
		
		if(this.verifyParam(request, sign, params)){
			try{
				User cond = (User)this.setCondition(User.class.getName(), request, params);
				if(null!=cond){
					User user = userService.findByName(cond.getName());
					if(null!=user && user.getPassword().equals(cond.getPassword())){
						//success
						msg = GET_SUCCESS;
						status = StatusEnum.GET_SUCCESS.getValue();
						data.add(ResponseInfo.getProfileInfo(user));
						//saved in front-end for login
						data.get(0).put("token", MD5.Encode(user.getName().toString()+user.getPassword().toString()));
					}else{
						//failed
						msg = NOT_FOUND;
						status = StatusEnum.NOT_FOUND.getValue();
					}
				}else{
					msg = INVALID_REQUEST;
					status = StatusEnum.INVALID_REQUEST.getValue();
				}
			}catch(Exception e){
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
				error = e.toString();
			}
		}
		
		this.respond(response);
	}
}
