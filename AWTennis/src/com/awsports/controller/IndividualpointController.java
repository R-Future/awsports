package com.awsports.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awsports.pojo.Individualpoint;
import com.awsports.pojo.IndividualpointQuery;
import com.awsports.pojo.User;
import com.awsports.service.IndividualpointService;
import com.awsports.service.UserService;
import com.awsports.util.CustomException;
import com.awsports.util.TypeMap;

@Controller
@RequestMapping("/individualpoint")
public class IndividualpointController {

	@Autowired
	private IndividualpointService individualpointService;
	@Autowired
	private UserService userService;
	private Map<Integer,String> entryTypes=TypeMap.entryType();
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月7日 下午4:35:43
	 * @return: String
	 * @description: 个人积分列表
	 *
	 */
	@RequestMapping("/list")
	public String list(Model model,IndividualpointQuery individualpointQuery) throws Exception{
		List<IndividualpointQuery> individualpointQuerys=individualpointService.findAll(individualpointQuery);
		model.addAttribute("individualpointQuerys", individualpointQuerys);
		model.addAttribute("entryTypes", entryTypes);
		return "individualpoint/list";
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月7日 下午4:36:05
	 * @return: String
	 * @description: 更新或新增一条记录
	 *
	 */
	@RequestMapping("/update")
	public String update(Model model,Integer id) throws Exception{
		Individualpoint individualpoint=null;
		if(id!=null){//更新数据
			individualpoint=individualpointService.findById(id);
		}else{
			//新增数据
			throw new CustomException("非法操作！");
		}
		model.addAttribute("individualpoint", individualpoint);
		//用户
		List<User> users=userService.findAll(null);
		model.addAttribute("users", users);
		//参赛类型
		model.addAttribute("entryTypes", entryTypes);
		return "individualpoint/update";
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月7日 下午4:36:25
	 * @return: String
	 * @description: 保存修改后的记录，保存成功后跳转到积分列表页面
	 *
	 */
	@RequestMapping("/save")
	public String save(@Validated Individualpoint individualpoint,BindingResult br,Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "individualpoint/update";
		}else{
			if(individualpoint.getId()!=null){
				//更新数据
				individualpointService.updateById(individualpoint);
			}else{
				//新增数据
				throw new CustomException("数据更新失败！");
			}
			return "redirect:list";
		}
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月7日 下午4:36:37
	 * @return: String
	 * @description: 删除一条记录，删除成功后跳转到积分列表页面
	 *
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		individualpointService.deleteById(id);
		return "redirect:list";
	}
}
