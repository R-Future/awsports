package com.awsports.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.awsports.pojo.DoublematchQuery;
import com.awsports.pojo.Doublematchscore;
import com.awsports.pojo.DoublesMatchQuery;
import com.awsports.pojo.EventPlayer;
import com.awsports.pojo.EventQuery;
import com.awsports.pojo.EventWorker;
import com.awsports.pojo.Individualrank;
import com.awsports.pojo.Individualrankest;
import com.awsports.pojo.SinglematchQuery;
import com.awsports.pojo.Singlematchscore;
import com.awsports.pojo.SinglesMatchQuery;
import com.awsports.pojo.StatisticQuery;
import com.awsports.pojo.Team;
import com.awsports.pojo.Teamrank;
import com.awsports.pojo.Teamrankest;
import com.awsports.pojo.User;
import com.awsports.service.TeamrankService;
import com.awsports.service.TeamrankestService;

public class ResponseInfo {
	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年11月17日 下午10:34:20
	 * @param user
	 * @Return: void
	 * @Description: 筛选用户基本信息
	 *
	 */
	public static HashMap<String, Object> getProfileInfo(User user){
		HashMap<String, Object> profileInfo = new HashMap<String, Object>();
		profileInfo.put("id", user.getId());
		profileInfo.put("name", user.getName());
		profileInfo.put("nickname", user.getNickname());
		profileInfo.put("sex", TypeMap.sexType().get(user.getSex()));
		profileInfo.put("realname", user.getRealname());
		profileInfo.put("phone", user.getPhone());
		profileInfo.put("email", user.getEmail());
		profileInfo.put("cardNum", user.getCardnum());
		profileInfo.put("idcard", user.getIdcard());
		profileInfo.put("address", user.getAddress());
		profileInfo.put("height", user.getHeight());
		profileInfo.put("weight", user.getWeight());
		profileInfo.put("forehand", TypeMap.forehandType().get(user.getForehand()));
		profileInfo.put("backhand", TypeMap.backhandType().get(user.getBackhand()));
		profileInfo.put("playedYears", user.getPlayedyears());
		profileInfo.put("singleTitles", user.getSingletitles());
		profileInfo.put("doubleTitles", user.getDoubletitles());
		profileInfo.put("level", user.getLevel());
		profileInfo.put("grade", user.getGrade());
		return profileInfo;
	}

	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年11月17日 下午10:51:25
	 * @param individualranks
	 * @param individualrankests
	 * @Return: void
	 * @Description: 筛选出用户个人排名信息
	 *
	 */
	public static HashMap<String, Object> getIndividualrankInfo(List<Individualrank> individualranks, List<Individualrankest> individualrankests){
		HashMap<String, Object> individualrankInfo = new HashMap<String, Object>();
		if(individualranks!=null){
			HashMap<String, Object> tmp = null;
			for(Individualrank individualrank:individualranks){
				tmp = new HashMap<String, Object>();
				tmp.put("currentRank", individualrank.getCurrentrank());
				for(Individualrankest individualrankest:individualrankests){
					if(individualrankest.getEntry().equals(individualrank.getEntry())){
						tmp.put("highestRank", individualrankest.getHighestranking());
						tmp.put("highestRankStartedAt", simpleDateFormat.format(individualrankest.getHrstartedat()));
					}
				}
				individualrankInfo.put(TypeMap.entryType().get(individualrank.getEntry()), tmp);
			}
		}
		return individualrankInfo;
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年11月17日 下午11:35:09
	 * @param team
	 * @param teamranks
	 * @param teamrankests
	 * @Return: void
	 * @Description: 筛选出用户的双打排名信息
	 *
	 */
	public static HashMap<String, Object> getTeamrankInfo(List<Team> teams, TeamrankService teamrankService, TeamrankestService teamrankestService){
		HashMap<String, Object> teamrankInfo = new HashMap<String, Object>();
		if(teams != null){
			//获取组合的当前排名
			for(Team team : teams){
				Teamrank trkCondition = new Teamrank();
				trkCondition.setTeamid(team.getId());
				trkCondition.setYear((new CustomDate()).getYear());
				//组合当前排名
				List<Teamrank> teamranks;
				//组合最高排名记录
				List<Teamrankest> teamrankests;
				try {
					teamranks = teamrankService.findTeamRank(trkCondition);
					teamrankests = teamrankestService.findByTeam(team);
					HashMap<String, Object> tmpTeam = new HashMap<String, Object>();
					if(teamranks != null){
						HashMap<String, Object> tmpRank = null;
						for(Teamrank teamrank:teamranks){
							tmpRank = new HashMap<String, Object>();
							tmpRank.put("currentRank", teamrank.getCurrentrank());
							for(Teamrankest teamrankest:teamrankests){
								if(teamrankest.getEntry().equals(teamrank.getEntry())){
									tmpRank.put("highestRank", teamrankest.getHighestranking());
									tmpRank.put("highestRankStartedAt", simpleDateFormat.format(teamrankest.getHrstartedat()));
								}
							}
							tmpTeam.put(TypeMap.entryType().get(teamrank.getEntry()), tmpRank);
						}
					}
					teamrankInfo.put(team.getName(), tmpTeam);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return teamrankInfo;
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年11月17日 下午11:37:15
	 * @param singlematchQuerys
	 * @Return: void
	 * @Description: 筛选出用户的单打比赛信息
	 *
	 */
	public static List<HashMap<String, Object>> getSinglematchInfo(List<SinglematchQuery> singlematchQuerys){
		List<HashMap<String, Object>> singlematchInfo = new ArrayList<HashMap<String, Object>>();
		if(singlematchQuerys != null){
			HashMap<String, Object> tmp = null;
			for(SinglematchQuery singlematchQuery:singlematchQuerys){
				tmp = new HashMap<String, Object>();
				tmp.put("tournament", singlematchQuery.getTournament().getName());
				tmp.put("place", singlematchQuery.getArena().getName());
				tmp.put("matchTime", simpleDateFormat.format(singlematchQuery.getSinglematch().getMatchtime()));
				tmp.put("opponent", singlematchQuery.getUser2().getName());
				tmp.put("entry", TypeMap.entryType().get(singlematchQuery.getSinglematch().getEntry()));
				tmp.put("round", TypeMap.roundType().get(singlematchQuery.getSinglematch().getRound()));
				tmp.put("sets", singlematchQuery.getSinglematch().getSets());
				StringBuffer sb = new StringBuffer();
				for(Singlematchscore singlematchscore:singlematchQuery.getSinglematchscores()){
					if(singlematchscore.getAptiescore().intValue() == 0 && singlematchscore.getAptiescore().intValue() == 0){
						sb.append(singlematchscore.getHcscore()+":"+singlematchscore.getApscore()+" ");
					}else{
						sb.append(singlematchscore.getHcscore()+"("+singlematchscore.getHctiescore()+"):"
								+singlematchscore.getApscore()+"("+singlematchscore.getAptiescore()+") ");
					}
				}
				tmp.put("matchScore", sb.toString().trim());
				tmp.put("winLose", singlematchQuery.getSinglematch().getOutcome().toUpperCase());
				singlematchInfo.add(tmp);
			}
		}
		return singlematchInfo;
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年11月17日 下午11:38:18
	 * @param doublematchQuerys
	 * @Return: void
	 * @Description: 筛选出用户的双打比赛信息
	 *
	 */
	public static List<HashMap<String, Object>> getDoublematchInfo(List<DoublematchQuery> doublematchQuerys, Integer userId){
		List<HashMap<String, Object>> doublematchInfo = new ArrayList<HashMap<String, Object>>();
		if(doublematchQuerys != null){
			HashMap<String, Object> tmp = null;
			for(DoublematchQuery doublematchQuery:doublematchQuerys){
				tmp = new HashMap<String, Object>();
				tmp.put("tournament", doublematchQuery.getTournament().getName());
				tmp.put("place", doublematchQuery.getArena().getName());
				tmp.put("matchTime", simpleDateFormat.format(doublematchQuery.getDoublematch().getMatchtime()));
				tmp.put("entry", TypeMap.entryType().get(doublematchQuery.getDoublematch().getEntry()));
				tmp.put("round", TypeMap.roundType().get(doublematchQuery.getDoublematch().getRound()));
				tmp.put("sets", doublematchQuery.getDoublematch().getSets());
				String partner;
				String opponent;
				String matchScore;
				String winLose;
				if(userId.equals(doublematchQuery.getHcTeamQuery().getUser1().getId())){
					//find by user1 in hc team 
					partner = doublematchQuery.getHcTeamQuery().getUser2().getName();
					opponent = doublematchQuery.getApTeamQuery().getTeam().getName();
					StringBuffer sb = new StringBuffer();
					for(Doublematchscore doublematchscore:doublematchQuery.getDoublematchscores()){
						if(doublematchscore.getHctiescore().intValue() == 0 && doublematchscore.getAptiescore().intValue() == 0){
							sb.append(doublematchscore.getHcscore()+":"+doublematchscore.getApscore()+" ");
						}else{
							sb.append(doublematchscore.getHcscore()+"("+doublematchscore.getHctiescore()+"):"
									+doublematchscore.getApscore()+"("+doublematchscore.getAptiescore()+") ");
						}
					}
					matchScore = sb.toString().trim();
					winLose = doublematchQuery.getDoublematch().getOutcome().toUpperCase();
				}else{
					//find by user2 in ap team
					partner = doublematchQuery.getApTeamQuery().getUser1().getName();
					opponent = doublematchQuery.getHcTeamQuery().getTeam().getName();
					StringBuffer sb = new StringBuffer();
					for(Doublematchscore doublematchscore:doublematchQuery.getDoublematchscores()){
						if(doublematchscore.getAptiescore().intValue() == 0 && doublematchscore.getHctiescore().intValue() == 0){
							sb.append(doublematchscore.getApscore()+":"+doublematchscore.getHcscore()+" ");
						}else{
							sb.append(doublematchscore.getApscore()+"("+doublematchscore.getAptiescore()+"):"
									+doublematchscore.getHcscore()+"("+doublematchscore.getHctiescore()+") ");
						}
					}
					matchScore = sb.toString().trim();
					if(WinLoseEnum.WIN.getValue().equals(doublematchQuery.getDoublematch().getOutcome())){
						winLose = WinLoseEnum.LOSE.getValue().toUpperCase();
					}else if(WinLoseEnum.LOSE.getValue().equals(doublematchQuery.getDoublematch().getOutcome())){
						winLose = WinLoseEnum.WIN.getValue().toUpperCase();
					}else{
						winLose = WinLoseEnum.TIE.getValue().toUpperCase();
					}
				}
				tmp.put("partner", partner);
				tmp.put("opponent", opponent);
				tmp.put("matchScore", matchScore);
				tmp.put("winLose", winLose);
				
				doublematchInfo.add(tmp);
			}
		}
		return doublematchInfo;
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月17日 下午11:05:18
	 * @param eventQuery
	 * @Return: HashMap<String,Object>
	 * @Description: event information for response
	 *
	 */
	public static HashMap<String, Object> getEventInfo(EventQuery eventQuery) {
		HashMap<String, Object> event = null;
		if(null!=eventQuery){
			event = new HashMap<String, Object>();
			event.put("id", eventQuery.getEvent().getId());
			event.put("publisher", eventQuery.getUserPublisher());
			event.put("contact", eventQuery.getUserContact());
			event.put("cover", eventQuery.getEvent().getCover());
			event.put("name", eventQuery.getEvent().getName());
			event.put("place", eventQuery.getEvent().getPlace());
			event.put("type", eventQuery.getEvent().getType());
			event.put("sponsor", eventQuery.getEvent().getSponsor());
			event.put("detail", eventQuery.getEvent().getDetail());
			event.put("numberOfPlayer", eventQuery.getEvent().getNumberofplayer());
			event.put("cost", eventQuery.getEvent().getCost());
			event.put("startTime", eventQuery.getEvent().getStarttime());
			event.put("endTime", eventQuery.getEvent().getEndtime());
			event.put("enrollingTime", eventQuery.getEvent().getEnrollingtime());
			event.put("closingTime", eventQuery.getEvent().getClosingtime());
			event.put("draw", eventQuery.getEvent().getDraw());
			event.put("schedule", eventQuery.getEvent().getSchedule());
			event.put("note", eventQuery.getEvent().getNote());
		}
		return event;
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月17日 下午11:11:38
	 * @param eventPlayer
	 * @Return: HashMap<String,Object>
	 * @Description: players' info of an event
	 *
	 */
	public static HashMap<String, Object> getEventPlayerInfo(EventPlayer eventPlayer) {
		HashMap<String, Object> player = null;
		if(null!=eventPlayer){
			player = new HashMap<String, Object>();
			player.put("id", eventPlayer.getId());
			player.put("userId", eventPlayer.getUserid());
			player.put("eventId", eventPlayer.getEventid());
			player.put("userName", eventPlayer.getUsername());
			player.put("userAvatar", eventPlayer.getUseravatar());
			player.put("isRetired", eventPlayer.getIsretired());
			player.put("note", eventPlayer.getNote());
		}
		return player;
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月17日 下午11:57:39
	 * @param eventWorker
	 * @Return: HashMap<String,Object>
	 * @Description: workers' info of an event
	 *
	 */
	public static HashMap<String, Object> getEventWorkerInfo(EventWorker eventWorker) {
		HashMap<String, Object> worker = null;
		if(null!=eventWorker){
			worker = new HashMap<String, Object>();
			worker.put("id", eventWorker.getId());
			worker.put("userId", eventWorker.getUserid());
			worker.put("eventId", eventWorker.getEventid());
			worker.put("userName", eventWorker.getUsername());
			worker.put("userAvatar", eventWorker.getUseravatar());
			worker.put("role", eventWorker.getRole());
			worker.put("privilege", eventWorker.getPrivilege());
			worker.put("isReferee", eventWorker.getIsreferee());
			worker.put("isLineReferee", eventWorker.getIslinereferee());
			worker.put("isCaddy", eventWorker.getIscaddy());
			worker.put("note", eventWorker.getNote());
		}
		return worker;
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月18日 上午12:26:54
	 * @param singlesMatchQuery
	 * @Return: HashMap<String,Object>
	 * @Description: singles match info of an event
	 *
	 */
	public static HashMap<String, Object> getSinglesMatchInfo(SinglesMatchQuery singlesMatchQuery){
		HashMap<String, Object> singlesMatch = null;
		if(null!=singlesMatchQuery){
			singlesMatch = new HashMap<String, Object>();
			singlesMatch.put("id", singlesMatchQuery.getSinglesMatch().getId());
			singlesMatch.put("eventId", singlesMatchQuery.getSinglesMatch().getEventid());
			singlesMatch.put("homeId", singlesMatchQuery.getSinglesMatch().getHomeid());
			singlesMatch.put("homeName", singlesMatchQuery.getHome().getName());
			singlesMatch.put("homeAvatar", singlesMatchQuery.getHome().getPortrait());
			singlesMatch.put("guestId", singlesMatchQuery.getSinglesMatch().getGuestid());
			singlesMatch.put("guestName", singlesMatchQuery.getGuest().getName());
			singlesMatch.put("guestAvatar", singlesMatchQuery.getGuest().getPortrait());
			singlesMatch.put("type", singlesMatchQuery.getSinglesMatch().getType());
			singlesMatch.put("score", singlesMatchQuery.getSinglesMatch().getScore());
			singlesMatch.put("round", singlesMatchQuery.getSinglesMatch().getRound());
			singlesMatch.put("isHomeRetired", singlesMatchQuery.getSinglesMatch().getIshomeretired());
			singlesMatch.put("isGuestRetired", singlesMatchQuery.getSinglesMatch().getIsguestretired());
			singlesMatch.put("homePoint", singlesMatchQuery.getSinglesMatch().getHomepoint());
			singlesMatch.put("guestPoint", singlesMatchQuery.getSinglesMatch().getGuestpoint());
			singlesMatch.put("isHomeWin", singlesMatchQuery.getSinglesMatch().getIshomewin());
			singlesMatch.put("mirror", singlesMatchQuery.getSinglesMatch().getMirror());
			singlesMatch.put("note", singlesMatchQuery.getSinglesMatch().getNote());
		}
		return singlesMatch;
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月18日 上午12:27:14
	 * @param doublesMatchQuery
	 * @Return: HashMap<String,Object>
	 * @Description: doubles match info of an event
	 *
	 */
	public static HashMap<String, Object> getDoublesMatchInfo(DoublesMatchQuery doublesMatchQuery){
		HashMap<String, Object> doublesMatch = null;
		if(null!=doublesMatchQuery){
			doublesMatch = new HashMap<String, Object>();
			doublesMatch.put("id", doublesMatchQuery.getDoublesMatch().getId());
			doublesMatch.put("eventId", doublesMatchQuery.getDoublesMatch().getEventid());
			doublesMatch.put("homeId", doublesMatchQuery.getDoublesMatch().getHomeid());
			doublesMatch.put("homeName", doublesMatchQuery.getHome().getName());
			doublesMatch.put("guestId", doublesMatchQuery.getDoublesMatch().getGuestid());
			doublesMatch.put("guestName", doublesMatchQuery.getGuest().getName());
			doublesMatch.put("type", doublesMatchQuery.getDoublesMatch().getType());
			doublesMatch.put("score", doublesMatchQuery.getDoublesMatch().getScore());
			doublesMatch.put("round", doublesMatchQuery.getDoublesMatch().getRound());
			doublesMatch.put("isHomeRetired", doublesMatchQuery.getDoublesMatch().getIshomeretired());
			doublesMatch.put("isGuestRetired", doublesMatchQuery.getDoublesMatch().getIsguestretired());
			doublesMatch.put("homePoint", doublesMatchQuery.getDoublesMatch().getHomepoint());
			doublesMatch.put("guestPoint", doublesMatchQuery.getDoublesMatch().getGuestpoint());
			doublesMatch.put("isHomeWin", doublesMatchQuery.getDoublesMatch().getIshomewin());
			doublesMatch.put("mirror", doublesMatchQuery.getDoublesMatch().getMirror());
			doublesMatch.put("note", doublesMatchQuery.getDoublesMatch().getNote());
		}
		return doublesMatch;
	}
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年8月18日 上午9:44:53
	 * @param statisticQuery
	 * @Return: HashMap<String,Object>
	 * @Description: statistic info of a match
	 *
	 */
	public static HashMap<String, Object> getStatisticInfo(StatisticQuery statisticQuery){
		HashMap<String, Object> statistic = null;
		if(null!=statisticQuery){
			statistic = new HashMap<String, Object>();
			statistic.put("id", statisticQuery.getStatistic().getId());
			statistic.put("matchId", statisticQuery.getStatistic().getMatchid());
			statistic.put("userId", statisticQuery.getStatistic().getUserid());
			statistic.put("userName", statisticQuery.getUser().getName());
			statistic.put("userAvatar", statisticQuery.getUser().getPortrait());
			statistic.put("aces", statisticQuery.getStatistic().getId());
			statistic.put("firstServices", statisticQuery.getStatistic().getId());
			statistic.put("secondServices", statisticQuery.getStatistic().getId());
			statistic.put("doubleFaults", statisticQuery.getStatistic().getId());
			statistic.put("firstGoals", statisticQuery.getStatistic().getId());
			statistic.put("secondGoals", statisticQuery.getStatistic().getId());
			statistic.put("saveBreakPoints", statisticQuery.getStatistic().getId());
			statistic.put("breakPoints", statisticQuery.getStatistic().getId());
			statistic.put("serviceBreakPoints", statisticQuery.getStatistic().getId());
			statistic.put("receiveBreakPoints", statisticQuery.getStatistic().getId());
			statistic.put("firstReturnGoals", statisticQuery.getStatistic().getId());
			statistic.put("secondReturnGoals", statisticQuery.getStatistic().getId());
			statistic.put("services", statisticQuery.getStatistic().getId());
			statistic.put("note", statisticQuery.getStatistic().getId());
		}
		return statistic;
	}
}
