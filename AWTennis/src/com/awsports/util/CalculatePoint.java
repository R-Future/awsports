package com.awsports.util;

import java.util.List;

import com.awsports.pojo.Doublematch;
import com.awsports.pojo.Individualpoint;
import com.awsports.pojo.Singlematch;
import com.awsports.pojo.Teampoint;
import com.awsports.service.IndividualpointService;
import com.awsports.service.TeampointService;
import com.awsports.service.TournamentService;

public class CalculatePoint{
	
	private int year;
	private int week;
	private Integer[] playerids=new Integer[2];
	private int[] points=new int[2];
	private int[] marginBureaus=new int[2];
	private int[] wins=new int[2];
	private Integer tournamentMode;
	
	public CalculatePoint(Singlematch singlematch,int hcMarginBureau,TournamentService tournamentService) throws Exception{
		CustomDate customDate=new CustomDate(singlematch.getMatchtime());
		year=customDate.getYear();
		week=customDate.getWeek();
		playerids[0]=singlematch.getHomecontestant();
		playerids[1]=singlematch.getAwayplayer();
	    points[0]=singlematch.getHcpoint();
	    points[1]=singlematch.getAppoint();
	    marginBureaus[0]=hcMarginBureau;
	    marginBureaus[1]=-hcMarginBureau;
		if(WinLoseEnum.WIN.getValue().compareTo(singlematch.getOutcome())==0){
			wins[0]=1;
			wins[1]=0;
		}else if(WinLoseEnum.LOSE.getValue().compareTo(singlematch.getOutcome())==0){
			wins[0]=0;
			wins[1]=1;
		}else{
			wins[0]=0;
			wins[1]=0;
		}
		//获取赛事模式
		tournamentMode=tournamentService.findById(singlematch.getTournamentid()).getMode();
		//未查询到赛事模式
		if(tournamentMode==null||tournamentMode<=0){
			throw new CustomException("未查询到赛事模式信息，无法计算积分，请确认赛事模式输入正确");
		}
	}
	
