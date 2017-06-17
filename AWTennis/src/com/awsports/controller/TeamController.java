package com.awsports.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awsports.pojo.Team;
import com.awsports.pojo.TeamQuery;
import com.awsports.pojo.User;
import com.awsports.service.TeamService;
import com.awsports.service.UserService;
import com.awsports.util.EntryEnum;
import com.awsports.util.SexEnum;
import com.awsports.util.TypeMap;

@Controller
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public String list(Model model, TeamQuery teamQuery) throws Exception{
		List<TeamQuery> teams=teamService.findAll(teamQuery);
		model.addAttribute("teams", teams);
		model.addAttribute("teamEntryTypes", TypeMap.teamEntryType());
		return "team/list";
	}
	
	@RequestMapping("/update")
	public String update(Model model, Integer id) throws Exception{
		Team team=null;
		if(id!=null){
			team=teamService.findById(id);
		}else{
			team=new Team();
		}
		model.addAttribute("team",team);
		model.addAttribute("users", userService.findAll(null));
		return "team/update";
	}
	
	@RequestMapping("/save")
	public String save(@Validated Team team, BindingResult br, Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "team/update";
		}else{
			User user1=userService.findById(team.getUser1id());
			User user2=userService.findById(team.getUser2id());
			//设置组合名称
			if(team.getName()==null||team.getName()==""){
				StringBuffer teamName=new StringBuffer();
				teamName.append(user1.getName());
				teamName.append("&");
				teamName.append(user2.getName());
				team.setName(teamName.toString());
			}else{
				//..
			}

			if(user1.getSex().booleanValue()==user2.getSex().booleanValue()&&
			   user2.getSex().booleanValue()==SexEnum.MALE.getValue().booleanValue()){
				team.setEntry(EntryEnum.MANDOUBLE.getValue());
			}else if(user1.getSex().booleanValue()==user2.getSex().booleanValue()&&
					 user2.getSex().booleanValue()==SexEnum.FEMALE.getValue().booleanValue()){
				team.setEntry(EntryEnum.WOMANDOUBLE.getValue());
			}else{
				team.setEntry(EntryEnum.MIXEDDOUBLE.getValue());	
			}
			if(team.getId()!=null){
				teamService.updateById(team);
			}else{
				teamService.insertOne(team);
			}
			return "redirect:list";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		teamService.deleteById(id);
		return "redirect:list";
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年5月30日
	 * @return: String
	 * @description: 接受前端查询的结果，模糊查询数据库，将查询结果返回至前端以实现联想搜索
	 *
	 */
	@RequestMapping(value="/linkData",method={RequestMethod.POST})
	public String linkData(HttpServletRequest request, HttpServletResponse response) throws Exception{
		User user=new User();
		String search=request.getParameter("search");
		user.setName(search);
		List<User> users=userService.findAll(user);//查询数据库，返回结果
		if(users!=null&&users.size()>0){
			JSONArray jsonArray=new JSONArray();//将查询到的用户名转换成json数据
			Map<Integer,String> map=new HashMap<Integer,String>();
			for(User u:users){
				map.put(u.getId(), u.getName());
			}
			jsonArray.put(map);
			response.getWriter().write(jsonArray.toString());
			System.out.println(jsonArray);
		}
		return null;
	}
}
