package com.awsports.util;

import java.util.Comparator;

import com.awsports.pojo.Teamrank;
public class TeamrankComparator implements Comparator<Object> {

	/**
	 * 1.积分高的排在前面
	 * 2.积分相同，胜率高者排在前面
	 * 3.胜率相同，净胜局高者排在前面
	 */
	@Override
	public int compare(Object obj1,Object obj2) {
		// TODO Auto-generated method stub
		Teamrank teamrank1=(Teamrank)obj1;
		Teamrank teamrank2=(Teamrank)obj2;
		//先比较积分
		int flag=teamrank1.getTotalpoint().compareTo(teamrank2.getTotalpoint());
		if(flag==0){
			//积分相同，比较胜率
			Double winProbability1=(double)teamrank1.getWins().intValue()/teamrank1.getTotalmatchs().intValue();
			Double winProbability2=(double)teamrank2.getWins().intValue()/teamrank2.getTotalmatchs().intValue();
			flag=winProbability1.compareTo(winProbability2);
			if(flag==0){
				//胜率相同比较净胜局
				flag=teamrank1.getTotalmarginbureau().compareTo(teamrank2.getTotalmarginbureau());
			}else{
				//。。.
			}
		}else{
			//。。。
		}
		return -flag;
	}

}
