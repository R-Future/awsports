package com.awsports.util;

import java.util.Comparator;

import com.awsports.pojo.Qualificationrank;

public class QualificationrankComparator implements Comparator<Object> {

	/**
	 * 1.积分高的排在前面
	 * 2.积分相同，胜率高者排在前面
	 * 3.胜率相同，净胜局高者排在前面
	 */
	@Override
	public int compare(Object obj1,Object obj2) {
		// TODO Auto-generated method stub
		Qualificationrank qualificationrank1=(Qualificationrank)obj1;
		Qualificationrank qualificationrank2=(Qualificationrank)obj2;
		//先比较积分
		int flag=qualificationrank1.getTotalpoint().compareTo(qualificationrank2.getTotalpoint());
		if(flag==0){
			//积分相同，比较胜率
			Double winProbability1=(double)qualificationrank1.getTotalwins().intValue()/qualificationrank1.getTotalmatchs().intValue();
			Double winProbability2=(double)qualificationrank2.getTotalwins().intValue()/qualificationrank2.getTotalmatchs().intValue();
			flag=winProbability1.compareTo(winProbability2);
			if(flag==0){
				//胜率相同比较净胜局
				flag=qualificationrank1.getTotalmarginbureau().compareTo(qualificationrank2.getTotalmarginbureau());
			}else{
				//。。.
			}
		}else{
			//。。。
		}
		return -flag;
	}

}
