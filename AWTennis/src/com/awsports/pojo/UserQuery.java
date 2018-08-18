package com.awsports.pojo;

/**
 * 
 * @company: awsports
 * @version: 1.0
 * @author: Fu
 * @package: com.awsports.pojo
 * @description: 包装类，用于联合查询
 * @date: 2017年5月19日 下午2:44:37
 *
 */
public class UserQuery {
	
	//用户信息
	private User user;
	
	private Level level;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}
