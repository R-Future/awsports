package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Activity;
import com.awsports.pojo.ActivityQuery;

@Service
public interface ActivityService {
	public List<ActivityQuery> findAll(ActivityQuery activityQuery) throws Exception;
	public Activity findById(Integer id) throws Exception;
	public void updateById(Activity activity) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public void insertOne(Activity activity) throws Exception;
}
