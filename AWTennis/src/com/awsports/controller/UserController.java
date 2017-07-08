package com.awsports.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awsports.pojo.Level;
import com.awsports.pojo.User;
import com.awsports.pojo.UserQuery;
import com.awsports.service.LevelService;
import com.awsports.service.UserService;
import com.awsports.util.CustomException;
import com.awsports.util.MD5;
import com.awsports.util.TypeMap;

/**
 * 
 * @company: awsports
 * @version: 1.0
 * @author: Fu
 * @package: com.awsports.controller
 * @description: 实现用户信息的增删改查
 * @date: 2017年5月19日 上午11:34:56
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	//注入service
	@Autowired
	private UserService userService;
	@Autowired
	private LevelService levelService;
	
	private Map<Boolean, String> sexTypes=TypeMap.sexType();
	private Map<Integer, String> forehandTypes=TypeMap.forehandType();
	private Map<Boolean, String> backhandTypes=TypeMap.backhandType();

	private final int STATUS_OK=1;
	private final int STATUS_ERROR=0;
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:27:55
	 * @param model
	 * @param user
	 * @throws Exception
	 * @Return: String
	 * @Description: 用户信息列表
	 *
	 */
	@RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST})
	public String list(Model model,UserQuery userQuery) throws Exception{
		List<UserQuery> userQuerys=userService.findAll(userQuery);
		model.addAttribute("userQuerys", userQuerys);
		model.addAttribute("sexTypes", sexTypes);
		model.addAttribute("forehandTypes", forehandTypes);
		model.addAttribute("backhandTypes", backhandTypes);
		return "user/list";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:28:15
	 * @param model
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 更新或添加用户
	 *
	 */
	@RequestMapping(value="/update",method={RequestMethod.GET,RequestMethod.POST})
	public String update(Model model,Integer id)  throws Exception{
		User user=null;
		if(id!=null){//更新请求
			user=userService.findById(id);
		}else{//添加请求
			user=new User();
		}
		model.addAttribute("user", user);
		model.addAttribute("sexTypes", TypeMap.sexType());
		model.addAttribute("forehandTypes", TypeMap.forehandType());
		model.addAttribute("backhandTypes", TypeMap.backhandType());
		//获取俱乐部等级信息
		List<Level> levels=levelService.findAll(null);
		model.addAttribute("levels", levels);
		return "user/update";
		
		
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:28:33
	 * @param user
	 * @param validationResult
	 * @param model
	 * @throws Exception
	 * @Return: String
	 * @Description: 保存修改后的用户信息
	 *
	 */
	@RequestMapping(value="/save")
	public String save(@Validated User user, BindingResult validationResult, Model model) throws Exception{
		if(validationResult.hasErrors()){
			model.addAttribute("errors", validationResult);
			return "redirect:update";
		}else{
			//对密钥进行MD5加密
			String password=user.getPassword();
			user.setPassword(MD5.Encode(password));
			if(user.getId()!=null){//更新用户
				userService.updateById(user);
			}else{//添加用户
				userService.insertOne(user);
			}
			//用户信息修改或添加成功后跳转到用户列表页面
			return "redirect:list";
		}
		
	}

	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:28:53
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 删除用户
	 *
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{
			userService.deleteById(id);
			return "redirect:list";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月7日 下午10:06:36
	 * @param model
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 用户简介
	 *
	 */
	@RequestMapping("/profile")
	public String profile(Model model, Integer id) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{
			User user=userService.findById(id);
			model.addAttribute("user", user);
			Level level=levelService.findById(user.getGrade());
			model.addAttribute("level", level);
			model.addAttribute("sexTypes", sexTypes);
			model.addAttribute("forehandTypes", forehandTypes);
			model.addAttribute("backhandTypes", backhandTypes);
			return "user/profile";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月7日 下午11:26:00
	 * @param model
	 * @param user
	 * @throws Exception
	 * @Return: void
	 * @Description: 修改密码
	 *
	 */
	@RequestMapping("/changePassword")
	public String changePassword(Integer id, String oldPassword, String newPassword, String newPasswordConfirmation, HttpServletResponse response) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{
			User user=userService.findById(id);
			JSONArray jsonArray=new JSONArray();
			if(oldPassword!=null&&user!=null){
				if(oldPassword.equals(user.getPassword())){
					if(newPassword.equals(newPasswordConfirmation)){
						user.setPassword(newPassword);
						userService.updateById(user);
						jsonArray.put(STATUS_OK, "密码修改成功");	
					}else{
						jsonArray.put(STATUS_ERROR, "新密码输入不一致");
					}
				}else{
					jsonArray.put(STATUS_ERROR, "原密码输入错误");
				}
			}else{
				jsonArray.put(STATUS_ERROR, "用户不存在");
			}
			response.getWriter().append(jsonArray.toString());
			return null;
		}
	}
}
