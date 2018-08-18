package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Team;
import com.awsports.pojo.Teamrankest;
import com.awsports.pojo.TeamrankestQuery;

public interface TeamrankestMapper {
    public List<TeamrankestQuery> findAll(TeamrankestQuery teamrankestQuery) throws Exception;
    public Teamrankest findById(Integer id) throws Exception;
    public void insertOne(Teamrankest teamrankest) throws Exception;
    public void updateById(Teamrankest teamrankest) throws Exception;
    public void deleteById(Integer id) throws Exception;
    public Teamrankest findByTeamidEntry(Teamrankest teamrankest) throws Exception;
    public List<Teamrankest> findByTeam(Team team) throws Exception;
}