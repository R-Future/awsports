package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Activity;
import com.awsports.pojo.ActivityQuery;

public interface ActivityMapper {
	public List<ActivityQuery> findAll(ActivityQuery activityQuery) throws Exception;
	public Activity findById(Integer id) throws Exception;
	public void updateById(Activity activity) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public void add(Activity activity) throws Exception;
}
