package com.awsports.controller.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.awsports.util.ResponseInfo;
import com.awsports.util.GenerateCardNumber;
import com.awsports.util.MD5;
import com.awsports.util.RegexPattern;
import com.awsports.util.StatusEnum;

@Controller
@RequestMapping("/api/user")
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
	
	public UserApi(){
		//构造函数不运行
//		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		userInfo = new HashMap<String, Object>();
//		profileInfo = new HashMap<String, Object>();
//		individualrankInfo = new HashMap<String, Object>();
//		teamrankInfo = new HashMap<String, Object>();
//		singlematchInfo = new ArrayList<HashMap<String, Object>>();
//		doublematchInfo = new ArrayList<HashMap<String, Object>>();
	}
	
	public void initialize(){
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
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void getOne(@PathVariable("id") Integer id, String sign, HttpServletResponse response){
		this.initialize();
		
		if (sign == null) {
			status = StatusEnum.INVALID_REQUEST.getValue();
			msg = "INVALID_REQUEST";
			error = "sign is missing";
		} else {
			mySign = MD5.Encode("id="+id+"&token="+token).toUpperCase();
			// 匹配签名
			if (!mySign.equals(sign)) {
				//验证失败
				status = StatusEnum.INVALID_REQUEST.getValue();
				msg = "INVALID_REQUEST";
				error = "varification failed";
			}else{
				try{
					User user = userService.findById(id);
					if (user == null) {
						status = StatusEnum.NOT_FOUND.getValue();
						msg = "NOT_FOUND";
					} else {
						userInfo.put("profile", ResponseInfo.getProfileInfo(user));
						//获取该用户其它相关信息
						//当前排名
						Individualrank irkCondition = new Individualrank();
						irkCondition.setUserid(id);
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
						userInfo.put("doublematch", ResponseInfo.getDoublematchInfo(doublematchQuerys, id));
						
						status = StatusEnum.GET_SUCCESS.getValue();
						msg = "GET_SUCCESS";
						data.add(userInfo);
					}
				}catch(Exception e){
					//TODO: 数据库访问异常返回结果
					e.printStackTrace();
				}
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
	@RequestMapping(value = "/binding", method = RequestMethod.GET)
	public void bind(String phone, String cardNum, String sign, HttpServletRequest request, HttpServletResponse response){
		logger.info("绑定会员");
		this.initialize();
		//无参数
		if(phone == null && cardNum == null){
			status = StatusEnum.INVALID_REQUEST.getValue();
			msg = INVALID_REQUEST;
			error = "one or both of phone and cardNum should be needed";
		}else{
			if (sign == null) {
				status = StatusEnum.INVALID_REQUEST.getValue();
				msg = INVALID_REQUEST;
				error = "sign is missing";
			} else {
				StringBuffer mySignTmp = new StringBuffer();
				if(cardNum != null){
					mySignTmp.append("cardNum="+cardNum);
				}
				if(phone != null){
					if(cardNum != null) mySignTmp.append("&");
					mySignTmp.append("phone="+phone);
				}
				mySignTmp.append("&token="+token);
				mySign = MD5.Encode(mySignTmp.toString()).toUpperCase();
				
				if(!mySign.equals(sign)){
					status = StatusEnum.INVALID_REQUEST.getValue();
					msg = INVALID_REQUEST;
					error = "varification failed";
				}else{
					//参数校验成功
					try {
						User user = new User();
						user.setPhone(phone);
						user.setCardnum(cardNum);
						UserQuery userQuery = new UserQuery();
						userQuery.setUser(user);
						List<UserQuery> userQuerys = userService.findAll(userQuery);
						if(userQuerys == null || userQuerys.isEmpty()){
							//not found
							status = StatusEnum.NOT_FOUND.getValue();
							msg = NOT_FOUND;
						}else{
							status = StatusEnum.GET_SUCCESS.getValue();
							msg = GET_SUCCESS;
							//如果用户是通过手机绑定成功，但没有会员卡号，则生成一个会员卡号并更新到数据库
							user = userQuerys.get(0).getUser();
							if(user.getCardnum() == null || user.getCardnum().isEmpty()){
								user.setCardnum(GenerateCardNumber.generate(user.getId()));
								userService.updateById(user);
							}
							
							data.add(ResponseInfo.getProfileInfo(user));
						}
					} catch (Exception e) {
						// TODO 数据库异常返回信息
						e.printStackTrace();
					}
					
				}
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
	@RequestMapping(value = "/registering", method = RequestMethod.POST)
	public void register(String sign, HttpServletRequest request, HttpServletResponse response){
		this.initialize();
		String tip = verify(request);
		if(tip != null){
			//参数验证失败
			status = StatusEnum.INVALID_REQUEST.getValue();
			msg = INVALID_REQUEST;
			error = tip;
		}else{
			if(sign == null){
				status = StatusEnum.INVALID_REQUEST.getValue();
				msg = INVALID_REQUEST;
				error = "sign is missing";
			}else{
				//验证参数
				TreeMap<String, String> paramMap = new TreeMap<String, String>(new Comparator<String>(){
					//字典顺序升序排列
					public int compare(String s1, String s2){
						return s1.compareTo(s2);
					}
				});
				Enumeration<String> params = request.getParameterNames();
				while(params.hasMoreElements()){
					String param = params.nextElement();
					paramMap.put(param, request.getParameter(param));
				}
				StringBuffer sb = new StringBuffer();
				java.util.Iterator<String> iter = paramMap.keySet().iterator();
				while(iter.hasNext()){
					String paramName = iter.next();
					sb.append(paramName+"="+request.getParameter(paramName)+"&");
				}
				sb.append("token="+token);
				mySign = MD5.Encode(sb.toString()).toUpperCase();
				if(!mySign.equals(sign)){
					//验证失败
					status = StatusEnum.INVALID_REQUEST.getValue();
					msg = INVALID_REQUEST;
					error = "verification failed";
				}else{
					//验证通过
					User user = new User();
					user.setName(request.getParameter("name"));
					//TODO 此处不应该加密，前端传回来的必须是MD5值
					user.setPassword(request.getParameter("password"));
					user.setPhone(request.getParameter("phone"));
					user.setSex(Boolean.parseBoolean(request.getParameter("sex")));
					user.setEmail(request.getParameter("email"));
					user.setNickname(request.getParameter("nickname"));
					user.setRealname(request.getParameter("realName"));
					user.setIdcard(request.getParameter("idCard"));
					user.setAddress(request.getParameter("address"));
					user.setForehand(Integer.parseInt(request.getParameter("forehand")));
					user.setBackhand(Boolean.parseBoolean(request.getParameter("backhand")));
					user.setGrade(Integer.parseInt(request.getParameter("grade")));
					if(request.getParameter("height") != null){
						user.setHeight(Double.parseDouble(request.getParameter("height")));
					}
					if(request.getParameter("weight") != null){
						user.setWeight(Double.parseDouble(request.getParameter("weight")));
					}
					if(request.getParameter("level") != null){
						user.setLevel(Double.parseDouble(request.getParameter("level")));
					}
					if(request.getParameter("playedYears") != null){
						user.setPlayedyears(Double.parseDouble(request.getParameter("playedYears")));
					}
					if(request.getParameter("id") != null){
						user.setId(Integer.parseInt(request.getParameter("id")));
					}
					try{
						if(user.getId() == null){
							//注册新用户
							userService.insertOne(user);
							user.setCardnum(GenerateCardNumber.generate(user.getId()));
							userService.updateById(user);
						}else{
							//更新老用户
							userService.updateById(user);
							user = userService.findById(user.getId());
						}
						status = StatusEnum.POST_SUCCESS.getValue();
						msg = CREATED;
						data.add(ResponseInfo.getProfileInfo(user));
					}catch(Exception e){
						//TODO 数据库异常处理
						e.printStackTrace();
					}finally{
						//TODO 返回异常信息
					}
				}	
			}
		}
		
		this.respond(response);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年11月18日 下午3:39:39
	 * @param request
	 * @Return: String
	 * @Description: 验证请求参数
	 *
	 */
	private String verify(HttpServletRequest request){
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String nickname = request.getParameter("nickname");
		String realName = request.getParameter("realName");
		String idCard = request.getParameter("idCard");
		String address = request.getParameter("address");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String level = request.getParameter("level");
		String grade = request.getParameter("grade");
		String playedYears = request.getParameter("playedYears");
		String forehand = request.getParameter("forehand");
		String backhand = request.getParameter("backhand");
		
		Pattern integerPattern = Pattern.compile(RegexPattern.INTEGER);
		Pattern numPattern = Pattern.compile(RegexPattern.NUMBERIC);
		Pattern boolPattern = Pattern.compile(RegexPattern.BOOLEAN);
		Pattern namePattern = Pattern.compile(RegexPattern.NAME);
		
		if(id != null && !integerPattern.matcher(id).matches()){
			return "id should be an integer";
		}
		if(name == null){
			return "name is missing";
		}else{
			if(!namePattern.matcher(name).matches()){
				//匹配失败
				return "name is a string of 2 to 15, containing Chinese characters, English letters, numberics and underscores";
			}else{
				try {
					User user = userService.findByName(name);
					if(user != null){
						if(id == null || (id != null && !user.getId().toString().equals(id))){
							return "this user name has already been registered";
						}
					}
				} catch (Exception e) {
					// TODO 数据库异常处理
					e.printStackTrace();
				}
			}
		}
		if(password == null){
			return "password is missing";
		}else{
			if(!Pattern.compile(RegexPattern.PASSWORD).matcher(password).matches()){
				return "password is a string of 6 to 18 beginning with letter, containing English letters, numberics and underscores";
			}
		}
		if(phone == null){
			return "phone is missing";
		}else{
			if(!Pattern.compile(RegexPattern.PHONE).matcher(phone).matches()){
				return "phone is a string of 11, just containing numberics";
			}else{
				try{
					User user = userService.findByPhone(phone);
					if(user != null){
						if(id == null || (id != null && !user.getId().toString().equals(id))){
							return "this phone number has already been registered";	
						}
					}
				}catch(Exception e){
					//TODO 数据库异常处理
					e.printStackTrace();
				}
			}
		}
		if(sex == null){
			return "sex is missing";
		}else{
			if(!boolPattern.matcher(sex).matches()){
				return "sex is a boolean";
			}
		}
		if(grade == null){
			return "grade is missing";
		}else{
			if(!integerPattern.matcher(grade).matches()){
				return "grade should be an integer";
			}
		}
		if(email != null && !Pattern.compile(RegexPattern.EMAIL).matcher(email).matches()){
			return "email is invalid";
		}
		if(nickname != null && !namePattern.matcher(nickname).matches()){
			return "nickname is a string of 2 to 15, containing Chinese characters, English letters, numberics and underscores";
		}
		if(realName != null && !namePattern.matcher(realName).matches()){
			return "realName is a string of 2 to 15, containing Chinese characters, English letters, numberics and underscores";
		}
		if(idCard != null && !Pattern.compile(RegexPattern.IDCARD).matcher(idCard).matches()){
			return "idCard is a string of 15 or 18";
		}
		if(address != null && !Pattern.compile(RegexPattern.ADDRESS).matcher(address).matches()){
			return "address is a string of 2 to 20, containing Chinese characters, Enlish letters, numberics";
		}
		if(height != null && !numPattern.matcher(height).matches()){
			return "height should be a numberic";
		}
		if(weight != null && !numPattern.matcher(weight).matches()){
			return "weight should be a numberic";
		}
		if(playedYears != null && !numPattern.matcher(playedYears).matches()){
			return "playedYear should be a numberic";
		}
		if(level != null && !Pattern.compile(RegexPattern.TENNIS_LEVEL).matcher(level).matches()){
			return "level is between 1.0 and 7.0";
		}
		if(forehand == null){
			return "forehand is missing";
		}else{
			if(!Pattern.compile(RegexPattern.FOREHAND).matcher(forehand).matches()){
				return "forehand is a numeric from 1 to 3";
			}
		}
		if(backhand == null){
			return "backhand is missing";
		}else{
			if(!boolPattern.matcher(backhand).matches()){
				return "backhand is a boolean";
			}
		}
		return null;
	}
}
