package com.awsports.util;

import java.util.Comparator;

import com.awsports.pojo.Individualrank;

public class IndividualrankComparator implements Comparator<Object> {

	/**
	 * 1.积分高的排在前面
	 * 2.积分相同，胜率高者排在前面
	 * 3.胜率相同，净胜局高者排在前面
	 */
	@Override
	public int compare(Object obj1,Object obj2) {
		// TODO Auto-generated method stub
		Individualrank individualrank1=(Individualrank)obj1;
		Individualrank individualrank2=(Individualrank)obj2;
		//先比较积分
		int flag=individualrank1.getTotalpoint().compareTo(individualrank2.getTotalpoint());
		if(flag==0){
			//积分相同，比较胜率
			Double winProbability1=(double)individualrank1.getWins().intValue()/individualrank1.getTotalmatchs().intValue();
			Double winProbability2=(double)individualrank2.getWins().intValue()/individualrank2.getTotalmatchs().intValue();
			flag=winProbability1.compareTo(winProbability2);
			if(flag==0){
				//胜率相同比较净胜局
				flag=individualrank1.getTotalmarginbureau().compareTo(individualrank2.getTotalmarginbureau());
			}else{
				//。。.
			}
		}else{
			//。。。
		}
		return -flag;
	}

}
