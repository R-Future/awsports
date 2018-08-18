package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Team;
import com.awsports.pojo.TeamQuery;
import com.awsports.pojo.User;

@Service
public interface TeamService {
	public List<TeamQuery> findAll(TeamQuery teamQuery) throws Exception;
	public Team findById(Integer id) throws Exception;
	public List<Team> findByEventId(Integer eventId) throws Exception;
	public Team findByUsers(Team team) throws Exception;
	public List<Team> findByUser(User user) throws Exception;
	public void insertOne(Team team) throws Exception;
	public void updateById(Team team) throws Exception;
	public void deleteById(Integer id) throws Exception;
}