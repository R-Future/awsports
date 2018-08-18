package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Statistic;
import com.awsports.pojo.StatisticQuery;

@Service
public interface StatisticService {
	public List<StatisticQuery> findByMatchMirror(String matchId) throws Exception;
	public Statistic findById(Integer id) throws Exception;
	public List<StatisticQuery> findByCondition(Statistic statistic) throws Exception;
	public void insertOne(Statistic statistic) throws Exception;
	public void updateById(Statistic statistic) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public void deleteByMatchMirror(String matchId) throws Exception;
}
