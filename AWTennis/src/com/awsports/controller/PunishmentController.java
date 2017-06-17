package com.awsports.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.Punishment;
import com.awsports.pojo.PunishmentQuery;
import com.awsports.pojo.TournamentQuery;
import com.awsports.pojo.User;
import com.awsports.service.PunishmentService;
import com.awsports.service.TournamentService;
import com.awsports.service.UserService;
import com.awsports.util.TypeMap;

@Controller
@RequestMapping("/punishment")
public class PunishmentController {
	
	@Autowired
	private PunishmentService punishmentService;
	@Autowired
	private TournamentService tournamentService;
	@Autowired
	private UserService userService;
	
	private Map<Integer,String> individualEntryTypes=TypeMap.individualEntryType();
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月17日 下午5:32:19
	 * @return: String
	 * @description: 个人扣分列表,punishmentQuery是查询条件
	 *
	 */
	@RequestMapping("/list")
	public String list(Model model, PunishmentQuery punishmentQuery) throws Exception{
		List<PunishmentQuery> punishmentQuerys=punishmentService.findAll(punishmentQuery);
		model.addAttribute("punishmentQuerys", punishmentQuerys);
		//获取参赛类型
		model.addAttribute("individualEntryTypes", individualEntryTypes);
		return "punishment/list";
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月17日 下午5:32:38
	 * @return: String
	 * @description: 更新或添加个人扣分记录
	 *
	 */
	@RequestMapping("/update")
	public String update(Model model,Integer id) throws Exception{
		Punishment punishment=null;
		if(id!=null){
			//更新数据
			punishment=punishmentService.findById(id);
		}else{
			//添加数据
			punishment=new Punishment();
		}
		model.addAttribute("punishment", punishment);
		//获取赛事信息
		List<TournamentQuery> tournamentQuerys=tournamentService.findAll(null);
		model.addAttribute("tournamentQuerys", tournamentQuerys);
		//获取参赛类型
		model.addAttribute("individualEntryTypes", individualEntryTypes);
		//获取用户信息
		List<User> users=userService.findAll(null);
		model.addAttribute("users", users);
		return "punishment/update";
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月17日 下午5:33:14
	 * @return: String
	 * @description: 保存修改后或新增的个人扣分记录
	 *
	 */
	@RequestMapping("/save")
	public String save(@Validated Punishment punishment,BindingResult br,Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "redirect:udpate";
		}else{
			if(punishment.getId()!=null){
				//更新数据
				punishmentService.updateById(punishment);
			}else{
				//添加数据
				punishmentService.insertOne(punishment);
			}
			return "redirect:list";
		}
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月17日 下午5:33:45
	 * @return: String
	 * @description: 删除个人扣分记录
	 *
	 */
	@RequestMapping("delete")
	public String delete(Integer id) throws Exception{
		punishmentService.deleteById(id);
		return "redirect:list";
	}
}
