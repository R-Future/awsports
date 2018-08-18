package com.awsports.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.ApikeyMapper;
import com.awsports.service.ApikeyService;

public class ApikeyServiceImpl implements ApikeyService {

	@Autowired
	private ApikeyMapper apikeyMapper;
	
	@Override
	public String findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return apikeyMapper.findById(id);
	}

}
