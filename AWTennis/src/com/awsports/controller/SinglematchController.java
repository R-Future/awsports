package com.awsports.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.awsports.pojo.Arena;
import com.awsports.pojo.Pointrule;
import com.awsports.pojo.Singlematch;
import com.awsports.pojo.SinglematchQuery;
import com.awsports.pojo.SinglematchQueryVo;
import com.awsports.pojo.Singlematchscore;
import com.awsports.pojo.TournamentQuery;
import com.awsports.pojo.User;
import com.awsports.pojo.UserQuery;
import com.awsports.service.ArenaService;
import com.awsports.service.IndividualpointService;
import com.awsports.service.PointruleService;
import com.awsports.service.SinglematchService;
import com.awsports.service.SinglematchscoreService;
import com.awsports.service.TournamentService;
import com.awsports.service.UserService;
import com.awsports.util.CalculatePoint;
import com.awsports.util.CustomException;
import com.awsports.util.EntryEnum;
import com.awsports.util.RoundEnum;
import com.awsports.util.SexEnum;
import com.awsports.util.TypeMap;
import com.awsports.util.WinLoseEnum;

@Controller
@RequestMapping("/singlematch")
public class SinglematchController {
	
	@Autowired
	private SinglematchService singlematchService;
	@Autowired
	private ArenaService arenaService;
	@Autowired
	private TournamentService tournamentService;
	@Autowired
	private SinglematchscoreService singlematchscoreService;
	@Autowired
	private UserService userService;
	@Autowired
	private PointruleService pointruleService;
	@Autowired
	private IndividualpointService individualpointService;
	
	private Map<Integer,String> roundTypes=TypeMap.roundType();
	
