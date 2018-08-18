package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Team;
import com.awsports.pojo.Teamrankest;
import com.awsports.pojo.TeamrankestQuery;

@Service
public interface TeamrankestService {
	public List<TeamrankestQuery> findAll(TeamrankestQuery teamrankestQuery) throws Exception;
    public Teamrankest findById(Integer id) throws Exception;
    public void insertOne(Teamrankest teamrankest) throws Exception;
    public void updateById(Teamrankest teamrankest) throws Exception;
    public void deleteById(Integer id) throws Exception;
    public Teamrankest findByTeamidEntry(Teamrankest teamrankest) throws Exception;
    public List<Teamrankest> findByTeam(Team team) throws Exception;
}
