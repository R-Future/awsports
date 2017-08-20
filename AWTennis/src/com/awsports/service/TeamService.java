package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Team;
import com.awsports.pojo.TeamQuery;

@Service
public interface TeamService {
	public List<TeamQuery> findAll(TeamQuery teamQuery) throws Exception;
	public Team findById(Integer id) throws Exception;
	public Team findByUsers(Team team) throws Exception;
	public void insertOne(Team team) throws Exception;
	public void updateById(Team team) throws Exception;
	public void deleteById(Integer id) throws Exception;
}