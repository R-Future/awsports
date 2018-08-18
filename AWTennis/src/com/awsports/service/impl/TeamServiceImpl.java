package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.TeamMapper;
import com.awsports.pojo.Team;
import com.awsports.pojo.TeamQuery;
import com.awsports.pojo.User;
import com.awsports.service.TeamService;

public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamMapper teamMapper;
	@Override
	public List<TeamQuery> findAll(TeamQuery teamQuery) throws Exception {
		return teamMapper.findAll(teamQuery);
	}

	@Override
	public Team findById(Integer id) throws Exception {
		return teamMapper.findById(id);
	}

	@Override
	public void insertOne(Team team) throws Exception {
		teamMapper.insertOne(team);
	}

	@Override
	public void updateById(Team team) throws Exception {
		teamMapper.updateById(team);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		teamMapper.deleteById(id);
	}

	@Override
	public Team findByUsers(Team team) throws Exception {
		return teamMapper.findByUsers(team);
	}

	@Override
	public List<Team> findByUser(User user) throws Exception {
		return teamMapper.findByUser(user);
	}

	@Override
	public List<Team> findByEventId(Integer eventId) throws Exception {
		return teamMapper.findByEventId(eventId);
	}

}
