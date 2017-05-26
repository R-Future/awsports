package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.UserMapper;
import com.awsports.pojo.User;
import com.awsports.pojo.UserQuery;
import com.awsports.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAll(UserQuery userQuery) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.findAll(userQuery);
	}

	@Override
	public void updateById(User user) throws Exception {
		// TODO Auto-generated method stub
		userMapper.updateById(user);
	}

	@Override
	public User findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.findById(id);
	}

	@Override
	public void insertOne(User user) throws Exception {
		// TODO Auto-generated method stub
		userMapper.insertOne(user);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		userMapper.deleteById(id);
	}
	
	
}
