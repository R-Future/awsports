package com.awsports.controller;

import java.io.InputStream;
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
import org.springframework.web.multipart.MultipartFile;

import com.awsports.pojo.Arena;
import com.awsports.pojo.Doublematch;
import com.awsports.pojo.DoublematchQuery;
import com.awsports.pojo.DoublematchQueryVo;
import com.awsports.pojo.Doublematchscore;
import com.awsports.pojo.Pointrule;
import com.awsports.pojo.Team;
import com.awsports.pojo.TeamQuery;
import com.awsports.pojo.TournamentQuery;
import com.awsports.pojo.User;
import com.awsports.service.ArenaService;
import com.awsports.service.DoublematchService;
import com.awsports.service.DoublematchscoreService;
import com.awsports.service.IndividualpointService;
import com.awsports.service.IndividualrankService;
import com.awsports.service.IndividualrankestService;
import com.awsports.service.PointruleService;
import com.awsports.service.PunishmentService;
import com.awsports.service.TeamService;
import com.awsports.service.TeampointService;
import com.awsports.service.TeamrankService;
import com.awsports.service.TeamrankestService;
import com.awsports.service.TournamentService;
import com.awsports.service.UserService;
import com.awsports.util.CalculatePoint;
import com.awsports.util.CustomException;
import com.awsports.util.EntryEnum;
import com.awsports.util.ExcelUtil;
import com.awsports.util.RoundEnum;
import com.awsports.util.SexEnum;
import com.awsports.util.TypeMap;
import com.awsports.util.UpdateRankUtil;
import com.awsports.util.WinLoseEnum;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

@Controller
@RequestMapping("/doublematch")
public class DoublematchController {
	
	@Autowired
	private DoublematchService doublematchService;
	@Autowired
	private ArenaService arenaService;
	@Autowired
	private TournamentService tournamentService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private PointruleService pointruleService;
	@Autowired
	private DoublematchscoreService doublematchscoreService;
	@Autowired
	private TeampointService teampointService;
	@Autowired
	private IndividualpointService individualpointService;
	@Autowired
	private UserService userService;
	@Autowired
	private TeamrankService teamrankService;
	@Autowired
	private TeamrankestService teamrankestService;
	@Autowired
	private IndividualrankService individualrankService;
	@Autowired
	private IndividualrankestService individualrankestService;
	@Autowired
	private PunishmentService punishmentService;
	
