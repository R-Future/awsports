package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.DoublesMatchMapper;
import com.awsports.pojo.DoublesMatch;
import com.awsports.pojo.DoublesMatchQuery;
import com.awsports.service.DoublesMatchService;
import com.awsports.util.MatchUtil;

public class DoublesMatchServiceImpl implements DoublesMatchService {

	@Autowired
	private DoublesMatchMapper doublesMatchMapper;
	
	@Override
	public DoublesMatch findById(Integer id) throws Exception {
		return doublesMatchMapper.findById(id);
	}

	@Override
	public List<DoublesMatchQuery> findByEventId(Integer eventId) throws Exception {
		return doublesMatchMapper.findByEventId(eventId);
	}

	@Override
	public List<DoublesMatchQuery> findByConditions(DoublesMatch doublesMatch) throws Exception {
		return doublesMatchMapper.findByConditions(doublesMatch);
	}

	@Override
	public void insertOne(DoublesMatch doublesMatch) throws Exception {
		//set mirror match
		DoublesMatch mirrorMatch = new DoublesMatch();
		//save
		doublesMatchMapper.insertOne(doublesMatch);
		doublesMatchMapper.insertOne(MatchUtil.setMirrorMatch(doublesMatch, mirrorMatch));
	}

	@Override
	public void updateById(DoublesMatch doublesMatch) throws Exception {
		//set mirror match
		DoublesMatch mirrorMatch = doublesMatchMapper.findMirrorMatchByOrigin(doublesMatch);
		//save
		doublesMatchMapper.updateById(doublesMatch);
		doublesMatchMapper.updateById(MatchUtil.setMirrorMatch(doublesMatch, mirrorMatch));
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		doublesMatchMapper.deleteById(id);
	}

	@Override
	public void deleteByMirror(String mirror) throws Exception {
		doublesMatchMapper.deleteByMirror(mirror);
	}

	@Override
	public void deleteByEventId(Integer eventId) throws Exception {
		doublesMatchMapper.deleteByEventId(eventId);
	}

}
