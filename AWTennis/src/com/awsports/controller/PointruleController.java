package com.awsports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.Pointrule;
import com.awsports.service.PointruleService;
import com.awsports.util.TypeMap;

@Controller
@RequestMapping("/pointrule")
public class PointruleController {

	@Autowired
	private PointruleService pointruleService;
	
	@RequestMapping("/update")
	public String update(Model model,Integer id,Integer tournamentid) throws Exception{
		Pointrule pointrule=null;
		if(id!=null){//更新数据
			pointrule=pointruleService.findById(id);
		}else{//新增数据
			pointrule=new Pointrule();
			pointrule.setTournamentid(tournamentid);
		}
		model.addAttribute("pointrule", pointrule);
		model.addAttribute("roundTypes", TypeMap.roundType());
		return "pointrule/update";
	}
	
	
	
	@RequestMapping("/save")
	public String save(@Validated Pointrule pointrule, BindingResult br, Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "pointrule/update";
		}else{
			if(pointrule.getId()!=null){//更新数据
				pointruleService.updateById(pointrule);
			}else{//添加数据
				pointruleService.insertOne(pointrule);
			}
			//返回赛事详情页面
			model.addAttribute("id", pointrule.getTournamentid());
			return "redirect:/tournament/detail";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(Model model,Integer id,Integer tournamentid) throws Exception{
		pointruleService.deleteById(id);
		model.addAttribute("id", tournamentid);
		return "redirect:/tournament/detail";
	}
	
}
