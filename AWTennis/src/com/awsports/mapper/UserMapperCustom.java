package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.User;
import com.awsports.pojo.UserQuery;

public interface UserMapperCustom {
	public List<User> findAll(UserQuery userQuery) throws Exception;
	public User findById(Integer id) throws Exception;
	public void save(User user) throws Exception;
}
