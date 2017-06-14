package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.User;

@Service
public interface UserService {
	public List<User> findAll(User user) throws Exception;
	public User findById(Integer id) throws Exception;
	public void updateById(User user) throws Exception;
	public void insertOne(User user) throws Exception;
	public void deleteById(Integer id) throws Exception;
}
