package com.awsports.controller;

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
import com.awsports.service.UserService;
import com.awsports.util.CustomException;
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
	public String list(Model model,User user) throws Exception{
		List<User> users=userService.findAll(user);
		model.addAttribute("users", users);
		model.addAttribute("sexTypes", TypeMap.sexType());
		model.addAttribute("forehandTypes",TypeMap.forehandType());
		model.addAttribute("backhandTypes", TypeMap.backhandType());
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
			return "user/update";
		}
		try{
			if(user.getId()!=null){//更新用户
				userService.updateById(user);
			}else{//添加用户
				userService.insertOne(user);
			}
//			return "user/save";
			//用户信息修改或添加成功后跳转到用户列表页面
			return "redirect:list";
		}catch(CustomException e){
			e.setMessage("数据存储失败");
			model.addAttribute("errorMessage", e.getMessage());
			return "error";
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
}
