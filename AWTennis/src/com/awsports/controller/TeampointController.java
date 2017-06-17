package com.awsports.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.TeamQuery;
import com.awsports.pojo.Teampoint;
import com.awsports.pojo.TeampointQuery;
import com.awsports.service.TeamService;
import com.awsports.service.TeampointService;
import com.awsports.util.CustomException;
import com.awsports.util.TypeMap;

@Controller
@RequestMapping("/teampoint")
public class TeampointController {
	
	@Autowired
	private TeampointService teampointService;
	@Autowired
	private TeamService teamService;
	
	private Map<Integer,String> teamEntryTypes=TypeMap.teamEntryType();
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月13日 上午11:25:37
	 * @return: String
	 * @description: 组合积分显示列表
	 *
	 */
	@RequestMapping("/list")
	public String list(Model model,TeampointQuery teampointQuery) throws Exception{
		List<TeampointQuery> teampointQuerys=teampointService.findAll(teampointQuery);
		model.addAttribute("teampointQuerys",teampointQuerys);
		model.addAttribute("teamEntryTypes", teamEntryTypes);
		return "teampoint/list";
	}
	
	/**
	 *
	 * @Author: Fu
	 * @date: 2017年6月13日 上午11:31:58
	 * @return: String
	 * @description: 更新和添加组合积分记录
	 *
	 */
	@RequestMapping("/update")
	public String update(Model model,Integer id)throws Exception{
		Teampoint teampoint=null;
		if(id!=null){
			//更新记录
			teampoint=teampointService.findById(id);
		}else{
			//添加记录
			//teampoint=new Teampoint();
			throw new CustomException("非法操作！");
		}
		model.addAttribute("teampoint", teampoint);
		//获取所有team信息
		List<TeamQuery> teamQuerys=teamService.findAll(null);
		model.addAttribute("teamQuerys", teamQuerys);
		//获取组合类型信息
		model.addAttribute("teamEntryTypes", teamEntryTypes);
		return "teampoint/update";
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月13日 上午11:39:33
	 * @return: String
	 * @description: 保存修改后的记录
	 *
	 */
	@RequestMapping("/save")
	public String save(@Validated Teampoint teampoint,BindingResult br,Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "teampoint/update";
		}else{
			if(teampoint.getId()!=null){
				//更新记录
				teampointService.updateById(teampoint);
			}else{
				//添加记录
				//teampointService.insertOne(teampoint);
				throw new CustomException("数据更新失败！");
			}
			return "redirect:list";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		teampointService.deleteById(id);
		return "redirect:list";
	}
}
