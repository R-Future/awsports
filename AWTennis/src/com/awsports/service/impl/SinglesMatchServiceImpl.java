package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.SinglesMatchMapper;
import com.awsports.pojo.SinglesMatch;
import com.awsports.pojo.SinglesMatchQuery;
import com.awsports.service.SinglesMatchService;
import com.awsports.util.MatchUtil;

public class SinglesMatchServiceImpl implements SinglesMatchService {

	@Autowired
	private SinglesMatchMapper singlesMatchMapper;
	
	@Override
	public SinglesMatch findById(Integer id) throws Exception {
		return singlesMatchMapper.findById(id);
	}

	@Override
	public List<SinglesMatchQuery> findByEventId(Integer eventId) throws Exception {
		return singlesMatchMapper.findByEventId(eventId);
	}

	@Override
	public List<SinglesMatchQuery> findByConditions(SinglesMatch singlesMatch) throws Exception {
		return singlesMatchMapper.findByConditions(singlesMatch);
	}
	
	
	@Override
	public void insertOne(SinglesMatch singlesMatch) throws Exception {
		//set mirror match
		SinglesMatch mirrorMatch = new SinglesMatch();
		//save
		singlesMatchMapper.insertOne(singlesMatch);
		singlesMatchMapper.insertOne(MatchUtil.setMirrorMatch(singlesMatch, mirrorMatch));
	}

	@Override
	public void updateById(SinglesMatch singlesMatch) throws Exception {
		//set mirror match
		SinglesMatch mirrorMatch = singlesMatchMapper.findMirrorMatchByOrigin(singlesMatch);
		//update
		singlesMatchMapper.updateById(singlesMatch);
		singlesMatchMapper.updateById(MatchUtil.setMirrorMatch(singlesMatch, mirrorMatch));
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		singlesMatchMapper.deleteById(id);
	}

	@Override
	public void deleteByMirror(String mirror) throws Exception {
		singlesMatchMapper.deleteByMirror(mirror);
	}

	@Override
	public void deleteByEventId(Integer eventId) throws Exception {
		singlesMatchMapper.deleteByEventId(eventId);
	}

}
