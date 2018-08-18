package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.IndividualrankestMapper;
import com.awsports.pojo.Individualrankest;
import com.awsports.pojo.IndividualrankestQuery;
import com.awsports.pojo.User;
import com.awsports.service.IndividualrankestService;

public class IndividualrankestServiceImpl implements IndividualrankestService {

	@Autowired
	private IndividualrankestMapper individualrankestMapper;
	
	@Override
	public List<IndividualrankestQuery> findAll(IndividualrankestQuery individualrankestQuery) throws Exception {
		// TODO Auto-generated method stub
		return individualrankestMapper.findAll(individualrankestQuery);
	}

	@Override
	public Individualrankest findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return individualrankestMapper.findById(id);
	}

	@Override
	public void insertOne(Individualrankest individualrankest) throws Exception {
		// TODO Auto-generated method stub
		individualrankestMapper.insertOne(individualrankest);
	}

	@Override
	public void updateById(Individualrankest individualrankest) throws Exception {
		// TODO Auto-generated method stub
		individualrankestMapper.updateById(individualrankest);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		individualrankestMapper.deleteById(id);
	}

	@Override
	public Individualrankest findByUseridEntry(Individualrankest individualrankest) throws Exception {
		// TODO Auto-generated method stub
		return individualrankestMapper.findByUseridEntry(individualrankest);
	}

	@Override
	public List<Individualrankest> findByUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return individualrankestMapper.findByUser(user);
	}

}