	private Map<Integer,String> entryTypes=TypeMap.entryType();
	private Map<Integer,String> roundTypes=TypeMap.roundType();
	private int winnerPoint;
	private int loserPoint;
	private int penalty;
	private int hcMarginBureau;
	private Integer[][] teamMembers=new Integer[2][2];
	private Boolean[][] memberSex=new Boolean[2][2];
	private Integer[] teamEntrys = {6,7,8};
	private Integer[] individualEntrys = {4,5};
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月12日 下午3:33:55
	 * @return: String
	 * @description: 双打比赛显示列表
	 *
	 */
	@RequestMapping("/list")
	public String list(Model model,DoublematchQuery doublematchQuery) throws Exception{
		List<DoublematchQuery> doublematchQuerys=doublematchService.findAll(doublematchQuery);
		model.addAttribute("doublematchQuerys", doublematchQuerys);
		model.addAttribute("entryTypes", entryTypes);
		model.addAttribute("roundTypes", roundTypes);
		return "doublematch/list";
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月12日 下午3:56:06
	 * @return: String
	 * @description: 新增比赛记录
	 *
	 */
	@RequestMapping("/add")
	public String add(Model model) throws Exception{
		//获取赛事场馆信息
		List<Arena> arenas=arenaService.findAll(null);
		model.addAttribute("arenas", arenas);
		//获取赛事类型信息
		List<TournamentQuery> tournamentQuerys=tournamentService.findAll(null);
		model.addAttribute("tournamentQuerys", tournamentQuerys);
		//获取轮次映射关系
		model.addAttribute("roundTypes", roundTypes);
		return "doublematch/add";
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月12日 下午3:57:10
	 * @return: String
	 * @description: 使用ajax从前端传回数据,从而得知要记录的比赛数量，以及每场比赛的盘数，@RequestParam(defaultValue="1")设置初始值为1,默认一场比赛一盘
	 *
	 */
	@RequestMapping(value="/addRecord",method={RequestMethod.POST})
	public String add(Model model,@RequestParam(defaultValue="1") Integer matches,@RequestParam(defaultValue="1") Integer sets) throws Exception{
		//新建比赛记录
		List<DoublematchQuery> doublematchQuerys=new ArrayList<DoublematchQuery>();
		DoublematchQuery doublematchQuery=null;
		List<Doublematchscore> doublematchscores=null;
		for(int i=0;i<matches;i++){
			doublematchQuery=new DoublematchQuery();
			doublematchQuery.setDoublematch(new Doublematch());//新建比赛记录
			doublematchscores=new ArrayList<Doublematchscore>();//新建比分记录
			for(int j=0;j<sets;j++){
				doublematchscores.add(new Doublematchscore());
			}
			doublematchQuery.setDoublematchscores(doublematchscores);
			doublematchQuerys.add(doublematchQuery);
		}
		model.addAttribute("doublematchQuerys", doublematchQuerys);
		//获取组合信息
		List<TeamQuery> teamQuerys=teamService.findAll(null);
		model.addAttribute("teamQuerys", teamQuerys);
		return "doublematch/record";
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月12日 下午5:10:55
	 * @return: String
	 * @description: 保存新添加的比赛记录
	 *
	 */
	@RequestMapping("saveNew")
	public String saveNew(@Validated DoublematchQueryVo doublematchQueryVo,
									 BindingResult br,
									 Model model,
									 Date matchtime,
									 Integer matchplace,
									 Integer tournamentid,
									 Integer round,
									 Integer sets) throws Exception{
		if(doublematchQueryVo!=null){
			List<DoublematchQuery> doublematchQuerys=doublematchQueryVo.getDoublematchQuerys();
			if(br.hasErrors()){
				model.addAttribute("errors", br);
				return "forward:add";
			}else{
				if(doublematchQuerys==null){
					throw new CustomException("比赛信息为空，无法保存！");
				}else{
					if(getPointrule(tournamentid,round)){
						for(DoublematchQuery doublematchQuery:doublematchQuerys){
							String timeStamp = ""+System.currentTimeMillis();
							Doublematch originMatch=doublematchQuery.getDoublematch();
							List<Doublematchscore> originMatchscores=doublematchQuery.getDoublematchscores();
							originMatch.setMatchtime(matchtime);//比赛时间
							originMatch.setMatchplace(matchplace);//比赛地点
							originMatch.setTournamentid(tournamentid);//赛事类型
							originMatch.setRound(round);//比赛轮次
							originMatch.setSets(sets);//比赛盘数
							originMatch.setMirror(timeStamp);//to find mirror match
							setOriginMatch(originMatch,originMatchscores);
							//设置镜像比赛记录保存项
							Doublematch mirrorMatch=new Doublematch();
							setMirrorMatch(originMatch,mirrorMatch);
							//保存比赛记录
							doublematchService.insertOne(originMatch);
							doublematchService.insertOne(mirrorMatch);
							//保存比赛比分
							Integer originMatchid=originMatch.getId();
							Integer mirrorMatchid=mirrorMatch.getId();
							Doublematchscore mirrorMatchscore=null;
							for(Doublematchscore originMatchscore:originMatchscores){
								//保存原比赛比分
								originMatchscore.setMatchid(originMatchid);
								doublematchscoreService.insertOne(originMatchscore);
								//保存镜像比赛比分
								mirrorMatchscore=new Doublematchscore();
								setMirrorMatchscore(originMatchscore,mirrorMatchscore,mirrorMatchid);
								doublematchscoreService.insertOne(mirrorMatchscore);
							}
							//有效比赛才可更新积分
							if(originMatch.getInvalid()==null||!originMatch.getInvalid().booleanValue()){
								//计算组合积分和个人积分
								getTeamMemberSex(originMatch);
								CalculatePoint calculatePoint=new CalculatePoint(originMatch, hcMarginBureau,tournamentService);
								if(!calculatePoint.team(teampointService, originMatch)||
								   !calculatePoint.individual(individualpointService, originMatch, teamMembers, memberSex)){
									throw new CustomException("组合积分或个人积分保存失败！");
								}
							}else{
								continue;
							}	
						}//end for
						return "redirect:add";
					}else{
						throw new CustomException("未找到匹配的积分信息！");
					}//end if(pointrule==null)
				}
			}
		}else{
			throw new CustomException("非法操作！");
		}
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月14日 上午10:15:05
	 * @return: String
	 * @description: 更新比赛记录
	 *
	 */
	@RequestMapping("/update")
	public String update(Model model,@RequestParam(required=true) Integer id) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{
			DoublematchQuery doublematchQuery=new DoublematchQuery();
			Doublematch doublematch=doublematchService.findById(id);//比赛
			List<Doublematchscore> doublematchscores=doublematchscoreService.findByMatchid(id);//比分
			if(doublematchscores==null){//比分不存在
				doublematchscores=new ArrayList<Doublematchscore>();
				Doublematchscore doublematchscore=null;
				for(int i=1;i<=doublematch.getSets().intValue();i++){
					doublematchscore=new Doublematchscore();
					doublematchscore.setSetth(i);
					doublematchscores.add(doublematchscore);
				}
			}else{
				//...
			}
			doublematchQuery.setDoublematch(doublematch);
			doublematchQuery.setDoublematchscores(doublematchscores);
			model.addAttribute("doublematchQuery", doublematchQuery);
			//获取赛事场馆信息
			List<Arena> arenas=arenaService.findAll(null);
			model.addAttribute("arenas", arenas);
			//获取赛事类型信息
			List<TournamentQuery> tournamentQuerys=tournamentService.findAll(null);
			model.addAttribute("tournamentQuerys", tournamentQuerys);
			//获取轮次映射关系
			model.addAttribute("roundTypes", roundTypes);
			//获取组合信息
			List<TeamQuery> teamQuerys=teamService.findAll(null);
			model.addAttribute("teamQuerys", teamQuerys);
			return "doublematch/update";
		}		
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月14日 上午11:15:20
	 * @return: String
	 * @description: 保存修改后的比赛
	 *
	 */
	@RequestMapping("/saveOld")
	public String saveOld(@Validated DoublematchQuery doublematchQuery,BindingResult br,Model model) throws Exception{
		if(br.hasErrors()){
			model.addAttribute("errors", br);
			return "forward:update";
		}else{
			Doublematch originMatch=doublematchQuery.getDoublematch();
			List<Doublematchscore> originMatchscores=doublematchQuery.getDoublematchscores();
			Doublematch oldOriginMatch=doublematchService.findById(originMatch.getId());
			List<Doublematchscore> oldOriginMatchscores=doublematchscoreService.findByMatchid(originMatch.getId());
			CalculatePoint calculatePoint=null;
			//删除前比赛的组合积分和个人积分记录
			if(oldOriginMatch!=null&&!oldOriginMatch.getInvalid().booleanValue()){
				if(oldOriginMatchscores==null){
					throw new CustomException("原比赛比分记录不存在，积分删除失败！");
				}else{
					//获取主场选手的净胜局
					hcMarginBureau=0;
					for(Doublematchscore doublematchscore:oldOriginMatchscores){
						if(!doublematchscore.getInvalid().booleanValue()){
							hcMarginBureau+=doublematchscore.getHcscore().intValue()-doublematchscore.getApscore().intValue();
						}else{
							continue;
						}
					}
					//删除原比赛所获取的组合积分和双打个人积分
					getTeamMemberSex(oldOriginMatch);	
					calculatePoint=new CalculatePoint(oldOriginMatch, hcMarginBureau,tournamentService);
					if(!calculatePoint.deleteTeam(teampointService, oldOriginMatch)||
					   !calculatePoint.deleteIndividual(individualpointService, oldOriginMatch, teamMembers, memberSex)){
						throw new CustomException("积分删除失败！");
					}else{
						//删除原比赛的双打冠军得数
						deleteDoubleTitles(oldOriginMatch);
					}
				}
			}else{
				//...
			}
			
			//更新修改后的比赛的组合积分表和个人积分表	
			if(getPointrule(originMatch.getTournamentid(),originMatch.getRound())){
				//设置修改后的比赛记录项
				setOriginMatch(originMatch,originMatchscores);
				//更新比赛
				doublematchService.updateById(originMatch);
				//根据原比赛记录获取其镜像比赛记录
				Doublematch mirrorMatch=doublematchService.findMirrorByOrigin(oldOriginMatch);
				Integer mirrorMatchid=null;
				if(mirrorMatch==null){//原比赛的镜像比赛记录不存在，重新创建
					mirrorMatch=new Doublematch();
					setMirrorMatch(originMatch,mirrorMatch);
					//记录创建时间必须与原比赛记录创建时间一致，否则无法根据原比赛记录查询其镜像比赛记录
					mirrorMatch.setCreatedat(originMatch.getCreatedat());
					doublematchService.insertOne(mirrorMatch);
					mirrorMatchid=mirrorMatch.getId();
					Doublematchscore mirrorMatchscore=null;
					for(Doublematchscore originMatchscore:originMatchscores){
						doublematchscoreService.updateById(originMatchscore);
					
						mirrorMatchscore=new Doublematchscore();
						setMirrorMatchscore(originMatchscore,mirrorMatchscore,mirrorMatchid);
						doublematchscoreService.insertOne(mirrorMatchscore);
						
					}
					
				}else{
					setMirrorMatch(originMatch,mirrorMatch);						
					doublematchService.updateById(mirrorMatch);
					mirrorMatchid=mirrorMatch.getId();
					List<Doublematchscore> mirrorMatchscores=doublematchscoreService.findByMatchid(mirrorMatchid);
					for(Doublematchscore originMatchscore:originMatchscores){
						doublematchscoreService.updateById(originMatchscore);
						Doublematchscore mirrorMatchscore=null;
						if(mirrorMatchscores!=null){
							mirrorMatchscore=mirrorMatchscores.get(originMatchscore.getSetth().intValue()-1);
							setMirrorMatchscore(originMatchscore,mirrorMatchscore,mirrorMatchid);
							doublematchscoreService.updateById(mirrorMatchscore);
						}else{
							mirrorMatchscore=new Doublematchscore();
							setMirrorMatchscore(originMatchscore,mirrorMatchscore,mirrorMatchid);
							doublematchscoreService.insertOne(mirrorMatchscore);
						}
					}			
				}//end if(mirrorMatch==null)
				if(!originMatch.getInvalid().booleanValue()){//比赛记录有效
					//更新修改后的比赛的组合积分和个人积分
					getTeamMemberSex(originMatch);
					calculatePoint=new CalculatePoint(originMatch, hcMarginBureau,tournamentService);
					if(!calculatePoint.team(teampointService, originMatch)||
					   !calculatePoint.individual(individualpointService, originMatch, teamMembers, memberSex)){
						throw new CustomException("积分更新失败！");
					}else{
						//...
					}
				}else{
					//...
				}//end if(!originMatch.getInvalid().booleanValue())
				return "redirect:list";
			}else{
				throw new CustomException("未找到匹配的积分规则信息！");
			}//end if(pointrule==null)
		}//end if(br.hasErrors())
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月14日 上午11:16:46
	 * @return: String
	 * @description:
	 *
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		if(id==null){
			throw new CustomException("非法操作！");
		}else{
			Doublematch originMatch=doublematchService.findById(id);
			Doublematch mirrorMatch=doublematchService.findMirrorByOrigin(originMatch);
			List<Doublematchscore> originMatchscores=doublematchscoreService.findByMatchid(id);
			if(originMatch!=null&&originMatchscores!=null){
				if(!originMatch.getInvalid().booleanValue()){
					hcMarginBureau=0;
					for(Doublematchscore originMatchscore:originMatchscores){
						hcMarginBureau+=originMatchscore.getHcscore().intValue()-originMatchscore.getApscore().intValue();
					}
					getTeamMemberSex(originMatch);
					CalculatePoint calculatePoint=new CalculatePoint(originMatch, hcMarginBureau,tournamentService);
					if(!calculatePoint.deleteTeam(teampointService, originMatch)||
					   !calculatePoint.deleteIndividual(individualpointService, originMatch, teamMembers, memberSex)){
						throw new CustomException("积分删除失败！");
					}else{
						//删除双打冠军得数
						deleteDoubleTitles(originMatch);
					}
				}else{
					//...
				}
				//删除原比赛
				doublematchscoreService.deleteByMatchid(id);
				doublematchService.deleteById(id);
				//删除镜像比赛
				if(mirrorMatch!=null){
					doublematchscoreService.deleteByMatchid(mirrorMatch.getId());
					doublematchService.deleteById(mirrorMatch.getId());
				}else{
					//...
				}
				return "redirect:list";
			}else{
				throw new CustomException("未查询到相关比赛记录，无法进行删除操作！");
			}	
		}
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月12日 下午9:19:55
	 * @return: void
	 * @description: 设置比赛记录保存项
	 *
	 */
	private void setOriginMatch(Doublematch originMatch,List<Doublematchscore> originMatchscores) throws Exception{
		//设置参赛类型
		Team hcTeam=teamService.findById(originMatch.getHomecontestant());
		Team apTeam=teamService.findById(originMatch.getAwayplayer());
		if(hcTeam.getEntry().equals(apTeam.getEntry())&&apTeam.getEntry().equals(EntryEnum.MANDOUBLE.getValue())){
			//男双
			originMatch.setEntry(EntryEnum.MANDOUBLE.getValue());
		}else if(hcTeam.getEntry().equals(apTeam.getEntry())&&apTeam.getEntry().equals(EntryEnum.WOMANDOUBLE.getValue())){
			//女双
			originMatch.setEntry(EntryEnum.WOMANDOUBLE.getValue());
		}else{
			//混双
			originMatch.setEntry(EntryEnum.MIXEDDOUBLE.getValue());
		}
		//根据比分计算胜负结果
		int hcSets=0,apSets=0;
		int hcScore=0;
		int apScore=0;
		hcMarginBureau=0;//主场选手的净胜局
		for(Doublematchscore originMatchscore:originMatchscores){
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
		if(hcSets>apSets){
			//主场选手赢
			originMatch.setOutcome(WinLoseEnum.WIN.getValue());
			//主场选手
			if(originMatch.getHcretired().booleanValue()){
				//主场选手退赛
				originMatch.setHcpoint(winnerPoint-penalty);
			}else{
				originMatch.setHcpoint(winnerPoint);
			}
			//客场选手
			if(originMatch.getApretired().booleanValue()){
				//客场选手退赛
				if(originMatch.getIsapchallenger().booleanValue()){
					//如果败者为挑战者
					originMatch.setAppoint(-penalty);
				}else{
					originMatch.setAppoint(loserPoint-penalty);
				}
			}else{
				if(originMatch.getIsapchallenger().booleanValue()){
					//如果败者为挑战者
					originMatch.setAppoint(0);
				}else{
					originMatch.setAppoint(loserPoint);
				}
			}
		}else if(hcSets<apSets){
			//客场选手赢
			originMatch.setOutcome(WinLoseEnum.LOSE.getValue());
			//主场选手
			if(originMatch.getHcretired().booleanValue()){
				//主场选手退赛
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
			if(originMatch.getApretired().booleanValue()){
				//客场选手退赛
				originMatch.setAppoint(winnerPoint-penalty);
			}else{
				originMatch.setAppoint(winnerPoint);
			}
		}else{
			//双方平手
			originMatch.setOutcome(WinLoseEnum.TIE.getValue());
			int average=(winnerPoint+loserPoint)>>1;
			if(originMatch.getHcretired().booleanValue()){
				//主场选手退赛
				originMatch.setHcpoint(average-penalty);
			}else{
				originMatch.setHcpoint(average);
			}
			if(originMatch.getApretired().booleanValue()){
				//客场选手退赛
				originMatch.setAppoint(average-penalty);
			}else{
				originMatch.setAppoint(average);
			}
		}
		//比赛有效才可更新个人双打冠军得数
		if(originMatch.getInvalid()==null||!originMatch.getInvalid().booleanValue()){
			//决赛，统计个人双打冠军数量
			if(originMatch.getRound().equals(RoundEnum.FINAL.getValue())){
				int doubletitles1=0;
				int doubletitles2=0;
				if(originMatch.getOutcome().equals(WinLoseEnum.WIN.getValue())){
					User hcUser1=userService.findById(hcTeam.getUser1id());
					User hcUser2=userService.findById(hcTeam.getUser2id());
					doubletitles1=hcUser1.getDoubletitles().intValue()+1;
					doubletitles2=hcUser2.getDoubletitles().intValue()+1;
					hcUser1.setDoubletitles(doubletitles1);
					userService.updateById(hcUser1);
					hcUser2.setDoubletitles(doubletitles2);
					userService.updateById(hcUser2);
				}else if(originMatch.getOutcome().equals(WinLoseEnum.LOSE.getValue())){
					User apUser1=userService.findById(apTeam.getUser1id());
					User apUser2=userService.findById(apTeam.getUser2id());
					doubletitles1=apUser1.getDoubletitles().intValue()+1;
					doubletitles2=apUser2.getDoubletitles().intValue()+1;
					apUser1.setDoubletitles(doubletitles1);
					userService.updateById(apUser1);
					apUser2.setDoubletitles(doubletitles2);
					userService.updateById(apUser2);
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
	 * @date: 2017年6月12日 下午9:28:00
	 * @return: void
	 * @description: 设置镜像比赛记录保存项
	 *
	 */
	private void setMirrorMatch(Doublematch originMatch,Doublematch mirrorMatch){
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
		mirrorMatch.setMirror(originMatch.getMirror());
		mirrorMatch.setNote(originMatch.getNote());
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月12日 下午9:36:06
	 * @return: void
	 * @description: 设置镜像比赛比分的保存项
	 *
	 */
	private void setMirrorMatchscore(Doublematchscore originMatchscore,Doublematchscore mirrorMatchscore,Integer mirrorMatchid){
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
	 * @date: 2017年6月14日 上午10:32:33
	 * @return: void
	 * @description: 获取组合中各成员的性别
	 *
	 */
	private void getTeamMemberSex(Doublematch doublematch) throws Exception{
		Team hcTeam=teamService.findById(doublematch.getHomecontestant());
		Team apTeam=teamService.findById(doublematch.getAwayplayer());
		teamMembers[0][0]=hcTeam.getUser1id();
		teamMembers[0][1]=hcTeam.getUser2id();
		teamMembers[1][0]=apTeam.getUser1id();
		teamMembers[1][1]=apTeam.getUser2id();
		if(doublematch.getEntry().equals(EntryEnum.MANDOUBLE.getValue())){
			//男双比赛
			memberSex[0][0]=SexEnum.MALE.getValue();
			memberSex[0][1]=SexEnum.MALE.getValue();
			memberSex[1][0]=SexEnum.MALE.getValue();
			memberSex[1][1]=SexEnum.MALE.getValue();
		}else if(doublematch.getEntry().equals(EntryEnum.WOMANDOUBLE.getValue())){
			//女双比赛
			memberSex[0][0]=SexEnum.FEMALE.getValue();
			memberSex[0][1]=SexEnum.FEMALE.getValue();
			memberSex[1][0]=SexEnum.FEMALE.getValue();
			memberSex[1][1]=SexEnum.FEMALE.getValue();
		}else{
			User user=null;
			for(int i=0;i<2;i++){
				for(int j=0;j<2;j++){
					user=userService.findById(teamMembers[i][j]);
					memberSex[i][j]=user.getSex();
				}
			}
		}
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月15日 下午10:25:35
	 * @return: void
	 * @description: 当更新或删除比赛时，若原比赛为决赛，需要修改选手的双打冠军数
	 *
	 */
	private void deleteDoubleTitles(Doublematch doublematch) throws Exception{
		//比赛有效才可删除
		if(!doublematch.getInvalid().booleanValue()){
			Team hcTeam=teamService.findById(doublematch.getHomecontestant());
			Team apTeam=teamService.findById(doublematch.getAwayplayer());
			//决赛，统计个人双打冠军数量
			if(doublematch.getRound().equals(RoundEnum.FINAL.getValue())){
				int doubletitles1=0;
				int doubletitles2=0;
				if(doublematch.getOutcome().equals(WinLoseEnum.WIN.getValue())){
					User hcUser1=userService.findById(hcTeam.getUser1id());
					User hcUser2=userService.findById(hcTeam.getUser2id());
					doubletitles1=hcUser1.getDoubletitles().intValue()-1;
					doubletitles2=hcUser2.getDoubletitles().intValue()-1;
					hcUser1.setDoubletitles(doubletitles1);
					userService.updateById(hcUser1);
					hcUser2.setDoubletitles(doubletitles2);
					userService.updateById(hcUser2);
				}else if(doublematch.getOutcome().equals(WinLoseEnum.LOSE.getValue())){
					User apUser1=userService.findById(apTeam.getUser1id());
					User apUser2=userService.findById(apTeam.getUser2id());
					doubletitles1=apUser1.getDoubletitles().intValue()-1;
					doubletitles2=apUser2.getDoubletitles().intValue()-1;
					apUser1.setDoubletitles(doubletitles1);
					userService.updateById(apUser1);
					apUser2.setDoubletitles(doubletitles2);
					userService.updateById(apUser2);
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
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年7月30日 上午10:57:49
	 * @param doublematchQuery
	 * @param tournamentid
	 * @param round
	 * @throws Exception
	 * @Return: void
	 * @Description: save double matches from excel file
	 *
	 */
	private void saveFromExcel(DoublematchQuery doublematchQuery, Integer tournamentid, Integer round) throws Exception {
		if (doublematchQuery == null) {
			throw new CustomException("比赛信息为空，无法保存！");
		} else {
			if (getPointrule(tournamentid, round)) {
				Doublematch originMatch = doublematchQuery.getDoublematch();
				List<Doublematchscore> originMatchscores = doublematchQuery.getDoublematchscores();
				// originMatch.setMatchtime(matchtime);// 比赛时间
				// originMatch.setMatchplace(matchplace);// 比赛地点
				// originMatch.setTournamentid(tournamentid);// 赛事类型
				// originMatch.setRound(round);// 比赛轮次
				// originMatch.setSets(sets);// 比赛盘数
				setOriginMatch(originMatch, originMatchscores);
				// 设置镜像比赛记录保存项
				Doublematch mirrorMatch = new Doublematch();
				setMirrorMatch(originMatch, mirrorMatch);
				// 保存比赛记录
				doublematchService.insertOne(originMatch);
				doublematchService.insertOne(mirrorMatch);
				// 保存比赛比分
				Integer originMatchid = originMatch.getId();
				Integer mirrorMatchid = mirrorMatch.getId();
				Doublematchscore mirrorMatchscore = null;
				for (Doublematchscore originMatchscore : originMatchscores) {
					// 保存原比赛比分
					originMatchscore.setMatchid(originMatchid);
					doublematchscoreService.insertOne(originMatchscore);
					// 保存镜像比赛比分
					mirrorMatchscore = new Doublematchscore();
					setMirrorMatchscore(originMatchscore, mirrorMatchscore, mirrorMatchid);
					doublematchscoreService.insertOne(mirrorMatchscore);
				}
				// 有效比赛才可更新积分
				if (originMatch.getInvalid() == null || !originMatch.getInvalid().booleanValue()) {
					// 计算组合积分和个人积分
					getTeamMemberSex(originMatch);
					CalculatePoint calculatePoint = new CalculatePoint(originMatch, hcMarginBureau, tournamentService);
					if (!calculatePoint.team(teampointService, originMatch) || !calculatePoint.individual(individualpointService, originMatch, teamMembers, memberSex)) {
						throw new CustomException("组合积分或个人积分保存失败！");
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年8月14日 下午11:22:36
	 * @param team
	 * @throws Exception
	 * @Return: void
	 * @Description: insert team into database
	 *
	 */
	private void insertTeam(Team team) throws Exception{
		User user1 = userService.findById(team.getUser1id());
		User user2 = userService.findById(team.getUser2id());
		team.setName(user1.getName().trim()+"&"+user2.getName().trim());
		if (user1.getSex().booleanValue() == user2.getSex().booleanValue()
				&& user2.getSex().booleanValue() == SexEnum.MALE.getValue().booleanValue()) {
			team.setEntry(EntryEnum.MANDOUBLE.getValue());
		} else if (user1.getSex().booleanValue() == user2.getSex().booleanValue()
				&& user2.getSex().booleanValue() == SexEnum.FEMALE.getValue().booleanValue()) {
			team.setEntry(EntryEnum.WOMANDOUBLE.getValue());
		} else {
			team.setEntry(EntryEnum.MIXEDDOUBLE.getValue());
		}
		teamService.insertOne(team);
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年8月14日 下午11:20:27
	 * @param model
	 * @param file
	 * @return
	 * @throws Exception
	 * @Return: String
	 * @Description: import double match records from excel 
	 *
	 */
	@RequestMapping("/importFromExcel")
	public String importFromExcel(Model model, MultipartFile file) throws Exception{
		if (file != null) {
			InputStream inputStream = file.getInputStream();
			Workbook workbook = Workbook.getWorkbook(inputStream);
			// get sheet
			Sheet sheet = workbook.getSheet(0);
			// get the number of rows
			int rows = sheet.getRows();
			// get the number of columns
			int cols = sheet.getColumns();
			// search the sheet
			// save double matches
			// update team rank
			DoublematchQuery doublematchQuery = null;
			Doublematch doublematch = null;
			List<Doublematchscore> doublematchscores = null;
			Doublematchscore doublematchscore = null;
			String matchtime = "";
			String matchtimeFlag = "";
			String timeStamp;
			Team team1 = null;
			Team team2 = null;
			for (int i = 1; i < rows; i++) {

				doublematchQuery = new DoublematchQuery();
				doublematch = new Doublematch();
				doublematchscores = new ArrayList<Doublematchscore>();
				team1 = new Team();
				team2 = new Team();
				int tournamentid = 0;
				int round = 0;

				System.out.println("开始录入双打比赛...");

				for (int j = 0; j < cols; j++) {
					// get data in the cell per one row
					Cell cell = sheet.getCell(j, i);
					switch (j) {
					case 0:
						// player 1 in team 1
						if(cell.getType() == CellType.NUMBER){
							NumberCell player = (NumberCell) cell;
							team1.setUser1id((int) player.getValue());
						}
						break;
					case 1:
						// player 2 in team 1
						if(cell.getType() == CellType.NUMBER){
							NumberCell player = (NumberCell) cell;
							team1.setUser2id((int) player.getValue());
						}
						break;
					case 2:
						// player 1 in team 2
						if(cell.getType() == CellType.NUMBER){
							NumberCell player = (NumberCell) cell;
							team2.setUser1id((int) player.getValue());
						}
						break;
					case 3:
						// player 2 in team 2
						if(cell.getType() == CellType.NUMBER){
							NumberCell player = (NumberCell) cell;
							team2.setUser2id((int) player.getValue());
						}
						break;
					case 4:
						// match time
						matchtime = cell.getContents().toString().trim();
						if (cell.getType() == CellType.DATE) {
							DateCell dateCell = (DateCell) cell;
							doublematch.setMatchtime(dateCell.getDate());
						}
						break;
					case 5:
						// match place
						if (cell.getType() == CellType.NUMBER) {
							NumberCell placeId = (NumberCell) cell;
							doublematch.setMatchplace((int) placeId.getValue());
						}
						break;
					case 6:
						// tournament
						if (cell.getType() == CellType.NUMBER) {
							NumberCell tournamentId = (NumberCell) cell;
							tournamentid = (int) tournamentId.getValue();
							doublematch.setTournamentid(tournamentid);
						}
						break;
					case 7:
						// round
						if (cell.getType() == CellType.NUMBER) {
							NumberCell round0 = (NumberCell) cell;
							round = (int) round0.getValue();
							doublematch.setRound((int) round0.getValue());
						}
						break;
					case 8:
						// sets
						if (cell.getType() == CellType.NUMBER) {
							NumberCell sets = (NumberCell) cell;
							doublematch.setSets((int) sets.getValue());
						}
						break;
					case 9:
						// HC challenger
						if ("false".equals(cell.getContents().toString().trim().toLowerCase())) {
							doublematch.setIshcchallenger(Boolean.FALSE);
						} else {
							doublematch.setIshcchallenger(Boolean.TRUE);
						}
						break;
					case 10:
						// AP challenger
						if ("false".equals(cell.getContents().toString().trim().toLowerCase())) {
							doublematch.setIsapchallenger(Boolean.FALSE);
						} else {
							doublematch.setIsapchallenger(Boolean.TRUE);
						}
						break;
					case 11:
						// HC retired
						if ("false".equals(cell.getContents().toString().trim().toLowerCase())) {
							doublematch.setHcretired(Boolean.FALSE);
						} else {
							doublematch.setHcretired(Boolean.TRUE);
						}
						break;
					case 12:
						// AP retired
						if ("false".equals(cell.getContents().toString().trim().toLowerCase())) {
							doublematch.setApretired(Boolean.FALSE);
						} else {
							doublematch.setApretired(Boolean.TRUE);
						}
						break;
					case 13:
						// match score
						doublematchscore = new Doublematchscore();
						int[] results = ExcelUtil.getMatchScore(cell.getContents().toString(), 0, 0, 0, 0);
						doublematchscore.setSetth(1);
						doublematchscore.setHcscore(results[0]);// HcScore
						doublematchscore.setHctiescore(results[1]);// HcTieScore
						doublematchscore.setApscore(results[2]);// ApScore
						doublematchscore.setAptiescore(results[3]);// ApTieScore
						doublematchscores.add(doublematchscore);
						break;
					case 14:
						// note
						doublematch.setNote(cell.getContents().toString().trim());
					}
				}
				//get team id
				Team hc = teamService.findByUsers(team1);
				Team ap = teamService.findByUsers(team2);
				if(hc != null){
					doublematch.setHomecontestant(hc.getId());
				}else{
					team1.setStartedat(doublematch.getMatchtime());
					insertTeam(team1);
					doublematch.setHomecontestant(team1.getId());
				}
				if(ap != null){
					doublematch.setAwayplayer(ap.getId());
				}else{
					team2.setStartedat(doublematch.getMatchtime());
					insertTeam(team2);
					doublematch.setAwayplayer(team2.getId());
				}
				//set mirror flag to find mirror match
				timeStamp = ""+System.currentTimeMillis();
				doublematch.setMirror(timeStamp);
				doublematchQuery.setDoublematch(doublematch);
				doublematchQuery.setDoublematchscores(doublematchscores);
				try {
					// 更新排名
					if (!matchtime.equals(matchtimeFlag)) {
						if (i > 1) {
							System.out.println("更新" + matchtimeFlag + "的比赛，下次比赛日期" + matchtime);
							System.out.println("正在更新组合排名...");
							UpdateRankUtil.updateRank(matchtimeFlag,teamEntrys,teamrankService,teamrankestService,teampointService);
							System.out.println("组合排名更新完成");
							System.out.println("正在更新个人排名...");
							UpdateRankUtil.updateRank(matchtimeFlag,individualEntrys,individualrankService,individualrankestService,punishmentService,individualpointService);
							System.out.println("个人排名更新完成");
							//the rank must be updated at the last week of each year. If not, the weeks of NO.1 won't be correct.
							if("2015-11-22".equals(matchtimeFlag)){
								System.out.println("正在更新2015年末组合排名...");
								UpdateRankUtil.updateRank("2015-12-27",teamEntrys,teamrankService,teamrankestService,teampointService);
								System.out.println("组合排名更新完成");
								System.out.println("正在更新2015年末个人排名...");
								UpdateRankUtil.updateRank("2015-12-27",individualEntrys,individualrankService,individualrankestService,punishmentService,individualpointService);
								System.out.println("个人排名更新完成");
							}
							if("2016-11-19".equals(matchtimeFlag)){
								System.out.println("正在更新2016年末组合排名...");
								UpdateRankUtil.updateRank("2016-12-25",teamEntrys,teamrankService,teamrankestService,teampointService);
								System.out.println("组合排名更新完成");
								System.out.println("正在更新2016年末个人排名...");
								UpdateRankUtil.updateRank("2016-12-25",individualEntrys,individualrankService,individualrankestService,punishmentService,individualpointService);
								System.out.println("个人排名更新完成");
							}
						}
						matchtimeFlag = matchtime;
					}
					System.out.println("正在录入第" + i + "场比赛...");
					// 将比赛记录录入数据库
					saveFromExcel(doublematchQuery, tournamentid, round);
					System.out.println("第" + i + "场比赛录入完成");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("更新" + matchtime + "的比赛");
			System.out.println("正在更新组合排名...");
			UpdateRankUtil.updateRank(matchtime,teamEntrys,teamrankService,teamrankestService,teampointService);
			System.out.println("组合排名更新完成");
			System.out.println("正在更新个人排名...");
			UpdateRankUtil.updateRank(matchtime,individualEntrys,individualrankService,individualrankestService,punishmentService,individualpointService);
			System.out.println("个人排名更新完成");
			model.addAttribute("success", "导入成功");
		}
		return "doublematch/import";
	}
}


