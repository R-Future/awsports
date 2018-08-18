package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.SinglesMatch;
import com.awsports.pojo.SinglesMatchQuery;

public interface SinglesMatchMapper {
	public SinglesMatch findById(Integer id) throws Exception;
	public List<SinglesMatchQuery> findByEventId(Integer eventId) throws Exception;
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月12日 下午9:32:56
	 * @param singlesMatch
	 * @throws Exception
	 * @Return: List<singlesMatch>
	 * @Description: conditions contain eventid, homeid, homepartnerid and type
	 *
	 */
	public List<SinglesMatchQuery> findByConditions(SinglesMatch singlesMatch) throws Exception;
	public SinglesMatch findMirrorMatchByOrigin(SinglesMatch singlesMatch) throws Exception;
	public void insertOne(SinglesMatch singlesMatch) throws Exception;
	public void updateById(SinglesMatch singlesMatch) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public void deleteByMirror(String mirror) throws Exception;
	public void deleteByEventId(Integer eventId) throws Exception;
}