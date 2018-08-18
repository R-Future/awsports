package com.awsports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.Level;
import com.awsports.service.LevelService;
import com.awsports.util.CustomException;

@Controller
@RequestMapping("/level")
public class LevelController {
	
	@Autowired
	private LevelService levelService;
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月27日 下午2:51:02
	 * @param model
	 * @param level
	 * @throws Exception
	 * @Return: String
	 * @Description: 俱乐部等级列表
	 *
	 */
	@RequestMapping("/list")
	public String list(Model model, Level level) throws Exception{
		List<Level> levels=levelService.findAll(level);
		model.addAttribute("levels", levels);
		return "level/list";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月27日 下午2:51:21
	 * @param model
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 更新或添加等级信息
	 *
	 */
	@RequestMapping("/update")
	public String update(Model model, Integer id) throws Exception{
		Level level=null;
		if(id!=null){
			//更新记录
			level=levelService.findById(id);
		}else{
			//添加记录
			level=new Level();
		}
		model.addAttribute("level", level);
		//获取父类级别
		List<Level> levels=levelService.findAll(null);
		model.addAttribute("levels", levels);
		return "level/update";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月27日 下午2:51:39
	 * @param level
	 * @param br
	 * @param model
	 * @throws Exception
	 * @Return: String
	 * @Description: 保存修改后的信息
	 *
	 */
	@RequestMapping("/save")
	public String save(@Validated Level level,BindingResult br, Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			model.addAttribute("id", level.getId());
			return "forward:update";
		}else{
			if(level.getId()!=null){
				//保存更新的记录
				levelService.updateById(level);
			}else{
				//保存新增的记录
				levelService.insertOne(level);
			}
			return "redirect:list";
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年6月27日 下午2:51:53
	 * @param id
	 * @throws Exception
	 * @Return: String
	 * @Description: 删除等级记录
	 *
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{
			levelService.deleteById(id);
			return "redirect:list";
		}
	}
}
