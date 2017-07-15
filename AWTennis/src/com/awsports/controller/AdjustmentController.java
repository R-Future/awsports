package com.awsports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.awsports.pojo.Individualrank;
import com.awsports.pojo.IndividualrankQuery;
import com.awsports.pojo.Level;
import com.awsports.pojo.Qualificationrank;
import com.awsports.pojo.QualificationrankQuery;
import com.awsports.pojo.TournamentQuery;
import com.awsports.pojo.User;
import com.awsports.pojo.UserQuery;
import com.awsports.service.IndividualrankService;
import com.awsports.service.LevelService;
import com.awsports.service.QualificationrankService;
import com.awsports.service.TournamentService;
import com.awsports.service.UserService;
import com.awsports.util.EntryEnum;

/**
 * 
 * @Version: 0.1.4
 * @Author: peRFect
 * @Date: 2017年7月15日 上午11:14:37
 * @Description: 对球员的俱乐部等级进行调整
 *
 */
@Controller
@RequestMapping("/adjustment")
public class AdjustmentController {
	
	@Autowired
	private IndividualrankService individualrankService;
	@Autowired
	private UserService userService;
	@Autowired
	private LevelService levelService;
	@Autowired
	private TournamentService tournamentService;
	@Autowired
	private QualificationrankService qualificationrankService;
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月15日 下午1:10:19
	 * @param number
	 * @param downgradeLevel
	 * @param upgradeLevel
	 * @return
	 * @throws Exception
	 * @Return: String
	 * @Description: 俱乐部等级升降
	 *
	 */
	@RequestMapping("/adjust")
	public String adjust(Model model) throws Exception{
		
		//获取赛事信息
		List<TournamentQuery> tournamentQuerys=tournamentService.findAll(null);
		model.addAttribute("tournamentQuerys",tournamentQuerys);
		//获取俱乐部等级类型
		List<Level> levels = levelService.findAll(null);
		model.addAttribute("levels", levels);
		return "ajustment/adjust";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月15日 下午2:19:20
	 * @param number
	 * @param highLevel
	 * @param lowLevel
	 * @throws Exception
	 * @Return: void
	 * @Description: 常规调整（若干月一次）
	 *
	 */
	@RequestMapping("routine")
	public String routine(@RequestParam(defaultValue="0") Integer number, 
			   		  @RequestParam(defaultValue="0") Integer highLevel, 
			   		  @RequestParam(defaultValue="0") Integer lowLevel) throws Exception{
		IndividualrankQuery individualrankQuery=new IndividualrankQuery();
		Individualrank individualrank=new Individualrank();
		UserQuery userQuery=new UserQuery();
		Level level=new Level();
		User user = null;
		
		//查询混合单打的排名
		individualrank.setEntry(EntryEnum.MIXEDSINGLE.getValue());
		individualrankQuery.setIndividualrank(individualrank);
		//获取高组别混合单打的排名
		level.setId(highLevel);
		userQuery.setLevel(level);
		individualrankQuery.setUserQuery(userQuery);
		List<IndividualrankQuery> highLevelIndividualrankQuerys=individualrankService.findAll(individualrankQuery);
		//获取低组别混合单打的排名
		level.setId(lowLevel);
		userQuery.setLevel(level);
		individualrankQuery.setUserQuery(userQuery);
		List<IndividualrankQuery> lowLevelIndividualrankQuerys=individualrankService.findAll(individualrankQuery);
		
		//高组别降入低组别
		if(highLevelIndividualrankQuerys != null && highLevelIndividualrankQuerys.size() > 0){
			for(int i = highLevelIndividualrankQuerys.size()-1, j = 0; i >= 0 && j < number; i--, j++){
				user = userService.findById(highLevelIndividualrankQuerys.get(i).getUserQuery().getUser().getId());
				user.setGrade(lowLevel);
				userService.updateById(user);
			}
		}
		//低级别升入高级别
		if(lowLevelIndividualrankQuerys != null && lowLevelIndividualrankQuerys.size() > 0){
			for(int i = 0, j = 0; i < lowLevelIndividualrankQuerys.size() && j < number; i++, j++){
				user = userService.findById(lowLevelIndividualrankQuerys.get(i).getUserQuery().getUser().getId());
				user.setGrade(highLevel);
				userService.updateById(user);
			}
		}
		return "success";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月15日 下午7:52:55
	 * @param qhDownNumber
	 * @param qhHighLevel
	 * @param qhLowLevel
	 * @return
	 * @throws Exception
	 * @Return: String
	 * @Description: 资格赛前金组排名靠后的若干名降级到相应组别
	 *
	 */
	@RequestMapping("/qualificationDowngrade")
	public String qualificationDowngrade(@RequestParam(defaultValue="0") Integer qhDownNumber, 
								   		 @RequestParam(defaultValue="0") Integer qhHighLevel, 
								   		 @RequestParam(defaultValue="0") Integer qhLowLevel) throws Exception{
		IndividualrankQuery individualrankQuery=new IndividualrankQuery();
		Individualrank individualrank=new Individualrank();
		UserQuery userQuery=new UserQuery();
		Level level=new Level();
		User user = null;
		
		//查询混合单打的排名
		individualrank.setEntry(EntryEnum.MIXEDSINGLE.getValue());
		individualrankQuery.setIndividualrank(individualrank);
		//获取高组别混合单打的排名
		level.setId(qhHighLevel);
		userQuery.setLevel(level);
		individualrankQuery.setUserQuery(userQuery);
		List<IndividualrankQuery> highLevelIndividualrankQuerys=individualrankService.findAll(individualrankQuery);
		
		//高组别降入低组别
		if(highLevelIndividualrankQuerys != null && highLevelIndividualrankQuerys.size() > 0){
			for(int i = highLevelIndividualrankQuerys.size()-1, j = 0; i >= 0 && j < qhDownNumber; i--, j++){
				user = userService.findById(highLevelIndividualrankQuerys.get(i).getUserQuery().getUser().getId());
				user.setGrade(qhLowLevel);
				userService.updateById(user);
			}
		}
		
		return "success";
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月15日 下午7:53:27
	 * @param qhUpNumber
	 * @param qhTournament
	 * @param qhUptoLevel
	 * @return
	 * @throws Exception
	 * @Return: String
	 * @Description: 资格赛后，资格赛排名靠前的若干名升级到相应组别
	 *
	 */
	@RequestMapping("/qualificationUpgrade")
	public String qualificationUpgrade(@RequestParam(defaultValue="0") Integer qhUpNumber, 
								   	   @RequestParam(defaultValue="0") Integer qhTournament, 
								   	   @RequestParam(defaultValue="0") Integer qhUptoLevel) throws Exception{
		QualificationrankQuery qualificationrankQuery = new QualificationrankQuery();
		Qualificationrank qualificationrank = new Qualificationrank();
		User user = null;
		
		//获取该赛事资格赛的个人排名
		qualificationrank.setTournamentid(qhTournament);
		qualificationrankQuery.setQualificationrank(qualificationrank);
		List<QualificationrankQuery> qualificationrankQuerys = qualificationrankService.findAll(qualificationrankQuery);
		//低级别升入高级别
		if(qualificationrankQuerys != null && qualificationrankQuerys.size() > 0){
			for(int i = 0, j = 0; i < qualificationrankQuerys.size() && j < qhUpNumber; i++, j++){
				user = userService.findById(qualificationrankQuerys.get(i).getUserQuery().getUser().getId());
				user.setGrade(qhUptoLevel);
				userService.updateById(user);
			}
		}
		return "success";
	}
}
