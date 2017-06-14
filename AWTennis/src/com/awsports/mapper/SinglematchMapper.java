package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Singlematch;
import com.awsports.pojo.SinglematchQuery;

public interface SinglematchMapper {

	public List<SinglematchQuery> findAll(SinglematchQuery singlematchQuery) throws Exception;
	public void insertOne(Singlematch sinlematch) throws Exception;
	public Singlematch findById(Integer id) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public void updateById(Singlematch singlematch) throws Exception;
	public Singlematch findMirrorByOrigin(Singlematch singlematch) throws Exception;
	
}
