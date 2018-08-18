package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.SinglematchscoreMapper;
import com.awsports.pojo.Singlematchscore;
import com.awsports.service.SinglematchscoreService;

public class SinglematchscoreServiceImpl implements SinglematchscoreService {

	@Autowired
	private SinglematchscoreMapper singlematchscoreMapper;

	@Override
	public void deleteByMatchid(Integer matchid) throws Exception {
		// TODO Auto-generated method stub
		singlematchscoreMapper.deleteByMatchid(matchid);
	}


	@Override
	public void insertOne(Singlematchscore singlematchscore) throws Exception {
		// TODO Auto-generated method stub
		singlematchscoreMapper.insertOne(singlematchscore);
	}


	@Override
	public List<Singlematchscore> findByMatchid(Integer matchid) throws Exception {
		// TODO Auto-generated method stub
		return singlematchscoreMapper.findByMatchid(matchid);
	}


	@Override
	public void updateById(Singlematchscore singlematchscore) throws Exception {
		// TODO Auto-generated method stub
		singlematchscoreMapper.updateById(singlematchscore);
	}

}
