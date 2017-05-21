package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.UserMapperCustom;
import com.awsports.pojo.User;
import com.awsports.pojo.UserQuery;
import com.awsports.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapperCustom userMapper;

	@Override
	public List<User> findAll(UserQuery userQuery) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.findAll(userQuery);
	}

	@Override
	public void save(User user) throws Exception {
		// TODO Auto-generated method stub
		userMapper.save(user);
	}

	@Override
	public User findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.findById(id);
	}
	
	
}
