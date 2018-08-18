package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Doublematch;
import com.awsports.pojo.DoublematchQuery;
import com.awsports.pojo.User;

@Service
public interface DoublematchService {
	public List<DoublematchQuery> findAll(DoublematchQuery doublematchQuery) throws Exception;
	public List<DoublematchQuery> findByUser(User user) throws Exception;
	public Doublematch findById(Integer id) throws Exception;
	public Doublematch findMirrorByOrigin(Doublematch doublematch) throws Exception;
	public void insertOne(Doublematch doublematch) throws Exception;
	public void updateById(Doublematch doublematch) throws Exception;
	public void deleteById(Integer id) throws Exception;
}
