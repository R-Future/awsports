package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.TournamentMapper;
import com.awsports.pojo.Tournament;
import com.awsports.pojo.TournamentQuery;
import com.awsports.service.TournamentService;

public class TournamentServiceImpl implements TournamentService {

	@Autowired
	private TournamentMapper tournamentMapper;
	
	@Override
	public List<TournamentQuery> findAll(TournamentQuery tournamentQuery) throws Exception {
		// TODO Auto-generated method stub
		return tournamentMapper.findAll(tournamentQuery);
	}

	@Override
	public Tournament findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return tournamentMapper.findById(id);
	}

	@Override
	public void updateById(Tournament tournament) throws Exception {
		// TODO Auto-generated method stub
		tournamentMapper.updateById(tournament);
	}

	@Override
	public void insertOne(Tournament tournament) throws Exception {
		// TODO Auto-generated method stub
		tournamentMapper.insertOne(tournament);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		tournamentMapper.deleteById(id);
	}

	@Override
	public TournamentQuery findDetailById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return tournamentMapper.findDetailById(id);
	}

	@Override
	public Tournament findByName(Tournament tournament) throws Exception {
		// TODO Auto-generated method stub
		return tournamentMapper.findByName(tournament);
	}


}
