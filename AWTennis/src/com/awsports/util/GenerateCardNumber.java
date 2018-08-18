package com.awsports.util;

import java.util.Date;

/**
 * 
 * @Version: 1.0
 * @Author: peRFect
 * @Date: 2017年11月18日 下午12:40:15
 * @Description: 自动生成会员卡号，格式: 21+01+10位timeStamp, 例如: 21011517231234
 *
 */
public class GenerateCardNumber {
	
	public static String generate(int id){
		StringBuffer cardNumStr = new StringBuffer();
		cardNumStr.append("2101");
		cardNumStr.append(String.valueOf((new Date()).getTime()/1000));
		return cardNumStr.toString();
	}
}
