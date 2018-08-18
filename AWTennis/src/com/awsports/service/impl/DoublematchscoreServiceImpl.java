package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.DoublematchscoreMapper;
import com.awsports.pojo.Doublematchscore;
import com.awsports.service.DoublematchscoreService;

public class DoublematchscoreServiceImpl implements DoublematchscoreService {

	@Autowired
	private DoublematchscoreMapper doublematchscoreMapper;
	@Override
	public List<Doublematchscore> findByMatchid(Integer matchid) throws Exception {
		// TODO Auto-generated method stub
		return doublematchscoreMapper.findByMatchid(matchid);
	}

	@Override
	public void insertOne(Doublematchscore doublematchscore) throws Exception {
		// TODO Auto-generated method stub
		doublematchscoreMapper.insertOne(doublematchscore);
	}

	@Override
	public void updateById(Doublematchscore doublematchscore) throws Exception {
		// TODO Auto-generated method stub
		doublematchscoreMapper.updateById(doublematchscore);
	}

	@Override
	public void deleteByMatchid(Integer matchid) throws Exception {
		// TODO Auto-generated method stub
		doublematchscoreMapper.deleteByMatchid(matchid);
	}

}
