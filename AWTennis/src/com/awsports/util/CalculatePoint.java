package com.awsports.util;

import java.util.Calendar;
import java.util.Date;

import com.awsports.pojo.Doublematch;
import com.awsports.pojo.Individualpoint;
import com.awsports.pojo.Singlematch;
import com.awsports.pojo.Teampoint;
import com.awsports.service.IndividualpointService;
import com.awsports.service.TeampointService;

public class CalculatePoint{
	private static int year;
	private static int week;
	private static Calendar date;
	private static Integer[] userids=new Integer[2];
	private static Integer[] teamids=new Integer[2];
	private static int[] points=new int[2];
	private static int[] marginBureaus=new int[2];
	private static int[] wins=new int[2];
	
	public static void setDate(Date matchtime){
		date=Calendar.getInstance();
		date.setTime(matchtime);
		//设置每周的第一天为周一，默认为周日
		date.setFirstDayOfWeek(Calendar.MONDAY);
		year=date.get(Calendar.YEAR);
		week=date.get(Calendar.WEEK_OF_YEAR);
	}
	
	public static void individualInitializer(Singlematch singlematch,int hcMarginBureau){
		userids[0]=singlematch.getHomecontestant();
		userids[1]=singlematch.getAwayplayer();
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
	}
	
	public static void teamInitializer(Doublematch doublematch,int hcMarginBureau){
		teamids[0]=doublematch.getHomecontestant();
		teamids[1]=doublematch.getAwayplayer();
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
	}
	
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月8日 下午4:28:10
	 * @return: void
	 * @description: 更新单打个人积分
	 *
	 */
	public static boolean individual(IndividualpointService individualpointService,Singlematch singlematch,int hcMarginBureau) throws Exception{
		//比赛存在且数据有效
		if(singlematch!=null&&(singlematch.getInvalid()==null||!singlematch.getInvalid().booleanValue())){
			setDate(singlematch.getMatchtime());
			individualInitializer(singlematch,hcMarginBureau);
		    Individualpoint individualpoint=new Individualpoint();
			individualpoint.setYear(year);
			individualpoint.setWeek(week);
			individualpoint.setEntry(singlematch.getEntry());
			for(int i=0;i<userids.length;i++){
				individualpoint.setUserid(userids[i]);
				Individualpoint playerpoint=individualpointService.findByUseridYearWeekEntry(individualpoint);
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
	public static boolean individual(IndividualpointService individualpointService,Doublematch doublematch,Integer[][] teamMembers,Boolean[][] memberSex,int hcMarginBureau) throws Exception{
		//比赛存在且数据有效
		if(doublematch!=null&&(doublematch.getInvalid()==null||!doublematch.getInvalid().booleanValue())){
			setDate(doublematch.getMatchtime());
			teamInitializer(doublematch,hcMarginBureau);
			Individualpoint individualpoint=new Individualpoint();
			individualpoint.setYear(year);
			individualpoint.setWeek(week);			
			for(int i=0;i<teamids.length;i++){
				for(int j=0;j<teamMembers[i].length;j++){
					individualpoint.setUserid(teamMembers[i][j]);
					if(memberSex[i][j].equals(SexEnum.MALE.getValue())){
						//双打男子个人
						individualpoint.setEntry(EntryEnum.DOUBLEMANINDIVIDUAL.getValue());
					}else{
						//双打女子个人
						individualpoint.setEntry(EntryEnum.DOUBLEWOMANINDIVIDUAL.getValue());
					}
					Individualpoint playerpoint=individualpointService.findByUseridYearWeekEntry(individualpoint);
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
						int point=playerpoint.getPoints().intValue()+points[i];
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
	public static boolean deleteIndividual(IndividualpointService individualpointService,Singlematch singlematch,int hcMarginBureau) throws Exception{
		//比赛记录存在且有效才可删除个人积分
		if(singlematch!=null&&!singlematch.getInvalid()){
			setDate(singlematch.getMatchtime());
			individualInitializer(singlematch,hcMarginBureau);
			Individualpoint individualpoint=new Individualpoint();
			individualpoint.setYear(year);
			individualpoint.setWeek(week);
			individualpoint.setEntry(singlematch.getEntry());
			for(int i=0;i<userids.length;i++){
				individualpoint.setUserid(userids[i]);
				Individualpoint playerpoint=individualpointService.findByUseridYearWeekEntry(individualpoint);
				if(playerpoint!=null){//there is no record in the database
					int match=playerpoint.getMatchs().intValue()-1;
					int marginBureau=playerpoint.getMarginbureau().intValue()-marginBureaus[i];
					//这里需要对晋级淘汰赛进行特殊处理
					int point=playerpoint.getPoints().intValue()-points[i];
					int win=playerpoint.getWins().intValue()-wins[i];
					playerpoint.setMatchs(match);
					playerpoint.setMarginbureau(marginBureau);
					playerpoint.setPoints(point);
					playerpoint.setWins(win);
					individualpointService.updateById(playerpoint);
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
	public static boolean deleteIndividual(IndividualpointService individualpointService,Doublematch doublematch,Integer[][] teamMembers,Boolean[][] memberSex,int hcMarginBureau) throws Exception{
		//比赛记录存在且有效才可删除个人积分
		if(doublematch!=null&&!doublematch.getInvalid()){
			setDate(doublematch.getMatchtime());
			teamInitializer(doublematch,hcMarginBureau);
			Individualpoint individualpoint=new Individualpoint();
			individualpoint.setYear(year);
			individualpoint.setWeek(week);
			for(int i=0;i<teamids.length;i++){
				for(int j=0;j<teamMembers[i].length;j++){
					individualpoint.setUserid(teamMembers[i][j]);
					if(memberSex[i][j].equals(SexEnum.MALE.getValue())){
						//双打男子个人
						individualpoint.setEntry(EntryEnum.DOUBLEMANINDIVIDUAL.getValue());
					}else{
						//双打女子个人
						individualpoint.setEntry(EntryEnum.DOUBLEWOMANINDIVIDUAL.getValue());
					}
					Individualpoint playerpoint=individualpointService.findByUseridYearWeekEntry(individualpoint);
					if(playerpoint!=null){//there is no record in the database
						int match=playerpoint.getMatchs().intValue()-1;
						int marginBureau=playerpoint.getMarginbureau().intValue()-marginBureaus[i];
						//这里需要对晋级淘汰赛进行特殊处理
						int point=playerpoint.getPoints().intValue()-points[i];
						int win=playerpoint.getWins().intValue()-wins[i];
						playerpoint.setMatchs(match);
						playerpoint.setMarginbureau(marginBureau);
						playerpoint.setPoints(point);
						playerpoint.setWins(win);
						individualpointService.updateById(playerpoint);
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
	public static boolean team(TeampointService teampointService,Doublematch doublematch,int hcMarginBureau) throws Exception{
		//比赛存在且数据有效
		if(doublematch!=null&&(doublematch.getInvalid()==null||!doublematch.getInvalid().booleanValue())){
			setDate(doublematch.getMatchtime());
			teamInitializer(doublematch,hcMarginBureau);
		    Teampoint teampoint=new Teampoint();
		    teampoint.setYear(year);
		    teampoint.setWeek(week);
		    teampoint.setEntry(doublematch.getEntry());
			for(int i=0;i<teamids.length;i++){
				teampoint.setTeamid(teamids[i]);
				Teampoint old=teampointService.findByTeamidYearWeekEntry(teampoint);
				if(old==null){//there is no record in the database
					teampoint.setMatchs(1);
					teampoint.setWins(wins[i]);
					teampoint.setMarginbureau(marginBureaus[i]);
					teampoint.setPoints(points[i]);
					teampointService.insertOne(teampoint);
				}else{
					int match=old.getMatchs().intValue()+1;
					int marginBureau=old.getMarginbureau().intValue()+marginBureaus[i];
					//这里需要对晋级淘汰赛进行特殊处理
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
	public static boolean deleteTeam(TeampointService teampointService,Doublematch doublematch,int hcMarginBureau) throws Exception{
		//比赛记录存在且有效才可删除个人积分
		if(doublematch!=null&&!doublematch.getInvalid()){
			setDate(doublematch.getMatchtime());
			teamInitializer(doublematch,hcMarginBureau);
			Teampoint teampoint=new Teampoint();
			teampoint.setYear(year);
			teampoint.setWeek(week);
			teampoint.setEntry(doublematch.getEntry());
			for(int i=0;i<teamids.length;i++){
				teampoint.setTeamid(teamids[i]);
				Teampoint old=teampointService.findByTeamidYearWeekEntry(teampoint);
				if(old!=null){//there is no record in the database
					int match=old.getMatchs().intValue()-1;
					int marginBureau=old.getMarginbureau().intValue()-marginBureaus[i];
					//这里需要对晋级淘汰赛进行特殊处理
					int point=old.getPoints().intValue()-points[i];
					int win=old.getWins().intValue()-wins[i];
					old.setMatchs(match);
					old.setMarginbureau(marginBureau);
					old.setPoints(point);
					old.setWins(win);
					teampointService.updateById(old);
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
