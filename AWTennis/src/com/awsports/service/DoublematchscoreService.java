package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Doublematchscore;

@Service
public interface DoublematchscoreService {
	public List<Doublematchscore> findByMatchid(Integer matchid) throws Exception;
    public void insertOne(Doublematchscore doublematchscore) throws Exception;
    public void updateById(Doublematchscore doublematchscore) throws Exception;
    public void deleteByMatchid(Integer matchid) throws Exception;
}
