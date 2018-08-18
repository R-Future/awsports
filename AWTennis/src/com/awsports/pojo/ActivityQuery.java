package com.awsports.pojo;

/**
 * 
 * @author: Fu
 * @time: 2017年5月24日上午11:25:22
 * @description: 活动查询的包装类
 *
 */
public class ActivityQuery {
	
	//活动信息
	private Activity activity;
	
	//添加场馆名称用于与aw_arena表进行联合查询
	private Arena arena;

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}
		
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
