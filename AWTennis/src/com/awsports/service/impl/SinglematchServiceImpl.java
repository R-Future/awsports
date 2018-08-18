package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awsports.mapper.SinglematchMapper;
import com.awsports.pojo.Singlematch;
import com.awsports.pojo.SinglematchQuery;
import com.awsports.pojo.User;
import com.awsports.service.SinglematchService;

@Service
public class SinglematchServiceImpl implements SinglematchService {

	@Autowired
	private SinglematchMapper singlematchMapper;
	
	@Override
	public List<SinglematchQuery> findAll(SinglematchQuery singlematchQuery) throws Exception {
		// TODO Auto-generated method stub
		return singlematchMapper.findAll(singlematchQuery);
	}

	@Override
	public void insertOne(Singlematch sinlematch) throws Exception {
		// TODO Auto-generated method stub
		singlematchMapper.insertOne(sinlematch);
	}

	@Override
	public Singlematch findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return singlematchMapper.findById(id);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		singlematchMapper.deleteById(id);
	}

	@Override
	public void updateById(Singlematch singlematch) throws Exception {
		// TODO Auto-generated method stub
		singlematchMapper.updateById(singlematch);
	}

	@Override
	public Singlematch findMirrorByOrigin(Singlematch singlematch) throws Exception {
		// TODO Auto-generated method stub
		return singlematchMapper.findMirrorByOrigin(singlematch);
	}

	@Override
	public List<SinglematchQuery> findByUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return singlematchMapper.findByUser(user);
	}

}
