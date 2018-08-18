package com.awsports.util;

import com.awsports.pojo.DoublesMatch;
import com.awsports.pojo.SinglesMatch;

public class MatchUtil {
	
	public static String reverseScore(String score){
		StringBuilder reScore = new StringBuilder();
		if(!score.isEmpty()){
			for(String subStr:score.split(" ")){
				StringBuilder sb = new StringBuilder(subStr);
				sb.reverse();
				reScore.append(sb);
			}
		}
		return reScore.toString();
	}
	
	public static SinglesMatch setMirrorMatch(SinglesMatch singlesMatch, SinglesMatch mirrorMatch){
		if(null!=singlesMatch&&null!=mirrorMatch){
			String mirror = "s"+Long.toString(System.currentTimeMillis());
			singlesMatch.setMirror(mirror);
			mirrorMatch.setMirror(mirror);
			mirrorMatch.setEventid(singlesMatch.getEventid());
			mirrorMatch.setHomeid(singlesMatch.getGuestid());
			mirrorMatch.setGuestid(singlesMatch.getHomeid());
			mirrorMatch.setHomepoint(singlesMatch.getGuestpoint());
			mirrorMatch.setGuestpoint(singlesMatch.getHomepoint());
			mirrorMatch.setRound(singlesMatch.getRound());
			mirrorMatch.setIshomeretired(singlesMatch.getIsguestretired());
			mirrorMatch.setIsguestretired(singlesMatch.getIshomeretired());
			mirrorMatch.setIshomewin(!singlesMatch.getIshomewin());
			mirrorMatch.setInvalid(singlesMatch.getInvalid());
			mirrorMatch.setNote(singlesMatch.getNote());
			mirrorMatch.setScore(reverseScore(singlesMatch.getScore()));
		}
		return mirrorMatch;
	}
	
	public static DoublesMatch setMirrorMatch(DoublesMatch doublesMatch, DoublesMatch mirrorMatch){
		if(null!=doublesMatch&&null!=mirrorMatch){
			String mirror = "d"+Long.toString(System.currentTimeMillis());
			doublesMatch.setMirror(mirror);
			mirrorMatch.setMirror(mirror);
			mirrorMatch.setEventid(doublesMatch.getEventid());
			mirrorMatch.setHomeid(doublesMatch.getGuestid());
			mirrorMatch.setGuestid(doublesMatch.getHomeid());
			mirrorMatch.setHomepoint(doublesMatch.getGuestpoint());
			mirrorMatch.setGuestpoint(doublesMatch.getHomepoint());
			mirrorMatch.setRound(doublesMatch.getRound());
			mirrorMatch.setIshomeretired(doublesMatch.getIsguestretired());
			mirrorMatch.setIsguestretired(doublesMatch.getIshomeretired());
			mirrorMatch.setIshomewin(!doublesMatch.getIshomewin());
			mirrorMatch.setInvalid(doublesMatch.getInvalid());
			mirrorMatch.setNote(doublesMatch.getNote());
			mirrorMatch.setScore(reverseScore(doublesMatch.getScore()));
		}
		return mirrorMatch;
	}
}
