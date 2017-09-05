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
	private static Map<Integer,String> teamEntryTypes;
	private static Map<Integer,String> individualEntryTypes;
	private static Map<Integer,String> roundTypes;
	private static Map<Integer,String> TournamentModeTypes;
	
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
	 * @date: 2017年6月17日 下午4:56:29
	 * @return: Map<Integer,String>
	 * @description: 单体参赛类型与数据库中数字的对应关系
	 *
	 */
	public static Map<Integer,String> individualEntryType(){
		individualEntryTypes=new HashMap<Integer,String>();
		//Integer会为空对象默认复制0，这样会导致数据查询时，若传入0，则被判定为null
		individualEntryTypes.put(1, "男单");
		individualEntryTypes.put(2, "女单");
		individualEntryTypes.put(3, "混合单打");
		individualEntryTypes.put(4, "双打男子个人");
		individualEntryTypes.put(5, "双打女子个人");
		return individualEntryTypes;
	}
	
	/**
	 * 
	 * @date: 2017年5月30日
	 * @return: Map<Integer,String>
	 * @description: 双打组合类型与数字的映射关系
	 *
	 */
	public static Map<Integer,String> teamEntryType(){
		teamEntryTypes=new HashMap<Integer,String>();
		teamEntryTypes.put(6, "男双");
		teamEntryTypes.put(7, "女双");
		teamEntryTypes.put(8, "混双");
		return teamEntryTypes;
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
	
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年9月5日 下午9:27:06
	 * @Return: Map<Integer,String>
	 * @Description: 积分计算模式
	 *
	 */
	public static Map<Integer,String> TournamentModeType(){
		TournamentModeTypes=new HashMap<Integer,String>();
		TournamentModeTypes.put(1, "小组循环制");
		TournamentModeTypes.put(2, "淘汰晋级制");
		TournamentModeTypes.put(3, "小组循环+淘汰晋级制");
		return TournamentModeTypes;
	}
}
