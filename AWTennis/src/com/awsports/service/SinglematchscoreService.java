package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Singlematchscore;

@Service
public interface SinglematchscoreService {

	public void insertOne(Singlematchscore singlematchscore) throws Exception;
	public void deleteByMatchid(Integer matchid) throws Exception;
	public List<Singlematchscore> findByMatchid(Integer matchid) throws Exception;
	public void updateById(Singlematchscore singlematchscore) throws Exception;
}
