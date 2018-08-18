package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.PointruleMapper;
import com.awsports.pojo.Pointrule;
import com.awsports.service.PointruleService;

public class PointruleServiceImpl implements PointruleService {

	@Autowired
	private PointruleMapper pointruleMapper;
	
	@Override
	public List<Pointrule> findByTournamentId(Integer tournamentid) throws Exception {
		// TODO Auto-generated method stub
		return pointruleMapper.findByTournamentId(tournamentid);
	}

	@Override
	public void insertOne(Pointrule pointrule) throws Exception {
		// TODO Auto-generated method stub
		pointruleMapper.insertOne(pointrule);
	}

	@Override
	public void updateById(Pointrule pointrule) throws Exception {
		// TODO Auto-generated method stub
		pointruleMapper.updateById(pointrule);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		pointruleMapper.deleteById(id);
	}

	@Override
	public Pointrule findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return pointruleMapper.findById(id);
	}

	@Override
	public Pointrule findByTournamentIdAndRound(Pointrule pointrule) throws Exception {
		// TODO Auto-generated method stub
		return pointruleMapper.findByTournamentIdAndRound(pointrule);
	}

}
