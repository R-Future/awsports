package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.User;
import com.awsports.pojo.UserQuery;

public interface UserMapper {
	public List<User> findAll(UserQuery userQuery) throws Exception;
	public User findById(Integer id) throws Exception;
	public void updateById(User user) throws Exception;
	public void insertOne(User user) throws Exception;
	public void deleteById(Integer id) throws Exception;
}
