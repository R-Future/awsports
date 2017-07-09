package com.awsports.controller;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awsports.pojo.User;
import com.awsports.service.UserService;
import com.awsports.util.MD5;
import com.awsports.util.ValidationCode;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月9日 下午1:27:04
	 * @param model
	 * @param session
	 * @param username
	 * @param password
	 * @param rememberMe
	 * @param validationCode
	 * @throws Exception
	 * @Return: String
	 * @Description: 用户登陆
	 *
	 */
	@RequestMapping("/login")
	public String login(Model model, HttpSession session, String username, String password,Boolean rememberMe, String validationCode, HttpServletResponse response) throws Exception{
		if(username!=null&&password!=null){
			String originValidationCode = session.getAttribute("validationCodes").toString().toLowerCase();
			if(validationCode.toLowerCase().equals(originValidationCode)){
				User user=new User();
				user.setName(username);
				user=userService.findByName(user);
				if(user!=null){
					//判断是否是管理员
					if(user.getPrivilege()!=null&&user.getPrivilege().intValue()==1){
						if(user.getPassword().equals(MD5.Encode(password))){
							//remember me
							if(rememberMe!=null&&rememberMe.booleanValue()){
								
							}else{
								//...
							}
							//存入session
							session.setAttribute("currentUser", user);
							return "redirect:/user/list";
						}else{
							model.addAttribute("error", "密码错误");
							return "login";
						}
					}else{
						model.addAttribute("error", "对不起，您没有登陆权限！请联系管理员");
						return "login";
					}
				}else{
					model.addAttribute("error", "用户不存在");
					return "login";
				}
			}{
				model.addAttribute("error","验证码输入错误");
				return "login";
			}
		}else{
			//model.addAttribute("error", "用户名或密码不能为空");
			return "login";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月9日 下午1:27:25
	 * @param session
	 * @throws Exception
	 * @Return: String
	 * @Description: 退出登陆
	 *
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:login";
	}
	
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月9日 下午1:17:50
	 * @param request
	 * @param response
	 * @throws IOException
	 * @Return: String
	 * @Description: 生成验证码
	 *
	 */
	@RequestMapping(value="/getValidationPicture",method={RequestMethod.GET})
	public void getValidationPicture(Model model, HttpSession session, HttpServletResponse response) throws IOException{

		ValidationCode.initValidationCode();
		//将验证码存入session中用于验证
		session.setAttribute("validationCodes", ValidationCode.getValidationCode());
		response.setContentType("image/jpg");
		ServletOutputStream outputStream = response.getOutputStream();
		ImageIO.write(ValidationCode.getBufferedImage(), "jpg", outputStream);
		outputStream.close();
	}
	
}
