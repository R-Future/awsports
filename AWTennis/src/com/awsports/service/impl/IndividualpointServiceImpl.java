package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.IndividualpointMapper;
import com.awsports.pojo.Individualpoint;
import com.awsports.pojo.IndividualpointQuery;
import com.awsports.service.IndividualpointService;

public class IndividualpointServiceImpl implements IndividualpointService {

	@Autowired
	private IndividualpointMapper individualpointMapper;
	
	@Override
	public List<IndividualpointQuery> findAll(IndividualpointQuery individualpointQuery) throws Exception {
		// TODO Auto-generated method stub
		return individualpointMapper.findAll(individualpointQuery);
	}

	@Override
	public void insertOne(Individualpoint individualpoint) throws Exception {
		// TODO Auto-generated method stub
		individualpointMapper.insertOne(individualpoint);
	}

	@Override
	public void updateById(Individualpoint individualpoint) throws Exception {
		// TODO Auto-generated method stub
		individualpointMapper.updateById(individualpoint);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		individualpointMapper.deleteById(id);
	}

	@Override
	public Individualpoint findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return individualpointMapper.findById(id);
	}

	@Override
	public Individualpoint findByUseridYearWeekEntry(Individualpoint individualpoint) throws Exception {
		// TODO Auto-generated method stub
		return individualpointMapper.findByUseridYearWeekEntry(individualpoint);
	}

	@Override
	public List<Individualpoint> findByEntryYearWeek(Individualpoint individualpoint) throws Exception {
		// TODO Auto-generated method stub
		return individualpointMapper.findByEntryYearWeek(individualpoint);
	}

}
