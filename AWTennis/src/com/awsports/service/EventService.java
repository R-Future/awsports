package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Event;
import com.awsports.pojo.EventQuery;

@Service
public interface EventService {
	public List<EventQuery> findAll(EventQuery eventQuery) throws Exception;
	public void insertOne(Event event) throws Exception;
	public void updateById(Event event) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public EventQuery findById(Integer id) throws Exception;
}
