package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.User;
import com.awsports.pojo.UserQuery;

@Service
public interface UserService {
	public List<UserQuery> findAll(UserQuery userQuery) throws Exception;
	public User findById(Integer id) throws Exception;
	public User findByName(String name) throws Exception;
	public User findByPhone(String phone) throws Exception;
	public void updateById(User user) throws Exception;
	public void insertOne(User user) throws Exception;
	public void deleteById(Integer id) throws Exception;
}
