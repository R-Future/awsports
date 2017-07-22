package com.awsports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.Arena;
import com.awsports.service.ArenaService;
import com.awsports.util.CustomException;
import com.awsports.util.TypeMap;

@Controller
@RequestMapping("/arena")
public class ArenaController {
	
	@Autowired
	private ArenaService arenaService;
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:16:12
	 * @param model
	 * @param arena
	 * @throws Exception
	 * @Return: String
	 * @Description: 场馆信息列表
	 *
	 */
	@RequestMapping("/list")
	public String list(Model model, Arena arena) throws Exception{
		List<Arena> arenas=arenaService.findAll(arena);		
		model.addAttribute("arenas", arenas);
		//传入场地类型的数字和类型间的映射表
		model.addAttribute("arenaTypes", TypeMap.arenaType());
		return "arena/list";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:16:34
	 * @param model
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 更新或添加场馆
	 *
	 */
	@RequestMapping("/update")
	public String update(Model model, Integer id) throws Exception{
		Arena arena=null;
		if(id!=null){//更新数据
			arena=arenaService.findById(id);
		}else{//添加数据
			arena=new Arena();
		}
		model.addAttribute("arena",arena);
		model.addAttribute("arenaTypes", TypeMap.arenaType());
		return "arena/update";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:16:51
	 * @param arena
	 * @param br
	 * @param model
	 * @throws Exception
	 * @Return: String
	 * @Description: 保存修改后的场馆信息
	 *
	 */
	@RequestMapping("/save")
	public String save(@Validated Arena arena, BindingResult br, Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "forward:update";
		}else{
			try{
				if(arena.getId()!=null){//更新数据
					arenaService.updateById(arena);
				}else{//添加数据
					arenaService.insertOne(arena);
				}
				//成功后返回列表
				return "redirect:list";
			}catch(CustomException e){
				//添加一个自定义的异常类，将错误信息返回到错误页面
				e=new CustomException("数据保存失败");
				model.addAttribute("errorMessage",e.getMessage());
				return "error";
			}
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月26日 下午6:17:14
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 删除场馆记录
	 *
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{
			arenaService.deleteById(id);
			//删除成功，跳转到列表页面
			return "redirect:list";
		}
	}
}
