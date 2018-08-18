package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.EventWorkerMapper;
import com.awsports.pojo.EventWorker;
import com.awsports.service.EventWorkerService;

public class EventWorkerServiceImpl implements EventWorkerService {

	@Autowired
	private EventWorkerMapper eventWorkerMapper;
	
	@Override
	public List<EventWorker> findByEventId(Integer eventId) throws Exception {
		return eventWorkerMapper.findByEventId(eventId);
	}

	@Override
	public EventWorker findById(Integer id) throws Exception {
		return eventWorkerMapper.findById(id);
	}

	@Override
	public void insertOne(EventWorker eventWorker) throws Exception {
		eventWorkerMapper.insertOne(eventWorker);
	}

	@Override
	public void updateById(EventWorker eventWorker) throws Exception {
		eventWorkerMapper.updateById(eventWorker);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		eventWorkerMapper.deleteById(id);
	}

	@Override
	public void deleteByEventId(Integer eventId) throws Exception {
		eventWorkerMapper.deleteByEventId(eventId);
	}

}