	private int winnerPoint;
	private int loserPoint;
	private int penalty;
	private int hcMarginBureau;
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月6日
	 * @return: String
	 * @description: 显示单打比赛记录
	 *
	 */
	@RequestMapping("/list")
	public String list(Model model,SinglematchQuery singlematchQuery) throws Exception{
		List<SinglematchQuery> singlematchs=singlematchService.findAll(singlematchQuery);
		model.addAttribute("singlematchs", singlematchs);
		model.addAttribute("entryTypes", TypeMap.entryType());
		model.addAttribute("roundTypes", roundTypes);
		return "singlematch/list";
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月3日
	 * @return: String
	 * @description: 记录比赛
	 *
	 */
	@RequestMapping("/add")
	public String add(Model model) throws Exception{
		//比赛场地
		List<Arena> arenas=arenaService.findAll(null);
		model.addAttribute("arenas", arenas);
		//赛事类型
		List<TournamentQuery> tournamentQuerys=tournamentService.findAll(null);
		model.addAttribute("tournamentQuerys", tournamentQuerys);
		//比赛轮次
		model.addAttribute("roundTypes", roundTypes);
		return "singlematch/add";
	} 
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月5日
	 * @return: String
	 * @description: 使用ajax从前端传回数据,从而得知要记录的比赛数量，以及每场比赛的盘数，@RequestParam(defaultValue="1")设置初始值为1,默认一场比赛一盘
	 *
	 */
	@RequestMapping(value="/addRecord",method={RequestMethod.POST})
	public String addRecord(Model model,@RequestParam(defaultValue="1") Integer matches,@RequestParam(defaultValue="1") Integer sets) throws Exception{
		//单打比赛记录
		List<SinglematchQuery> singlematchQuerys=new ArrayList<SinglematchQuery>();
		SinglematchQuery singlematchQuery=null;
		List<Singlematchscore> singlematchscores=null;
		for(int i=0;i<matches.intValue();i++){
			singlematchQuery=new SinglematchQuery();
			singlematchQuery.setSinglematch(new Singlematch());
			//每场比赛的比分
			singlematchscores=new ArrayList<Singlematchscore>();
			for(int j=0;j<sets.intValue();j++){
				singlematchscores.add(new Singlematchscore());
			}
			singlematchQuery.setSinglematchscores(singlematchscores);
			singlematchQuerys.add(singlematchQuery);
		}
		model.addAttribute("singlematchQuerys", singlematchQuerys);
		//选手
		List<UserQuery> userQuerys=userService.findAll(null);
		model.addAttribute("userQuerys", userQuerys);
		return "singlematch/record";
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月8日 下午5:11:25
	 * @return: String
	 * @description: 更新比赛记录
	 *
	 */
	@RequestMapping("/update")
	public String update(Model model,@RequestParam(required=true) Integer id) throws Exception{
		Singlematch singlematch=singlematchService.findById(id);		
		List<Singlematchscore> singlematchscores=singlematchscoreService.findByMatchid(id);
		if(singlematchscores==null){//该比事无比分记录
			singlematchscores=new ArrayList<Singlematchscore>();
			Singlematchscore singlematchscore=null;
			for(int i=0;i<singlematch.getSets().intValue();i++){
				singlematchscore=new Singlematchscore();
				singlematchscore.setId(id);
				singlematchscore.setSetth(i+1);
				singlematchscore.setAptiescore(0);
				singlematchscore.setHctiescore(0);
				singlematchscores.add(singlematchscore);
			}
		}else{}
		SinglematchQuery singlematchQuery=new SinglematchQuery();
		singlematchQuery.setSinglematch(singlematch);
		singlematchQuery.setSinglematchscores(singlematchscores);
		model.addAttribute("singlematchQuery", singlematchQuery);
		//选手
		List<UserQuery> userQuerys=userService.findAll(null);
		model.addAttribute("userQuerys", userQuerys);
		//比赛场地
		List<Arena> arenas=arenaService.findAll(null);
		model.addAttribute("arenas", arenas);
		//赛事类型
		List<TournamentQuery> tournamentQuerys=tournamentService.findAll(null);
		model.addAttribute("tournamentQuerys", tournamentQuerys);
		//比赛轮次
		model.addAttribute("roundTypes", roundTypes);
		return "singlematch/update";
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月7日 上午9:56:54
	 * @return: String
	 * @description: 保存新增的单打比赛记录
	 *
	 */
	@RequestMapping("/saveNew")
	public String saveNew(@Validated SinglematchQueryVo singlematchQueryVo,
									 BindingResult br, 
									 Model model,
									 Date matchtime,
									 Integer matchplace,
									 Integer tournamentid,
									 Integer round,
									 Integer sets) throws Exception{
		if(singlematchQueryVo!=null){
			List<SinglematchQuery> singlematchQuerys=singlematchQueryVo.getSinglematchQuerys();
			if(br.hasErrors()){
				model.addAttribute("errors", br);
				return "singlematch/add";
			}else{
				if(singlematchQuerys==null){
					throw new CustomException("比赛信息为空，无法保存！");
				}else{
					if(getPointrule(tournamentid,round)){
						for(SinglematchQuery singlematchQuery:singlematchQuerys){
							Singlematch originMatch=singlematchQuery.getSinglematch();
							List<Singlematchscore> originMatchscores=singlematchQuery.getSinglematchscores();
							originMatch.setMatchtime(matchtime);//比赛时间
							originMatch.setMatchplace(matchplace);//比赛地点
							originMatch.setTournamentid(tournamentid);//赛事类型
							originMatch.setRound(round);//比赛轮次
							originMatch.setSets(sets);//比赛盘数
							setOriginMatch(originMatch,originMatchscores);//设置比赛记录保存项
							//save single match record
							singlematchService.insertOne(originMatch);
							//exchange the home contestant and away player, then save another match record
							Singlematch mirrorMatch=new Singlematch();
							setMirrorMatch(originMatch,mirrorMatch);//设置镜像比赛保存项
							singlematchService.insertOne(mirrorMatch);
							//save match scores
							Integer originMatchid=originMatch.getId();
							Integer mirrorMatchid=mirrorMatch.getId();
							Singlematchscore mirrorMatchscore=null;
							for(Singlematchscore originMatchscore:originMatchscores){
								//origin match score
								originMatchscore.setMatchid(originMatchid);
								singlematchscoreService.insertOne(originMatchscore);
								//mirror match score
								mirrorMatchscore=new Singlematchscore();
								setMirrorMatchscore(originMatchscore,mirrorMatchscore,mirrorMatchid);
								singlematchscoreService.insertOne(mirrorMatchscore);
								
							}
							//比赛有效才可更新积分
							if(originMatch.getInvalid()==null||!originMatch.getInvalid().booleanValue()){
								//更新个人积分
								//获取年终赛事的id
								CalculatePoint calculatePoint=new CalculatePoint(originMatch,hcMarginBureau,tournamentService);
								if(!calculatePoint.individual(individualpointService,originMatch)){
									throw new CustomException("积分保存失败");
								}			
							}else{
								continue;
							}
						}
						return "redirect:add";
					}else{
						throw new CustomException("未匹配到当前赛事本轮次的积分");
					}
				}//end if(singlematchQuerys==null)
			}
		}else{
			throw new CustomException("非法操作！");
		}
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月9日 上午10:01:07
	 * @return: String
	 * @description: 保存更新的比赛记录
	 *
	 */
	@RequestMapping("/saveOld")
	public String saveOld(@Validated SinglematchQuery singlematchQuery,BindingResult br,Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "singlematch/update";
		}else{
			Singlematch originMatch=singlematchQuery.getSinglematch();
			List<Singlematchscore> originMatchscores=singlematchQuery.getSinglematchscores();
			Singlematch oldOriginMatch=singlematchService.findById(originMatch.getId());
			List<Singlematchscore> oldOriginMatchscores=singlematchscoreService.findByMatchid(originMatch.getId());
			CalculatePoint calculatePoint=null;
			if(oldOriginMatch!=null&&!oldOriginMatch.getInvalid().booleanValue()){
				if(oldOriginMatchscores==null){
					throw new CustomException("原比赛比分记录不存在，积分删除失败！");
				}else{
					//扣除原比赛记录所对应的个人积分
					hcMarginBureau=0;//主场选手的净胜局
					for(Singlematchscore oldOriginMatchscore:oldOriginMatchscores){
						//必须是合法数据
						if(!oldOriginMatchscore.getInvalid().booleanValue()){
							hcMarginBureau+=oldOriginMatchscore.getHcscore().intValue()-oldOriginMatchscore.getApscore().intValue();
						}else{
							continue;
						}
					}
					calculatePoint=new CalculatePoint(oldOriginMatch,hcMarginBureau,tournamentService);
					if(!calculatePoint.deleteIndividual(individualpointService, oldOriginMatch)){
						throw new CustomException("原始积分删除失败，无法更新比赛记录");
					}else{
						//删除单打冠军得数
						deleteSingleTitles(oldOriginMatch);
					}
				}
			}
			
			if(getPointrule(originMatch.getTournamentid(),originMatch.getRound())){
				setOriginMatch(originMatch,originMatchscores);			
				//save single match record
				singlematchService.updateById(originMatch);
				//exchange the home contestant and away player, then save another match record
				Singlematch oldMirrorMatch=singlematchService.findMirrorByOrigin(oldOriginMatch);
				List<Singlematchscore> oldMirrorMatchscores=null;
				Integer oldMirrorMatchid=null;
				if(oldMirrorMatch!=null){
					oldMirrorMatchid=oldMirrorMatch.getId();
					setMirrorMatch(originMatch,oldMirrorMatch);		
					singlematchService.updateById(oldMirrorMatch);
					oldMirrorMatchscores=singlematchscoreService.findByMatchid(oldMirrorMatchid);
					Singlematchscore oldMirrorMatchscore=null;
					for(Singlematchscore originMatchscore:originMatchscores){
						//origin match score
						singlematchscoreService.updateById(originMatchscore);
						//added match score
						if(oldMirrorMatchscores!=null){
							oldMirrorMatchscore=oldMirrorMatchscores.get(originMatchscore.getSetth().intValue()-1);
							setMirrorMatchscore(originMatchscore,oldMirrorMatchscore,oldMirrorMatchid);
							singlematchscoreService.updateById(oldMirrorMatchscore);
						}else{
							oldMirrorMatchscore=new Singlematchscore();
							setMirrorMatchscore(originMatchscore,oldMirrorMatchscore,oldMirrorMatchid);
							singlematchscoreService.insertOne(oldMirrorMatchscore);
						}
						
					}
				}else{
					oldMirrorMatch=new Singlematch();
					setMirrorMatch(originMatch,oldMirrorMatch);
					singlematchService.insertOne(oldMirrorMatch);
					oldMirrorMatchid=oldMirrorMatch.getId();
					Singlematchscore oldMirrorMatchscore=null;
					for(Singlematchscore originMatchscore:originMatchscores){
						//origin match score
						singlematchscoreService.updateById(originMatchscore);
						//added match score
						oldMirrorMatchscore=new Singlematchscore();
						setMirrorMatchscore(originMatchscore,oldMirrorMatchscore,oldMirrorMatchid);
						singlematchscoreService.insertOne(oldMirrorMatchscore);	
					}
				}
				//有效比赛才可更新积分
				if(!originMatch.getInvalid().booleanValue()){
					calculatePoint=new CalculatePoint(originMatch,hcMarginBureau,tournamentService);
					if(!calculatePoint.individual(individualpointService, originMatch)){
						throw new CustomException("积分更新失败");
					}
				}else{
					//...
				}//end if(!originMatch.getInvalid().booleanValue())
				return "redirect:list";
			}else{
				throw new CustomException("未匹配到当前赛事本轮次的积分");
			}//end if(pointrule!=null&&!pointrule.getInvalid())
		}//end if(br.hasErrors())
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月7日 下午4:48:52
	 * @return: String
	 * @description: 根据id删除比赛记录
	 *
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{
			//先扣除该比赛的个人积分
			Singlematch originMatch=singlematchService.findById(id);
			List<Singlematchscore> originMatchscores=singlematchscoreService.findByMatchid(id);
			if(originMatch!=null&&originMatchscores!=null){
				//比赛须有效才可删除积分和个人单打冠军得数
				if(!originMatch.getInvalid().booleanValue()){
					//扣除原比赛记录所对应的个人积分
					hcMarginBureau=0;//主场选手的净胜局
					for(Singlematchscore originMatchscore:originMatchscores){
						//必须是合法数据
						if(!originMatchscore.getInvalid().booleanValue()){
							hcMarginBureau+=originMatchscore.getHcscore().intValue()-originMatchscore.getApscore().intValue();
						}else{
							continue;
						}
					}
					//获取年终赛事的id
					CalculatePoint calculatePoint=new CalculatePoint(originMatch,hcMarginBureau,tournamentService);
					if(!calculatePoint.deleteIndividual(individualpointService, originMatch)){
						throw new CustomException("删除个人积分失败");
					}else{
						//删除单打冠军得数
						deleteSingleTitles(originMatch);
					}	
				}else{
					//...
				}
				//删除镜像比赛记录
				Singlematch mirrorMatch=singlematchService.findMirrorByOrigin(originMatch);
				if(mirrorMatch!=null){
					singlematchscoreService.deleteByMatchid(mirrorMatch.getId());
					singlematchService.deleteById(mirrorMatch.getId());
				}else{
					//...
				}
				//由于存在外键约束，所以先根据matchid删除比分
				singlematchscoreService.deleteByMatchid(id);
				//删除比赛
				singlematchService.deleteById(id);	
				return "redirect:list";
			}else{
				throw new CustomException("未查询到相关比赛记录，无法进行删除操作！");
			}
		}
	}

	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月9日 下午4:34:42
	 * @return: void
	 * @description: 设置比赛记录的保存项
	 *
	 */
	private void setOriginMatch(Singlematch originMatch,List<Singlematchscore> originMatchscores) throws Exception{
		//根据选手性别记录参赛类型
		User homeContestant=userService.findById(originMatch.getHomecontestant());
		User awayPlayer=userService.findById(originMatch.getAwayplayer());
		if(homeContestant.getSex()==awayPlayer.getSex()&&awayPlayer.getSex()==SexEnum.MALE.getValue()){
			//男单
			originMatch.setEntry(EntryEnum.MANSINGLE.getValue());
		}else if(homeContestant.getSex()==awayPlayer.getSex()&&awayPlayer.getSex()==SexEnum.FEMALE.getValue()){
			//女单
			originMatch.setEntry(EntryEnum.WOMANSINGLE.getValue());
		}else{
			//混合单打
			originMatch.setEntry(EntryEnum.MIXEDSINGLE.getValue());
		}
		
		//根据比赛推算胜负
		int hcSets=0,apSets=0;
		int hcScore=0;
		int apScore=0;
		hcMarginBureau=0;//home contestant's margin bureau;
		for(Singlematchscore originMatchscore:originMatchscores){
			//必须是有效比分
			if(originMatchscore.getInvalid()==null||!originMatchscore.getInvalid().booleanValue()){
				hcScore=originMatchscore.getHcscore().intValue();
				apScore=originMatchscore.getApscore().intValue();
				hcMarginBureau+=hcScore-apScore;
				if(hcScore>apScore){
					hcSets++;
				}else if(hcScore<apScore){
					apSets++;
				}else{
					continue;
				}
			}else{
				continue;
			}
		}
		if(hcSets>apSets){//主场选手胜
			originMatch.setOutcome(WinLoseEnum.WIN.getValue());
			//主场选手
			if(originMatch.getHcretired()){//退赛扣分
				originMatch.setHcpoint(winnerPoint-penalty);
			}else{
				originMatch.setHcpoint(winnerPoint);
			}
			//客场选手
			if(originMatch.getApretired()){//退赛扣分
				if(originMatch.getIsapchallenger().booleanValue()){
					//如果败者为挑战者
					originMatch.setAppoint(-penalty);
				}else{
					originMatch.setAppoint(loserPoint-penalty);
				}	
			}else{//未退赛
				if(originMatch.getIsapchallenger().booleanValue()){
					//如果败者为挑战者
					originMatch.setAppoint(0);
				}else{
					originMatch.setAppoint(loserPoint);
				}
			}
			
		}else if(hcSets<apSets){//客场选手胜
			originMatch.setOutcome(WinLoseEnum.LOSE.getValue());
			//主场选手
			if(originMatch.getHcretired()){//退赛扣分
				if(originMatch.getIshcchallenger().booleanValue()){
					originMatch.setHcpoint(-penalty);
				}else{
					originMatch.setHcpoint(loserPoint-penalty);
				}				
			}else{
				if(originMatch.getIshcchallenger().booleanValue()){
					originMatch.setHcpoint(0);
				}else{
					originMatch.setHcpoint(loserPoint);
				}		
			}
			//客场选手
			if(originMatch.getApretired()){//退赛扣分
				originMatch.setAppoint(winnerPoint-penalty);
			}else{
				originMatch.setAppoint(winnerPoint);
			}
		}else{
			originMatch.setOutcome(WinLoseEnum.TIE.getValue());
			//if home contestant's scores equal to awayplayer's scores, 
			//then the point is the average of winnerPoint and loserPoint
			int average=(winnerPoint+loserPoint)>>1;
			if(originMatch.getHcretired()){//penalty
				originMatch.setHcpoint(average-penalty);
			}else{
				originMatch.setHcpoint(average);
			}
			if(originMatch.getApretired()){//penalty
				originMatch.setAppoint(average-penalty);
			}else{
				originMatch.setAppoint(average);
			}
		}
		//比赛有效才可更新冠军数量
		if(originMatch.getInvalid()==null||!originMatch.getInvalid().booleanValue()){
			//决赛，统计个人单打冠军数量
			if(originMatch.getRound().equals(RoundEnum.FINAL.getValue())){
				int singletitles=0;
				if(originMatch.getOutcome().equals(WinLoseEnum.WIN.getValue())){
					singletitles=homeContestant.getSingletitles().intValue()+1;
					homeContestant.setSingletitles(singletitles);
					userService.updateById(homeContestant);
				}else if(originMatch.getOutcome().equals(WinLoseEnum.LOSE.getValue())){
					singletitles=awayPlayer.getSingletitles().intValue()+1;
					awayPlayer.setSingletitles(singletitles);
					userService.updateById(awayPlayer);
				}else{
					//...
				}
			}else{
				//...
			}
		}else{
			//...
		}
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月9日 下午4:36:09
	 * @return: void
	 * @description: 设置镜像比赛记录的保存项
	 *
	 */
	private void setMirrorMatch(Singlematch originMatch,Singlematch mirrorMatch){
		mirrorMatch.setHomecontestant(originMatch.getAwayplayer());
		mirrorMatch.setAwayplayer(originMatch.getHomecontestant());
		mirrorMatch.setMatchtime(originMatch.getMatchtime());
		mirrorMatch.setMatchplace(originMatch.getMatchplace());
		mirrorMatch.setTournamentid(originMatch.getTournamentid());
		mirrorMatch.setEntry(originMatch.getEntry());
		mirrorMatch.setRound(originMatch.getRound());
		mirrorMatch.setSets(originMatch.getSets());
		if(WinLoseEnum.WIN.getValue().compareTo(originMatch.getOutcome())==0){
			mirrorMatch.setOutcome(WinLoseEnum.LOSE.getValue());
		}else if(WinLoseEnum.LOSE.getValue().compareTo(originMatch.getOutcome())==0){
			mirrorMatch.setOutcome(WinLoseEnum.WIN.getValue());
		}else{
			mirrorMatch.setOutcome(WinLoseEnum.TIE.getValue());
		}
		mirrorMatch.setHcpoint(originMatch.getAppoint());
		mirrorMatch.setAppoint(originMatch.getHcpoint());
		mirrorMatch.setHcretired(originMatch.getApretired());
		mirrorMatch.setApretired(originMatch.getHcretired());
		mirrorMatch.setInvalid(originMatch.getInvalid());
		mirrorMatch.setNote(originMatch.getNote());
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月9日 下午4:36:51
	 * @return: void
	 * @description: 设置镜像比赛比分的保存项
	 *
	 */
	private void setMirrorMatchscore(Singlematchscore originMatchscore,Singlematchscore mirrorMatchscore,Integer mirrorMatchid){
		mirrorMatchscore.setMatchid(mirrorMatchid);							
		mirrorMatchscore.setSetth(originMatchscore.getSetth());
		mirrorMatchscore.setApscore(originMatchscore.getHcscore());
		mirrorMatchscore.setAptiescore(originMatchscore.getHctiescore());
		mirrorMatchscore.setHcscore(originMatchscore.getApscore());
		mirrorMatchscore.setHctiescore(originMatchscore.getAptiescore());
		mirrorMatchscore.setInvalid(originMatchscore.getInvalid());
		mirrorMatchscore.setNote(originMatchscore.getNote());
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月15日 下午9:52:11
	 * @return: void
	 * @description: 当更新或删除比赛记录的时候，如果原比赛是决赛，则需要扣除选手的冠军得数
	 *
	 */
	private void deleteSingleTitles(Singlematch singlematch) throws Exception{
		if(!singlematch.getInvalid().booleanValue()){//有效比赛
			if(singlematch.getRound().equals(RoundEnum.FINAL.getValue())){
				User homeContestant=userService.findById(singlematch.getHomecontestant());
				User awayPlayer=userService.findById(singlematch.getAwayplayer());
				int singletitles=0;
				if(singlematch.getOutcome().equals(WinLoseEnum.WIN.getValue())){
					singletitles=homeContestant.getSingletitles().intValue()-1;
					homeContestant.setSingletitles(singletitles);
					userService.updateById(homeContestant);
				}else if(singlematch.getOutcome().equals(WinLoseEnum.LOSE.getValue())){
					singletitles=awayPlayer.getSingletitles().intValue()-1;
					awayPlayer.setSingletitles(singletitles);
					userService.updateById(awayPlayer);
				}else{
					//...
				}
			}else{
				//...
			}
		}else{
			//...
		}
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月16日 上午10:44:32
	 * @return: boolean
	 * @description: 获取赛事的某个轮次的积分
	 *
	 */
	private boolean getPointrule(Integer tournamentid,Integer round) throws Exception{
		//对修改后的比赛重新计算个人积分
		Pointrule pointrule=new Pointrule();
		pointrule.setTournamentid(tournamentid);
		pointrule.setRound(round);
		pointrule=pointruleService.findByTournamentIdAndRound(pointrule);
		if(pointrule!=null&&!pointrule.getInvalid().booleanValue()){
			winnerPoint=pointrule.getWinner().intValue();
			loserPoint=pointrule.getLoser().intValue();
			penalty=pointrule.getPenalty().intValue();
			return true;
		}else{
			return false;
		}
	}
}
