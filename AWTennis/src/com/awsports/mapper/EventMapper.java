package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Event;
import com.awsports.pojo.EventQuery;

public interface EventMapper {
	
	public List<EventQuery> findAll(EventQuery eventQuery) throws Exception;
	public void insertOne(Event event) throws Exception;
	public void updateById(Event event) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public EventQuery findById(Integer id) throws Exception;
	
}