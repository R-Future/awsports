package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.LevelMapper;
import com.awsports.pojo.Level;
import com.awsports.service.LevelService;

public class LevelServiceImpl implements LevelService {

	@Autowired
	private LevelMapper levelMapper;
	
	@Override
	public List<Level> findAll(Level level) throws Exception {
		// TODO Auto-generated method stub
		return levelMapper.findAll(level);
	}

	@Override
	public Level findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return levelMapper.findById(id);
	}

	@Override
	public void updateById(Level level) throws Exception {
		// TODO Auto-generated method stub
		levelMapper.updateById(level);
	}

	@Override
	public void insertOne(Level level) throws Exception {
		// TODO Auto-generated method stub
		levelMapper.insertOne(level);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		levelMapper.deleteById(id);
	}

	@Override
	public Level findByChineseName(Level level) throws Exception {
		// TODO Auto-generated method stub
		return levelMapper.findByChineseName(level);
	}

}
