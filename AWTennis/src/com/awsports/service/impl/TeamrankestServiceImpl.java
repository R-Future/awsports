package com.awsports.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.TeamrankestMapper;
import com.awsports.pojo.Teamrankest;
import com.awsports.pojo.TeamrankestQuery;
import com.awsports.service.TeamrankestService;

public class TeamrankestServiceImpl implements TeamrankestService {

	@Autowired
	private TeamrankestMapper teamrankestMapper;

	@Override
	public TeamrankestQuery findAll(TeamrankestQuery teamrankestQuery) throws Exception {
		// TODO Auto-generated method stub
		return teamrankestMapper.findAll(teamrankestQuery);
	}

	@Override
	public Teamrankest findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return teamrankestMapper.findById(id);
	}

	@Override
	public void insertOne(Teamrankest teamrankest) throws Exception {
		// TODO Auto-generated method stub
		teamrankestMapper.insertOne(teamrankest);
	}

	@Override
	public void updateById(Teamrankest teamrankest) throws Exception {
		// TODO Auto-generated method stub
		teamrankestMapper.updateById(teamrankest);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		teamrankestMapper.deleteById(id);
	}

	@Override
	public Teamrankest findByTeamidEntry(Teamrankest teamrankest) throws Exception {
		// TODO Auto-generated method stub
		return teamrankestMapper.findByTeamidEntry(teamrankest);
	}
	
	
}
