package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.TeamMapper;
import com.awsports.pojo.Team;
import com.awsports.pojo.TeamQuery;
import com.awsports.service.TeamService;

public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamMapper teamMapper;
	@Override
	public List<TeamQuery> findAll(TeamQuery teamQuery) throws Exception {
		// TODO Auto-generated method stub
		return teamMapper.findAll(teamQuery);
	}

	@Override
	public Team findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return teamMapper.findById(id);
	}

	@Override
	public void insertOne(Team team) throws Exception {
		// TODO Auto-generated method stub
		teamMapper.insertOne(team);
	}

	@Override
	public void updateById(Team team) throws Exception {
		// TODO Auto-generated method stub
		teamMapper.updateById(team);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		teamMapper.deleteById(id);
	}

}
