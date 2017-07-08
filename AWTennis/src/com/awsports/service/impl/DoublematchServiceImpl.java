package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.DoublematchMapper;
import com.awsports.pojo.Doublematch;
import com.awsports.pojo.DoublematchQuery;
import com.awsports.pojo.User;
import com.awsports.service.DoublematchService;

public class DoublematchServiceImpl implements DoublematchService {

	@Autowired
	private DoublematchMapper doublematchMapper;
	@Override
	public List<DoublematchQuery> findAll(DoublematchQuery doublematchQuery) throws Exception {
		// TODO Auto-generated method stub
		return doublematchMapper.findAll(doublematchQuery);
	}

	@Override
	public Doublematch findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return doublematchMapper.findById(id);
	}

	@Override
	public Doublematch findMirrorByOrigin(Doublematch doublematch) throws Exception {
		// TODO Auto-generated method stub
		return doublematchMapper.findMirrorByOrigin(doublematch);
	}

	@Override
	public void insertOne(Doublematch doublematch) throws Exception {
		// TODO Auto-generated method stub
		doublematchMapper.insertOne(doublematch);
	}

	@Override
	public void updateById(Doublematch doublematch) throws Exception {
		// TODO Auto-generated method stub
		doublematchMapper.updateById(doublematch);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		doublematchMapper.deleteById(id);
	}

	@Override
	public List<DoublematchQuery> findByUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return doublematchMapper.findByUser(user);
	}

}