	public CalculatePoint(Doublematch doublematch,int hcMarginBureau,TournamentService tournamentService) throws Exception{
		CustomDate customDate=new CustomDate(doublematch.getMatchtime());
		year=customDate.getYear();
		week=customDate.getWeek();
		playerids[0]=doublematch.getHomecontestant();
		playerids[1]=doublematch.getAwayplayer();
		points[0]=doublematch.getHcpoint();
		points[1]=doublematch.getAppoint();
		marginBureaus[0]=hcMarginBureau;
		marginBureaus[1]=-hcMarginBureau;
		if(WinLoseEnum.WIN.getValue().compareTo(doublematch.getOutcome())==0){
			wins[0]=1;
			wins[1]=0;
		}else if(WinLoseEnum.LOSE.getValue().compareTo(doublematch.getOutcome())==0){
			wins[0]=0;
			wins[1]=1;
		}else{
			wins[0]=0;
			wins[1]=0;
		}
		//获取赛事模式
		tournamentMode=tournamentService.findById(doublematch.getTournamentid()).getMode();
		//未查询到赛事模式
		if(tournamentMode==null||tournamentMode<=0){
			throw new CustomException("未查询到赛事模式信息，无法计算积分，请确认赛事模式输入正确");
		}
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月8日 下午4:28:10
	 * @return: void
	 * @description: 更新单打个人积分
	 *
	 */
	public boolean individual(IndividualpointService individualpointService,Singlematch singlematch) throws Exception{
		//比赛存在且数据有效
		if(singlematch!=null&&(singlematch.getInvalid()==null||!singlematch.getInvalid().booleanValue())){
		    Individualpoint individualpoint=new Individualpoint();
			individualpoint.setYear(year);
			individualpoint.setWeek(week);
			individualpoint.setEntry(singlematch.getEntry());
			individualpoint.setTournamentid(singlematch.getTournamentid());
			for(int i=0;i<playerids.length;i++){
				individualpoint.setUserid(playerids[i]);
				
				//小组循环+淘汰晋级模式
				//先将已有积分清零
				if(TournamentModeEnum.GROUP_AND_KNOCKOUT.getValue().equals(tournamentMode)){
					//将小组循环赛的其它entry类型的比赛积分置为0
					List<Individualpoint> otherPoints = individualpointService.findByUseridYearWeekTournamentid(individualpoint);
					if(otherPoints != null && !otherPoints.isEmpty()){
						for(Individualpoint otherPoint : otherPoints){
							if(!otherPoint.getPoints().equals(0)){
								otherPoint.setPoints(0);
								individualpointService.updateById(otherPoint);
							}
						}
					}
				}
				
				//更新积分
				Individualpoint playerpoint=individualpointService.findByUseridYearWeekTournamentidEntry(individualpoint);
				if(playerpoint==null){//there is no record in the database
					individualpoint.setMatchs(1);
					individualpoint.setWins(wins[i]);
					individualpoint.setMarginbureau(marginBureaus[i]);
					individualpoint.setPoints(points[i]);
					individualpointService.insertOne(individualpoint);
				}else{
					int match=playerpoint.getMatchs().intValue()+1;
					int marginBureau=playerpoint.getMarginbureau().intValue()+marginBureaus[i];
					int point=playerpoint.getPoints().intValue()+points[i];
					int win=playerpoint.getWins().intValue()+wins[i];
					playerpoint.setMatchs(match);
					playerpoint.setMarginbureau(marginBureau);
					playerpoint.setPoints(point);
					playerpoint.setWins(win);
					individualpointService.updateById(playerpoint);
				}
			}
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月13日 下午9:48:20
	 * @return: boolean
	 * @description: 更新双打个人积分
	 *
	 */
	public boolean individual(IndividualpointService individualpointService,Doublematch doublematch,Integer[][] teamMembers,Boolean[][] memberSex) throws Exception{
		//比赛存在且数据有效
		if(doublematch!=null&&(doublematch.getInvalid()==null||!doublematch.getInvalid().booleanValue())){
			Individualpoint individualpoint=new Individualpoint();
			individualpoint.setYear(year);
			individualpoint.setWeek(week);
			individualpoint.setTournamentid(doublematch.getTournamentid());
			for(int i=0;i<teamMembers.length;i++){
				for(int j=0;j<teamMembers[i].length;j++){
					individualpoint.setUserid(teamMembers[i][j]);
					if(memberSex[i][j].equals(SexEnum.MALE.getValue())){
						//双打男子个人
						individualpoint.setEntry(EntryEnum.DOUBLEMANINDIVIDUAL.getValue());
					}else{
						//双打女子个人
						individualpoint.setEntry(EntryEnum.DOUBLEWOMANINDIVIDUAL.getValue());
					}
					Individualpoint playerpoint=individualpointService.findByUseridYearWeekTournamentidEntry(individualpoint);
					if(playerpoint==null){//there is no record in the database
						individualpoint.setMatchs(1);
						individualpoint.setWins(wins[i]);
						individualpoint.setMarginbureau(marginBureaus[i]);
						individualpoint.setPoints(points[i]);
						individualpointService.insertOne(individualpoint);
					}else{
						int match=playerpoint.getMatchs().intValue()+1;
						int marginBureau=playerpoint.getMarginbureau().intValue()+marginBureaus[i];
						//这里需要对晋级淘汰赛进行特殊处理
						int point=0;
						if(TournamentModeEnum.GROUP_AND_KNOCKOUT.getValue().equals(tournamentMode)){
							//年终比赛,无论输赢，积分不累加，更新数据
							point=points[i];
						}else{
							point=playerpoint.getPoints().intValue()+points[i];
						}
						int win=playerpoint.getWins().intValue()+wins[i];
						playerpoint.setMatchs(match);
						playerpoint.setMarginbureau(marginBureau);
						playerpoint.setPoints(point);
						playerpoint.setWins(win);
						individualpointService.updateById(playerpoint);
					}
				}
			}
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月9日 上午10:34:43
	 * @return: boolean
	 * @description: 删除单打个人积分
	 *
	 */
	public boolean deleteIndividual(IndividualpointService individualpointService,Singlematch singlematch) throws Exception{
		//比赛记录存在且有效才可删除个人积分
		if(singlematch!=null&&!singlematch.getInvalid()){
			Individualpoint individualpoint=new Individualpoint();
			individualpoint.setYear(year);
			individualpoint.setWeek(week);
			individualpoint.setEntry(singlematch.getEntry());
			individualpoint.setTournamentid(singlematch.getTournamentid());
			for(int i=0;i<playerids.length;i++){
				individualpoint.setUserid(playerids[i]);
				Individualpoint old=individualpointService.findByUseridYearWeekTournamentidEntry(individualpoint);
				if(old!=null){//there is no record in the database
					int match=old.getMatchs().intValue()-1;
					int marginBureau=old.getMarginbureau().intValue()-marginBureaus[i];
					//这里需要对晋级淘汰赛进行特殊处理
					int point=0;
					//小组循环模式和淘汰晋级模式目前还没有更好的实现方式
					if(old.getPoints().intValue() > 0){
						point=old.getPoints().intValue()-points[i];
					}
					int win=old.getWins().intValue()-wins[i];
					old.setMatchs(match);
					old.setMarginbureau(marginBureau);
					old.setPoints(point);
					old.setWins(win);
					if(match<=0){
						//本周未参加比赛,直接删除该条记录
						individualpointService.deleteById(old.getId());
					}else{
						individualpointService.updateById(old);
					}	
				}else{//数据库中无数据，则不用删除
					return true;
				}
			}
			return true;
			
		}else{
			return false;
		}
		
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月13日 下午9:45:10
	 * @return: boolean
	 * @description: 删除双打个人积分
	 *
	 */
	public boolean deleteIndividual(IndividualpointService individualpointService,Doublematch doublematch,Integer[][] teamMembers,Boolean[][] memberSex) throws Exception{
		//比赛记录存在且有效才可删除个人积分
		if(doublematch!=null&&!doublematch.getInvalid()){
			Individualpoint individualpoint=new Individualpoint();
			individualpoint.setYear(year);
			individualpoint.setWeek(week);
			individualpoint.setTournamentid(doublematch.getTournamentid());
			for(int i=0;i<teamMembers.length;i++){
				for(int j=0;j<teamMembers[i].length;j++){
					individualpoint.setUserid(teamMembers[i][j]);
					if(memberSex[i][j].equals(SexEnum.MALE.getValue())){
						//双打男子个人
						individualpoint.setEntry(EntryEnum.DOUBLEMANINDIVIDUAL.getValue());
					}else{
						//双打女子个人
						individualpoint.setEntry(EntryEnum.DOUBLEWOMANINDIVIDUAL.getValue());
					}
					Individualpoint old=individualpointService.findByUseridYearWeekTournamentidEntry(individualpoint);
					if(old!=null){//there is no record in the database
						int match=old.getMatchs().intValue()-1;
						int marginBureau=old.getMarginbureau().intValue()-marginBureaus[i];
						//这里需要对晋级淘汰赛进行特殊处理
						int point=0;
						if(old.getPoints().intValue() > 0){
							point=old.getPoints().intValue()-points[i];
						}
						int win=old.getWins().intValue()-wins[i];
						old.setMatchs(match);
						old.setMarginbureau(marginBureau);
						old.setPoints(point);
						old.setWins(win);
						if(match<=0){
							//本周未参加比赛,直接删除该条记录
							individualpointService.deleteById(old.getId());
						}else{
							individualpointService.updateById(old);
						}	
					}else{//数据库中无数据，则不用删除
						return true;
					}
				}
			}
			return true;
			
		}else{
			return false;
		}
		
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月8日 下午4:32:38
	 * @return: void
	 * @description: 更新组合积分
	 *
	 */
	public boolean team(TeampointService teampointService, Doublematch doublematch) throws Exception{
		//比赛存在且数据有效
		if(doublematch!=null&&(doublematch.getInvalid()==null||!doublematch.getInvalid().booleanValue())){
		    Teampoint teampoint=new Teampoint();
		    teampoint.setYear(year);
		    teampoint.setWeek(week);
		    teampoint.setEntry(doublematch.getEntry());
		    teampoint.setTournamentid(doublematch.getTournamentid());
			for(int i=0;i<playerids.length;i++){
				teampoint.setTeamid(playerids[i]);
				
				//小组循环+淘汰晋级模式
				//先将所有比赛比分清零
				if(TournamentModeEnum.GROUP_AND_KNOCKOUT.getValue().equals(tournamentMode)){
					//将小组循环赛的其它entry类型的比赛积分置为0
					List<Teampoint> otherPoints = teampointService.findByTeamidYearWeekTournamentid(teampoint);
					if(otherPoints != null && !otherPoints.isEmpty()){
						for(Teampoint otherPoint : otherPoints){
							if(!otherPoint.getPoints().equals(0)){
								otherPoint.setPoints(0);
								teampointService.updateById(otherPoint);
							}
						}
					}
				}
				
				//更新积分
				Teampoint old=teampointService.findByTeamidYearWeekTournamentidEntry(teampoint);
				if(old==null){//there is no record in the database
					teampoint.setMatchs(1);
					teampoint.setWins(wins[i]);
					teampoint.setMarginbureau(marginBureaus[i]);
					teampoint.setPoints(points[i]);
					teampointService.insertOne(teampoint);
				}else{
					int match=old.getMatchs().intValue()+1;
					int marginBureau=old.getMarginbureau().intValue()+marginBureaus[i];
					int point=old.getPoints().intValue()+points[i];
					int win=old.getWins().intValue()+wins[i];
					old.setMatchs(match);
					old.setMarginbureau(marginBureau);
					old.setPoints(point);
					old.setWins(win);
					teampointService.updateById(old);
				}
			}
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月13日 下午12:22:40
	 * @return: boolean
	 * @description: 删除组合积分
	 *
	 */
	public boolean deleteTeam(TeampointService teampointService,Doublematch doublematch) throws Exception{
		//比赛记录存在且有效才可删除个人积分
		if(doublematch!=null&&!doublematch.getInvalid()){
			Teampoint teampoint=new Teampoint();
			teampoint.setYear(year);
			teampoint.setWeek(week);
			teampoint.setEntry(doublematch.getEntry());
			teampoint.setTournamentid(doublematch.getTournamentid());
			for(int i=0;i<playerids.length;i++){
				teampoint.setTeamid(playerids[i]);
				Teampoint old=teampointService.findByTeamidYearWeekTournamentidEntry(teampoint);
				if(old!=null){//there is no record in the database
					int match=old.getMatchs().intValue()-1;
					int marginBureau=old.getMarginbureau().intValue()-marginBureaus[i];
					//这里需要对晋级淘汰赛进行特殊处理
					int point=0;
					if(old.getPoints().intValue() > 0){
						point=old.getPoints().intValue()-points[i];
					}

					int win=old.getWins().intValue()-wins[i];
					old.setMatchs(match);
					old.setMarginbureau(marginBureau);
					old.setPoints(point);
					old.setWins(win);
					if(match<=0){
						//本周未参加比赛,直接删除该条记录
						teampointService.deleteById(old.getId());
					}else{
						teampointService.updateById(old);
					}	
					
				}else{//数据库中无数据，则不用删除
					return true;
				}
			}
			return true;
			
		}else{
			return false;
		}
	}
}
