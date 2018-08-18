package com.awsports.pojo;

/**
 * 
 * @company: awsports
 * @version: 1.0
 * @author: Fu
 * @package: com.awsports.pojo
 * @description: 扩展类，用于在基类上扩展一些字段用于查询使用
 * @date: 2017年5月19日 下午2:45:18
 *
 */
public class User extends AwUser {
	
	//for api
	private String sortBy;
	private String order;
	private int begin;
	private int nRecord;
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getnRecord() {
		return nRecord;
	}
	public void setnRecord(int nRecord) {
		this.nRecord = nRecord;
	}
	
	
}
