package com.awsports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.Arena;
import com.awsports.pojo.Tournament;
import com.awsports.pojo.TournamentQuery;
import com.awsports.service.ArenaService;
import com.awsports.service.TournamentService;

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
	
	@RequestMapping("/list")
	public String list(Model model, TournamentQuery tournamentQuery) throws Exception{
		List<TournamentQuery> tournaments=tournamentService.findAll(tournamentQuery);
		model.addAttribute("tournaments", tournaments);
		return "tournament/list";
	}
	
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
	
	@RequestMapping("/save")
	public String save(@Validated Tournament tournament, BindingResult br, Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "tournament/update";
		}else{
			if(tournament.getId()!=null){//更新数据
				tournamentService.updateById(tournament);
			}else{//新增数据
				tournamentService.insertOne(tournament);
			}
			return "redirect:list";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		tournamentService.deleteById(id);
		return "redirect:list";
	}
	
}
