package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Doublematch;
import com.awsports.pojo.DoublematchQuery;
import com.awsports.pojo.User;

public interface DoublematchMapper {
	public List<DoublematchQuery> findAll(DoublematchQuery doublematchQuery) throws Exception;
	/**
	 * 
	 * @Author: peRFect
	 * @Datetime: 2017年11月18日 下午9:17:49
	 * @param user
	 * @throws Exception
	 * @Return: List<DoublematchQuery>
	 * @Description: find by user1 in hc team and user2 in ap team
	 *
	 */
	public List<DoublematchQuery> findByUser(User user) throws Exception;
	public Doublematch findById(Integer id) throws Exception;
	public Doublematch findMirrorByOrigin(Doublematch doublematch) throws Exception;
	public void insertOne(Doublematch doublematch) throws Exception;
	public void updateById(Doublematch doublematch) throws Exception;
	public void deleteById(Integer id) throws Exception;
}