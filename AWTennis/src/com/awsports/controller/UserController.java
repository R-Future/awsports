package com.awsports.controller;

import java.util.List;

//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		if(user!=null)
			userQuery.setUser(user);
		List<User> users=userService.findAll(userQuery);
		model.addAttribute("users", users);
		return "user/show";
	}
	
	@RequestMapping(value="/update",method={RequestMethod.GET,RequestMethod.POST})
	public String update(Model model, Integer id)  throws Exception{
		User user=userService.findById(id);
		model.addAttribute("user", user);
		return "user/update";
	}
	
	@RequestMapping(value="/save",method={RequestMethod.POST})
	public String save(User user) throws Exception{
		userService.save(user);
		return "user/save";	
	}

}
