package com.awsports.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author: Fu
 * @time: 2017年5月26日下午2:29:57
 * @description: 类型与数字映射关系 
 *
 */
public class TypeMap {
	
	private static Map<Integer,String> arenaTypes;
	private static Map<Integer,String> forehandTypes;
	private static Map<Boolean,String> backhandTypes;
	private static Map<Boolean,String> sexTypes;
	private static Map<Integer,String> entryTypes;
	private static Map<String,Integer> entryReverseTypes;
	private static Map<Integer,String> teamTypes;
	private static Map<Integer,String> roundTypes;
	
	/**
	 * 
	 * @date: 2017年5月26日
	 * @return: Map<Integer,String>
	 * @description: 场馆场地类型与存入数据库中数字的对应关系
	 *
	 */
	public static Map<Integer,String> arenaType(){
		arenaTypes=new HashMap<Integer,String>();
		//Integer会为空对象默认复制0，这样会导致数据查询时，若传入0，则被判定为null
		arenaTypes.put(1, "硬地");
		arenaTypes.put(2, "红土");
		arenaTypes.put(3, "草地");
		return arenaTypes;
	}
	
	/**
	 * 
	 * @date: 2017年5月26日
	 * @return: Map<Integer,String>
	 * @description: 正手握拍使用手与存入数据库中数字的对应关系
	 *
	 */
	public static Map<Integer,String> forehandType(){
		forehandTypes=new HashMap<Integer,String>();
		//Integer会为空对象默认复制0，这样会导致数据查询时，若传入0，则被判定为null
		forehandTypes.put(1, "右手");
		forehandTypes.put(2, "左手");
		forehandTypes.put(3, "双手");
		return forehandTypes;
	}
	
	/**
	 * 
	 * @date: 2017年5月26日
	 * @return: Map<Integer,String>
	 * @description: 反手击打方式与存入数据库中数字的对应关系
	 *
	 */
	public static Map<Boolean,String> backhandType(){
		backhandTypes=new HashMap<Boolean,String>();
		//Integer会为空对象默认复制0，这样会导致数据查询时，若传入0，则被判定为null
		backhandTypes.put(false, "双反");
		backhandTypes.put(true, "单反");
		return backhandTypes;
	}
	
	/**
	 * 
	 * @date: 2017年5月26日
	 * @return: Map<Integer,String>
	 * @description: 性别与数据库中数字的对应关系
	 *
	 */
	public static Map<Boolean,String> sexType(){
		sexTypes=new HashMap<Boolean,String>();
		//Integer会为空对象默认复制0，这样会导致数据查询时，若传入0，则被判定为null
		sexTypes.put(false, "男");
		sexTypes.put(true, "女");
		return sexTypes;
	}
	
	/**
	 * 
	 * @date: 2017年5月26日
	 * @return: Map<Integer,String>
	 * @description: 参赛类型与数据库中数字的对应关系
	 *
	 */
	public static Map<Integer,String> entryType(){
		entryTypes=new HashMap<Integer,String>();
		//Integer会为空对象默认复制0，这样会导致数据查询时，若传入0，则被判定为null
		entryTypes.put(1, "男单");
		entryTypes.put(2, "女单");
		entryTypes.put(3, "混合单打");
		entryTypes.put(4, "双打男子个人");
		entryTypes.put(5, "双打女子个人");
		entryTypes.put(6, "男双");
		entryTypes.put(7, "女双");
		entryTypes.put(8, "混双");
		return entryTypes;
	}
	
	/**
	 * 
	 * @Author: Fu
	 * @date: 2017年6月6日
	 * @return: Map<String,Integer>
	 * @description: 参赛类型与数据库中数字的反对应关系
	 *
	 */
	public static Map<String,Integer> entryReverseType(){
		entryReverseTypes=new HashMap<String,Integer>();
		//Integer会为空对象默认复制0，这样会导致数据查询时，若传入0，则被判定为null
		entryReverseTypes.put("男单",1);
		entryReverseTypes.put("女单",2);
		entryReverseTypes.put("混合单打",3);
		entryReverseTypes.put("双打男子个人",4);
		entryReverseTypes.put("双打女子个人",5);
		entryReverseTypes.put("男双",6);
		entryReverseTypes.put("女双",7);
		entryReverseTypes.put("混双",8);
		return entryReverseTypes;
	}
	
	/**
	 * 
	 * @date: 2017年5月30日
	 * @return: Map<Integer,String>
	 * @description: 双打组合类型与数字的映射关系
	 *
	 */
	public static Map<Integer,String> teamType(){
		teamTypes=new HashMap<Integer,String>();
		teamTypes.put(6, "男双");
		teamTypes.put(7, "女双");
		teamTypes.put(8, "混双");
		return teamTypes;
	}
	
	/**
	 * 
	 * @date: 2017年5月30日
	 * @return: Map<Integer,String>
	 * @description: 比赛晋级轮次与数字的对应关系
	 *
	 */
	public static Map<Integer,String> roundType(){
		roundTypes=new HashMap<Integer,String>();
		roundTypes.put(1, "小组赛");
		roundTypes.put(128, "128强");
		roundTypes.put(64, "64强");
		roundTypes.put(32, "32强");
		roundTypes.put(16, "16强");
		roundTypes.put(8, "1/4决赛");
		roundTypes.put(4, "半决赛");
		roundTypes.put(2, "决赛");
		return roundTypes;
	}
	
}
