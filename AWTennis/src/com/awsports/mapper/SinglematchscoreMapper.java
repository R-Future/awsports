package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Singlematchscore;

public interface SinglematchscoreMapper {
	
	public void insertOne(Singlematchscore singlematchscore) throws Exception;
	public void deleteByMatchid(Integer matchid) throws Exception;
	public List<Singlematchscore> findByMatchid(Integer matchid) throws Exception;
	public void updateById(Singlematchscore singlematchscore) throws Exception;
}
