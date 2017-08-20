package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Team;
import com.awsports.pojo.TeamQuery;

public interface TeamMapper {
	public List<TeamQuery> findAll(TeamQuery teamQuery) throws Exception;
	public Team findById(Integer id) throws Exception;
	public Team findByUsers(Team team) throws Exception;
	public void insertOne(Team team) throws Exception;
	public void updateById(Team team) throws Exception;
	public void deleteById(Integer id) throws Exception;
}
