package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.User;
import com.awsports.pojo.UserQuery;

@Service
public interface UserService {
	public List<User> findAll(UserQuery userQuery) throws Exception;
	public User findById(Integer id) throws Exception;
	public void update(User user) throws Exception;
	public void add(User user) throws Exception;
	public void deleteById(Integer id) throws Exception;
}
