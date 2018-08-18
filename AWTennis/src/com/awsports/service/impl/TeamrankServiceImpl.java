package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.TeamrankMapper;
import com.awsports.pojo.Teamrank;
import com.awsports.pojo.TeamrankQuery;
import com.awsports.service.TeamrankService;

public class TeamrankServiceImpl implements TeamrankService {

	@Autowired
	private TeamrankMapper teamrankMapper;
	
	@Override
	public List<TeamrankQuery> findAll(TeamrankQuery teamrankQuery) throws Exception {
		// TODO Auto-generated method stub
		return teamrankMapper.findAll(teamrankQuery);
	}

	@Override
	public Teamrank findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return teamrankMapper.findById(id);
	}

	@Override
	public void insertOne(Teamrank teamrank) throws Exception {
		// TODO Auto-generated method stub
		teamrankMapper.insertOne(teamrank);
	}

	@Override
	public void updateById(Teamrank teamrank) throws Exception {
		// TODO Auto-generated method stub
		teamrankMapper.updateById(teamrank);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		teamrankMapper.deleteById(id);
	}

	@Override
	public List<Teamrank> findByTeamidEntry(Teamrank teamrank) throws Exception {
		// TODO Auto-generated method stub
		return teamrankMapper.findByTeamidEntry(teamrank);
	}

	@Override
	public Teamrank findByTeamidEntryYear(Teamrank teamrank) throws Exception {
		// TODO Auto-generated method stub
		return teamrankMapper.findByTeamidEntryYear(teamrank);
	}

}
