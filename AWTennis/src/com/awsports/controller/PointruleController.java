package com.awsports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.Pointrule;
import com.awsports.service.PointruleService;
import com.awsports.util.CustomException;
import com.awsports.util.TypeMap;

@Controller
@RequestMapping("/pointrule")
public class PointruleController {

	@Autowired
	private PointruleService pointruleService;
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:20:42
	 * @param model
	 * @param id
	 * @param tournamentid
	 * @throws Exception
	 * @Return: String
	 * @Description: 更新或添加积分规则
	 *
	 */
	@RequestMapping("/update")
	public String update(Model model,Integer id,Integer tournamentid) throws Exception{
		Pointrule pointrule=null;
		if(id!=null){//更新数据
			pointrule=pointruleService.findById(id);
		}else{//新增数据
			if(tournamentid == null){
				throw new CustomException("无法指定积分规则所属赛事");
			}else{
				pointrule=new Pointrule();
				pointrule.setTournamentid(tournamentid);
			}
		}
		model.addAttribute("pointrule", pointrule);
		model.addAttribute("roundTypes", TypeMap.roundType());
		return "pointrule/update";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:22:12
	 * @param pointrule
	 * @param br
	 * @param model
	 * @throws Exception
	 * @Return: String
	 * @Description: 保存修改后的记录 
	 *
	 */
	@RequestMapping("/save")
	public String save(@Validated Pointrule pointrule, BindingResult br, Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			model.addAttribute("id", pointrule.getId());
			model.addAttribute("tournamentid", pointrule.getTournamentid());
			return "forward:update";
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
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:22:43
	 * @param model
	 * @param id
	 * @param tournamentid
	 * @throws Exception
	 * @Return: String
	 * @Description: 删除记录
	 *
	 */
	@RequestMapping("/delete")
	public String delete(Model model,Integer id,Integer tournamentid) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{
			pointruleService.deleteById(id);
			model.addAttribute("id", tournamentid);
			return "redirect:/tournament/detail";
		}
	}
	
}
