package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.EventPlayer;

public interface EventPlayerMapper {
	public EventPlayer findById(Integer id) throws Exception;
	public List<EventPlayer> findByEventId(Integer eventId) throws Exception;
	public void insertOne(EventPlayer eventPlayer) throws Exception;
	public void updateById(EventPlayer eventPlayer) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public void deleteByEventId(Integer eventId) throws Exception;
}