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
	private static Map<Integer,String> backhandTypes;
	private static Map<Integer,String> sexTypes;
	private static Map<Integer,String> entryTypes;
	
	/**
	 * 
	 * @date: 2017年5月26日
	 * @return: Map<Integer,String>
	 * @description: 场馆场地类型与存入数据库中数字的对应关系
	 *
	 */
	public static Map<Integer,String> arenaType() throws Exception{
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
	public static Map<Integer,String> forehandType() throws Exception{
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
	public static Map<Integer,String> backhandType() throws Exception{
		backhandTypes=new HashMap<Integer,String>();
		//Integer会为空对象默认复制0，这样会导致数据查询时，若传入0，则被判定为null
		backhandTypes.put(0, "双反");
		backhandTypes.put(1, "单反");
		return backhandTypes;
	}
	
	/**
	 * 
	 * @date: 2017年5月26日
	 * @return: Map<Integer,String>
	 * @description: 性别与数据库中数字的对应关系
	 *
	 */
	public static Map<Integer,String> sexType() throws Exception{
		sexTypes=new HashMap<Integer,String>();
		//Integer会为空对象默认复制0，这样会导致数据查询时，若传入0，则被判定为null
		sexTypes.put(0, "男");
		sexTypes.put(1, "女");
		return sexTypes;
	}
	
	/**
	 * 
	 * @date: 2017年5月26日
	 * @return: Map<Integer,String>
	 * @description: 参赛类型与数据库中数字的对应关系
	 *
	 */
	public static Map<Integer,String> entryType() throws Exception{
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
	
}
