package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Teamrank;
import com.awsports.pojo.TeamrankQuery;

@Service
public interface TeamrankService {
	public List<TeamrankQuery> findAll(TeamrankQuery teamrankQuery) throws Exception;
    public Teamrank findById(Integer id) throws Exception;
    public void insertOne(Teamrank teamrank) throws Exception;
    public void updateById(Teamrank teamrank) throws Exception;
    public void deleteById(Integer id) throws Exception;
    public List<Teamrank> findByTeamidEntry(Teamrank teamrank) throws Exception;
    public Teamrank findByTeamidEntryYear(Teamrank teamrank) throws Exception;
    public List<Teamrank> findTeamRank(Teamrank teamrank) throws Exception;
}
