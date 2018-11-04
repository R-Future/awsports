package com.awsports.controller.api;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.awsports.service.ApikeyService;
import com.awsports.util.CustomDate;
import com.awsports.util.MD5;
import com.awsports.util.StatusEnum;

import net.sf.json.JSONObject;

@Controller
public class BaseApi {
	
	@Autowired
	private ApikeyService apikeyService;
	
	protected static Log logger = LogFactory.getLog("api");
	protected static CustomDate date = new CustomDate();
	
	protected static String INVALID_REQUEST = "INVALID_REQUEST";
	protected static String GET_SUCCESS = "GET_SUCCESS";
	protected static String POST_SUCCESS = "POST_SUCCESS";
	protected static String NOT_FOUND = "NOT_FOUND";
	protected static String CREATED = "CREATED";
	protected static String DELETE_SUCCESS = "DELETE_SUCCESS";
	
	protected String token;
	
	protected int status;
	protected String msg;
	protected String error;
	protected List<HashMap<String, Object>> data;
	
	protected String mySign;
	
	protected JSONObject jsonObject;
	
//	private TreeMap<String, Object[]> selectedParams;

	public BaseApi(){
		//构造函数不运行？？？
//		error = "";
//		data = new ArrayList<HashMap<String, Object>>();
//		jsonObject = new JSONObject();
//		try {
//			token = apikeyService.findById(1);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			logger.error("获取api key失败");
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年12月23日 上午10:58:42
	 * @Return: void
	 * @Description: 初始化
	 *
	 */
	protected void initialize(){
		error = "";
		data = new ArrayList<HashMap<String, Object>>();
		jsonObject = new JSONObject();
		try {
			token = apikeyService.findById(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("获取api key失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年12月23日 上午10:57:59
	 * @Return: void
	 * @Description: 响应返回的数据格式 
	 *
	 */
	protected void respond(HttpServletResponse response){
		jsonObject.put("status", status);
		jsonObject.put("msg", msg);
		jsonObject.put("error", error);
		jsonObject.put("data", data);
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(jsonObject.toString());
			response.getWriter().close();
		} catch (IOException e) {
			// TODO 响应异常返回结果
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年12月23日 上午10:58:22
	 * @Return: void
	 * @Description: 销毁上一次保存的数据
	 *
	 */
	protected void destoryJSONData(){
		status = 0;
		msg = "";
		error = "";
		data.clear();
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月14日 下午9:19:50
	 * @param request: parameters from front-end through HTTP
	 * @param sign: md5 for validating the parameters
	 * @Return: boolean
	 * @Description: 
	 *
	 */
	protected boolean verifyParam(HttpServletRequest request, String sign, HashMap<String, Object[]> params){
		try {
			if(null==sign){
				error = "sign is missing";
				msg = INVALID_REQUEST;
				status = StatusEnum.INVALID_REQUEST.getValue();
				return false;
			}else{
				StringBuffer sb  = new StringBuffer();
				if(null!=params){
					//sort by name [a-z]
					List<Map.Entry<String, Object[]>> paramList = new ArrayList<Map.Entry<String, Object[]>>(params.entrySet());
					Collections.sort(paramList, new Comparator<Map.Entry<String, Object[]>>(){
						public int compare(Map.Entry<String, Object[]> m1, Map.Entry<String, Object[]> m2){
							return m1.getKey().toString().compareTo(m2.getKey().toString());
						}
					});
					for(int i=0;i<paramList.size();i++){
//					Set<Entry<String, Object[]>> set = params.entrySet();
//					Iterator<Entry<String, Object[]>> it = set.iterator();
//					while(it.hasNext()){
						Map.Entry<String, Object[]> me = (Map.Entry<String, Object[]>)paramList.get(i);
						String pValue = request.getParameter(me.getKey().toString());
						if(null!=pValue){
							//the parameter exists, it means it should be checked.
							Pattern pattern = (Pattern)me.getValue()[1];
							if(null!=pattern&&!pattern.matcher(pValue).matches()){
								//check fail
								error = me.getKey().toString()+" is invalid!";
								msg = INVALID_REQUEST;
								status = StatusEnum.INVALID_REQUEST.getValue();
								return false;
							}else{
								//calculate mySign for validation
								sb.append(me.getKey().toString()+"="+pValue+"&");
							}
						}else{
							//the parameter does not exist
							if((boolean)me.getValue()[0]){
								//the required parameter is missing
								error = me.getKey().toString()+" is missing!";
								msg = INVALID_REQUEST;
								status = StatusEnum.INVALID_REQUEST.getValue();
								return false;
							}
						}
					}
				}
				sb.append("token="+token);
				if(!MD5.Encode(sb.toString()).toUpperCase().equals(sign)){
					//verify fail
					error = "sign is invalid";
					msg = INVALID_REQUEST;
					status = StatusEnum.INVALID_REQUEST.getValue();
					return false;
				}
				return true;
			}
		} catch (SecurityException | IllegalArgumentException e) {
//			e.printStackTrace();
			logger.error(e.toString());
			error = e.toString();
			msg = INVALID_REQUEST;
			status = StatusEnum.INVALID_REQUEST.getValue();
			return false;
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月14日 下午9:19:50
	 * @param className: the conditions for querying in database  
	 * @param request: parameters from front-end through HTTP
	 * @param params: {"publisher", new Object[]{false, Pattern.compile(RegexPattern.INTEGER), "setPublisher", int.class}}
	 * @param sign: md5 for validating the parameters
	 * @Return: Object
	 * @Description: if this function throws a exception, it means something wrong, like wrong class name and wrong method name.
	 * 				 so, in this scenario, we view it as invalid request.
	 *
	 */
	protected Object setCondition(String className, HttpServletRequest request, HashMap<String, Object[]> params) throws Exception {
		//set conditions and return the instance
		Class<?> cla = Class.forName(className);
		Object obj = cla.newInstance();
		if(null!=params){
			Set<Entry<String, Object[]>> set = params.entrySet();
			Iterator<Entry<String, Object[]>> it = set.iterator();
			while(it.hasNext()){
				Map.Entry<String, Object[]> me = (Map.Entry<String, Object[]>)it.next();
				String pValue = request.getParameter(me.getKey().toString());
				if(null!=pValue){
					//set conditions
					Method setValue;
					switch((String)me.getValue()[3]){
						case "Integer":
							setValue = cla.getMethod((String)me.getValue()[2], Integer.class);
							setValue.invoke(obj, Integer.parseInt(pValue));
							break;
						case "Double":
							setValue = cla.getMethod((String)me.getValue()[2], Double.class);
							setValue.invoke(obj, Double.parseDouble(pValue));
							break;
						case "Boolean":
							setValue = cla.getMethod((String)me.getValue()[2], Boolean.class);
							setValue.invoke(obj, Boolean.parseBoolean(pValue));
							break;
//						case "Date":
//							setValue = cla.getMethod((String)me.getValue()[2], Date.class);
//							setValue.invoke(obj, (new SimpleDateFormat("yyyy-MM-dd HH:mm")).parse(pValue));
						default:
							setValue = cla.getMethod((String)me.getValue()[2], String.class);
							setValue.invoke(obj, pValue);
					}
				}
			}
			return obj;
		}else{
			return null;
		}			
	}
	
}
