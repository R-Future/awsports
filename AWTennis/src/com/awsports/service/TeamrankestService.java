package com.awsports.service;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Teamrankest;
import com.awsports.pojo.TeamrankestQuery;

@Service
public interface TeamrankestService {
	public TeamrankestQuery findAll(TeamrankestQuery teamrankestQuery) throws Exception;
    public Teamrankest findById(Integer id) throws Exception;
    public void insertOne(Teamrankest teamrankest) throws Exception;
    public void updateById(Teamrankest teamrankest) throws Exception;
    public void deleteById(Integer id) throws Exception;
    public Teamrankest findByTeamidEntry(Teamrankest teamrankest) throws Exception;
}
