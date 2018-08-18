package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.EventWorker;

@Service
public interface EventWorkerService {
	public List<EventWorker> findByEventId(Integer eventId) throws Exception;
	public EventWorker findById(Integer id) throws Exception;
	public void insertOne(EventWorker eventWorker) throws Exception;
	public void updateById(EventWorker eventWorker) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public void deleteByEventId(Integer eventId) throws Exception;
}
