package com.awsports.controller;

import java.util.Date;
import java.util.List;

//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awsports.pojo.User;
import com.awsports.pojo.UserQuery;
import com.awsports.service.UserService;

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
	
	@RequestMapping(value="/show",method={RequestMethod.GET,RequestMethod.POST})
	public String show(Model model,User user) throws Exception{
		UserQuery userQuery=new UserQuery();
		if(user!=null)//传入用户查询条件
			userQuery.setUser(user);
		List<User> users=userService.findAll(userQuery);
		model.addAttribute("users", users);
		return "user/show";
	}
	
	@RequestMapping(value="/update",method={RequestMethod.GET,RequestMethod.POST})
	public String update(Model model,Integer id)  throws Exception{
		User user=null;
		if(id!=null){//更新请求
			user=userService.findById(id);
		}else{//添加请求
			user=new User();
		}
		model.addAttribute("user", user);
		return "user/update";
	}
	
	@RequestMapping(value="/save")
	public String save(@Validated User user, BindingResult validationResult, Integer id, Model model) throws Exception{
		if(validationResult.hasErrors()){
			model.addAttribute("errors", validationResult);
			return "user/update";
		}
		if(id!=null){//更新用户
			Date date=new Date();
			user.setUpdatedAt(date);
			user.setId(id);
			userService.update(user);
		}else{//添加用户
			userService.add(user);
		}
//		return "user/save";
		//用户信息修改或添加成功后跳转到用户列表页面
		return "redirect:show";
	}

	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		try{
			userService.deleteById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:show";
	}
}
