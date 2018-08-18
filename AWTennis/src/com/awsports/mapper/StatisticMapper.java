package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Statistic;
import com.awsports.pojo.StatisticQuery;

public interface StatisticMapper {
   
	public List<StatisticQuery> findByMatchMirror(String matchId) throws Exception;
	public Statistic findById(Integer id) throws Exception;
	public List<StatisticQuery> findByCondition(Statistic statistic) throws Exception;
	public void insertOne(Statistic statistic) throws Exception;
	public void updateById(Statistic statistic) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public void deleteByMatchMirror(String matchId) throws Exception;
	
}