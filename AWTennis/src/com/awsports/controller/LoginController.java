package com.awsports.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.User;
import com.awsports.service.UserService;
import com.awsports.util.MD5;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(Model model,HttpSession session,String username, String password,Boolean rememberMe) throws Exception{
		if(username!=null&&password!=null){
			User user=new User();
			user.setName(username);
			user=userService.findByName(user);
			if(user!=null){
				//判断是否是管理员
				if(user.getPrivilege()!=null&&user.getPrivilege().intValue()==1){
					if(user.getPassword().equals(MD5.Encode(password))){
						if(rememberMe!=null&&rememberMe.booleanValue()){
							
						}else{
							//...
						}
						//存入session
						session.setAttribute("username", username);
						return "redirect:/user/list";
					}else{
						model.addAttribute("username", username);
						model.addAttribute("error", "密码错误！");
						return "login";
					}
				}else{
					model.addAttribute("error", "对不起，您没有登陆权限！请联系管理员！");
					return "login";
				}
			}else{
				model.addAttribute("error", "用户不存在！");
				return "login";
			}
		}else{
			return "login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:login";
	}
}
