package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.EventWorker;

public interface EventWorkerMapper {
	public List<EventWorker> findByEventId(Integer eventId) throws Exception;
	public EventWorker findById(Integer id) throws Exception;
	public void insertOne(EventWorker eventWorker) throws Exception;
	public void updateById(EventWorker eventWorker) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public void deleteByEventId(Integer eventId) throws Exception;
} 