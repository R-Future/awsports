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
import com.awsports.util.CustomException;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	@Autowired
	private ArenaService arenaService;
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:17:37
	 * @param model
	 * @param activityQuery
	 * @throws Exception
	 * @Return: String
	 * @Description: 活动信息列表
	 *
	 */
	@RequestMapping("/list")
	public String list(Model model, ActivityQuery activityQuery) throws Exception{
		List<ActivityQuery> activities=activityService.findAll(activityQuery);
		model.addAttribute("activities", activities);
		return "activity/list";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:17:53
	 * @param model
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 更新或添加活动
	 *
	 */
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
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:18:07
	 * @param activity
	 * @param br
	 * @param model
	 * @throws Exception
	 * @Return: String
	 * @Description: 保存修改后的信息
	 *
	 */
	@RequestMapping("/save")
	public String save(@Validated Activity activity, BindingResult br, Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "forward:update";
		}else{
			if(activity.getId()!=null){//更新
				activityService.updateById(activity);
			}else{//新增
				activityService.insertOne(activity);
			}
			return "redirect:list";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:18:30
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 删除活动
	 *
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{
			activityService.deleteById(id);
			return "redirect:list";
		}
	}
}
