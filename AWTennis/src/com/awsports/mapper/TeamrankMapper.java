package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Teamrank;
import com.awsports.pojo.TeamrankQuery;

public interface TeamrankMapper {
    public List<TeamrankQuery> findAll(TeamrankQuery teamrankQuery) throws Exception;
    public Teamrank findById(Integer id) throws Exception;
    public void insertOne(Teamrank teamrank) throws Exception;
    public void updateById(Teamrank teamrank) throws Exception;
    public void deleteById(Integer id) throws Exception;
    public List<Teamrank> findByTeamidEntry(Teamrank teamrank) throws Exception;
    public Teamrank findByTeamidEntryYear(Teamrank teamrank) throws Exception;
    public List<Teamrank> findTeamRank(Teamrank teamrank) throws Exception;
}