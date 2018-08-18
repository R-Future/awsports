package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.DoublesMatch;
import com.awsports.pojo.DoublesMatchQuery;

public interface DoublesMatchMapper {
	public DoublesMatch findById(Integer id) throws Exception;
	public List<DoublesMatchQuery> findByEventId(Integer eventId) throws Exception;
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2018年7月12日 下午9:32:56
	 * @param DoublesMatch
	 * @throws Exception
	 * @Return: List<DoublesMatch>
	 * @Description: conditions contain eventid, homeid, homepartnerid and type
	 *
	 */
	public List<DoublesMatchQuery> findByConditions(DoublesMatch doublesMatch) throws Exception;
	public DoublesMatch findMirrorMatchByOrigin(DoublesMatch doublesMatch) throws Exception;
	public void insertOne(DoublesMatch doublesMatch) throws Exception;
	public void updateById(DoublesMatch doublesMatch) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public void deleteByMirror(String mirror) throws Exception;
	public void deleteByEventId(Integer eventId) throws Exception;
}