package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Doublematch;
import com.awsports.pojo.DoublematchQuery;

public interface DoublematchMapper {
	public List<DoublematchQuery> findAll(DoublematchQuery doublematchQuery) throws Exception;
	public Doublematch findById(Integer id) throws Exception;
	public Doublematch findMirrorByOrigin(Doublematch doublematch) throws Exception;
	public void insertOne(Doublematch doublematch) throws Exception;
	public void updateById(Doublematch doublematch) throws Exception;
	public void deleteById(Integer id) throws Exception;
}