package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.SinglesMatch;
import com.awsports.pojo.SinglesMatchQuery;

@Service
public interface SinglesMatchService {
	public SinglesMatch findById(Integer id) throws Exception;
	public List<SinglesMatchQuery> findByEventId(Integer eventId) throws Exception;
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
	public List<SinglesMatchQuery> findByConditions(SinglesMatch singlesMatch) throws Exception;
	public void insertOne(SinglesMatch singlesMatch) throws Exception;
	public void updateById(SinglesMatch singlesMatch) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public void deleteByMirror(String mirror) throws Exception;
	public void deleteByEventId(Integer eventId) throws Exception;
}
