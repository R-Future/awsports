package com.awsports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.Activity;
import com.awsports.pojo.ActivityQuery;
import com.awsports.pojo.Arena;
import com.awsports.service.ActivityService;
import com.awsports.service.ArenaService;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	@Autowired
	private ArenaService arenaService;
	
	@RequestMapping("/list")
	public String list(Model model, ActivityQuery activityQuery) throws Exception{
		List<ActivityQuery> activities=activityService.findAll(activityQuery);
		model.addAttribute("activities", activities);
		return "activity/list";
	}
	
	@RequestMapping("/update")
	public String update(Model model, Integer id) throws Exception{
		Activity activity=null;
		List<Arena> arenas=arenaService.findAll(null);
		if(id!=null){//更新数据
			activity=activityService.findById(id);
		}else{//新增数据
			activity=new Activity();
		}
		model.addAttribute("activity", activity);
		model.addAttribute("arenas", arenas);
		return "activity/update";
	}
	
	@RequestMapping("/save")
	public String save(@Validated Activity activity, BindingResult br, Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "activity/update";
		}else{
			if(activity.getId()!=null){//更新
				activityService.updateById(activity);
			}else{//新增
				activityService.insertOne(activity);
			}
			return "redirect:list";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		activityService.deleteById(id);
		return "redirect:list";
	}
}
