package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.EventMapper;
import com.awsports.pojo.Event;
import com.awsports.pojo.EventQuery;
import com.awsports.service.EventService;

public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventMapper eventMapper;

	@Override
	public List<EventQuery> findAll(EventQuery eventQuery) throws Exception {
		return eventMapper.findAll(eventQuery);
	}

	@Override
	public void insertOne(Event event) throws Exception {
		eventMapper.insertOne(event);
	}

	@Override
	public void updateById(Event event) throws Exception {
		eventMapper.updateById(event);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		eventMapper.deleteById(id);
	}

	@Override
	public EventQuery findById(Integer id) throws Exception {
		return eventMapper.findById(id);
	}

}
