package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awsports.mapper.EventPlayerMapper;
import com.awsports.pojo.EventPlayer;
import com.awsports.service.EventPlayerService;

@Service
public class EventPlayerServiceImpl implements EventPlayerService {
	
	@Autowired
	private EventPlayerMapper eventPlayerMapper;

	@Override
	public EventPlayer findById(Integer id) throws Exception {
		return eventPlayerMapper.findById(id);
	}

	@Override
	public List<EventPlayer> findByEventId(Integer eventId) throws Exception {
		return eventPlayerMapper.findByEventId(eventId);
	}

	@Override
	public void insertOne(EventPlayer eventPlayer) throws Exception {
		eventPlayerMapper.insertOne(eventPlayer);
	}

	@Override
	public void updateById(EventPlayer eventPlayer) throws Exception {
		eventPlayerMapper.updateById(eventPlayer);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		eventPlayerMapper.deleteById(id);
	}

	@Override
	public void deleteByEventId(Integer eventId) throws Exception {
		eventPlayerMapper.deleteByEventId(eventId);
	}

}
