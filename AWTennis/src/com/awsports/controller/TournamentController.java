package com.awsports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.Arena;
import com.awsports.pojo.Pointrule;
import com.awsports.pojo.Tournament;
import com.awsports.pojo.TournamentQuery;
import com.awsports.service.ArenaService;
import com.awsports.service.PointruleService;
import com.awsports.service.TournamentService;
import com.awsports.util.CustomException;
import com.awsports.util.TypeMap;

/**
 * 
 * @author: Fu
 * @time: 2017年5月28日下午6:09:06
 * @description: 实现赛事信息的增删改查 
 *
 */
@Controller
@RequestMapping("/tournament")
public class TournamentController {

	@Autowired
	private TournamentService tournamentService;
	@Autowired
	private ArenaService arenaService;
	@Autowired
	private PointruleService pointruleService;
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:25:30
	 * @param model
	 * @param tournamentQuery
	 * @throws Exception
	 * @Return: String
	 * @Description: 赛事信息列表
	 *
	 */
	@RequestMapping("/list")
	public String list(Model model, TournamentQuery tournamentQuery) throws Exception{
		List<TournamentQuery> tournaments=tournamentService.findAll(tournamentQuery);
		model.addAttribute("tournaments", tournaments);
		return "tournament/list";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:25:48
	 * @param model
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 赛事详细信息，包括赛事积分规则
	 *
	 */
	@RequestMapping("/detail")
	public String detail(Model model, Integer id) throws Exception{
		//根据ID查找赛事信息
		TournamentQuery tournamentQuery=tournamentService.findDetailById(id);
		//根据赛事ID查询相应的积分规则
		List<Pointrule> pointrules=pointruleService.findByTournamentId(tournamentQuery.getTournament().getId());
		model.addAttribute("tournamentQuery", tournamentQuery);
		model.addAttribute("pointrules", pointrules);
		model.addAttribute("roundTypes", TypeMap.roundType());
		return "tournament/detail";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:26:22
	 * @param model
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 更新或添加赛事信息
	 *
	 */
	@RequestMapping("/update")
	public String update(Model model, Integer id) throws Exception{
		Tournament tournament=null;
		List<Arena> arenas=arenaService.findAll(null);
		if(id!=null){//更新数据
			tournament=tournamentService.findById(id);
		}else{//新增数据
			tournament=new Tournament();
		}
		model.addAttribute("tournament", tournament);
		model.addAttribute("arenas", arenas);
		return "tournament/update";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:26:54
	 * @param tournament
	 * @param br
	 * @param model
	 * @throws Exception
	 * @Return: String
	 * @Description: 保存修改后的赛事信息
	 *
	 */
	@RequestMapping("/save")
	public String save(@Validated Tournament tournament, BindingResult br, Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "forward:update";
		}else{
			if(tournament.getId()!=null){//更新数据
				tournamentService.updateById(tournament);
			}else{//新增数据
				tournamentService.insertOne(tournament);
			}
			return "redirect:list";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:27:17
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 删除赛事
	 *
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{
			tournamentService.deleteById(id);
			return "redirect:list";
		}
	}
	
}
