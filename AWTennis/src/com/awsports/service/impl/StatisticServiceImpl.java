package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.StatisticMapper;
import com.awsports.pojo.Statistic;
import com.awsports.pojo.StatisticQuery;
import com.awsports.service.StatisticService;

public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private StatisticMapper statisticMapper;
	
	@Override
	public List<StatisticQuery> findByMatchMirror(String matchId) throws Exception {
		return statisticMapper.findByMatchMirror(matchId);
	}

	@Override
	public void insertOne(Statistic statistic) throws Exception {
		statisticMapper.insertOne(statistic);
	}	

	@Override
	public void updateById(Statistic statistic) throws Exception {
		statisticMapper.updateById(statistic);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		statisticMapper.deleteById(id);
	}

	@Override
	public Statistic findById(Integer id) throws Exception {
		return statisticMapper.findById(id);
	}

	@Override
	public List<StatisticQuery> findByCondition(Statistic statistic) throws Exception {
		return statisticMapper.findByCondition(statistic);
	}

	@Override
	public void deleteByMatchMirror(String matchId) throws Exception {
		statisticMapper.deleteByMatchMirror(matchId);
	}

}
