package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.IndividualrankMapper;
import com.awsports.pojo.Individualrank;
import com.awsports.pojo.IndividualrankQuery;
import com.awsports.service.IndividualrankService;

public class IndividualrankServiceImpl implements IndividualrankService {

	@Autowired
	private IndividualrankMapper individualrankMapper;
	
	@Override
	public List<IndividualrankQuery> findAll(IndividualrankQuery individualrankQuery) throws Exception {
		// TODO Auto-generated method stub
		return individualrankMapper.findAll(individualrankQuery);
	}

	@Override
	public Individualrank findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return individualrankMapper.findById(id);
	}

	@Override
	public void insertOne(Individualrank individualrank) throws Exception {
		// TODO Auto-generated method stub
		individualrankMapper.insertOne(individualrank);
	}

	@Override
	public void updateById(Individualrank indiviudalrank) throws Exception {
		// TODO Auto-generated method stub
		individualrankMapper.updateById(indiviudalrank);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		individualrankMapper.deleteById(id);
	}

	@Override
	public List<Individualrank> findByUseridEntry(Individualrank individualrank) throws Exception {
		// TODO Auto-generated method stub
		return individualrankMapper.findByUseridEntry(individualrank);
	}

	@Override
	public Individualrank findByUseridEntryYear(Individualrank individualrank) throws Exception {
		// TODO Auto-generated method stub
		return individualrankMapper.findByUseridEntryYear(individualrank);
	}

}
