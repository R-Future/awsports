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
import com.awsports.pojo.UserQuery;
import com.awsports.service.TeamService;
import com.awsports.service.UserService;
import com.awsports.util.CustomException;
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
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:23:35
	 * @param model
	 * @param teamQuery
	 * @throws Exception
	 * @Return: String
	 * @Description: 组合信息列表
	 *
	 */
	@RequestMapping("/list")
	public String list(Model model, TeamQuery teamQuery) throws Exception{
		List<TeamQuery> teams=teamService.findAll(teamQuery);
		model.addAttribute("teams", teams);
		model.addAttribute("teamEntryTypes", TypeMap.teamEntryType());
		return "team/list";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:23:47
	 * @param model
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 更新或添加组合
	 *
	 */
	@RequestMapping("/update")
	public String update(Model model, Integer id) throws Exception{
		Team team=null;
		if(id!=null){
			team=teamService.findById(id);
		}else{
			team=new Team();
		}
		model.addAttribute("team",team);
		model.addAttribute("userQuerys", userService.findAll(null));
		return "team/update";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:24:01
	 * @param team
	 * @param br
	 * @param model
	 * @throws Exception
	 * @Return: String
	 * @Description: 保存修改后的组合信息
	 *
	 */
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
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:24:16
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 删除组合
	 *
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{
			teamService.deleteById(id);
			return "redirect:list";
		}
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
		UserQuery userQuery=new UserQuery();
		String search=request.getParameter("search");
		userQuery.getUser().setName(search);
		List<UserQuery> userQuerys=userService.findAll(userQuery);//查询数据库，返回结果
		if(userQuerys!=null&&userQuerys.size()>0){
			JSONArray jsonArray=new JSONArray();//将查询到的用户名转换成json数据
			Map<Integer,String> map=new HashMap<Integer,String>();
			for(UserQuery uq:userQuerys){
				map.put(uq.getUser().getId(), uq.getUser().getName());
			}
			jsonArray.put(map);
			response.getWriter().write(jsonArray.toString());
			System.out.println(jsonArray);
		}
		return null;
	}
}
