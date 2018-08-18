package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.ActivityMapper;
import com.awsports.pojo.Activity;
import com.awsports.pojo.ActivityQuery;
import com.awsports.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityMapper activityMapper;
	
	@Override
	public List<ActivityQuery> findAll(ActivityQuery activityQuery) throws Exception {
		// TODO Auto-generated method stub
		return activityMapper.findAll(activityQuery);
	}

	@Override
	public Activity findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return activityMapper.findById(id);
	}

	@Override
	public void updateById(Activity activity) throws Exception {
		// TODO Auto-generated method stub
		activityMapper.updateById(activity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		activityMapper.deleteById(id);
	}

	@Override
	public void insertOne(Activity activity) throws Exception {
		// TODO Auto-generated method stub
		activityMapper.insertOne(activity);
	}

}
