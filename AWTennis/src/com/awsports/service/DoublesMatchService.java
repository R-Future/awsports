package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.DoublesMatch;
import com.awsports.pojo.DoublesMatchQuery;

@Service
public interface DoublesMatchService {
	public DoublesMatch findById(Integer id) throws Exception;
	public List<DoublesMatchQuery> findByEventId(Integer eventId) throws Exception;
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月12日 下午9:32:56
	 * @param matchRecord
	 * @throws Exception
	 * @Return: List<MatchRecord>
	 * @Description: conditions contain eventid, homeid, homepartnerid and type
	 *
	 */
	public List<DoublesMatchQuery> findByConditions(DoublesMatch DoublesMatch) throws Exception;
	public void insertOne(DoublesMatch DoublesMatch) throws Exception;
	public void updateById(DoublesMatch DoublesMatch) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public void deleteByMirror(String mirror) throws Exception;
	public void deleteByEventId(Integer eventId) throws Exception;
}
