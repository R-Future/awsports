package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.TeampointMapper;
import com.awsports.pojo.Teampoint;
import com.awsports.pojo.TeampointQuery;
import com.awsports.service.TeampointService;

public class TeampointServiceImpl implements TeampointService {

	@Autowired
	private TeampointMapper teampointMapper;
	@Override
	public List<TeampointQuery> findAll(TeampointQuery teampointQuery) throws Exception {
		// TODO Auto-generated method stub
		return teampointMapper.findAll(teampointQuery);
	}

	@Override
	public Teampoint findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return teampointMapper.findById(id);
	}

	@Override
	public Teampoint findByTeamidYearWeekEntry(Teampoint teampoint) throws Exception {
		// TODO Auto-generated method stub
		return teampointMapper.findByTeamidYearWeekEntry(teampoint);
	}

	@Override
	public void insertOne(Teampoint teampoint) throws Exception {
		// TODO Auto-generated method stub
		teampointMapper.insertOne(teampoint);
	}

	@Override
	public void updateById(Teampoint teampoint) throws Exception {
		// TODO Auto-generated method stub
		teampointMapper.updateById(teampoint);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		teampointMapper.deleteById(id);
	}

	@Override
	public List<Teampoint> findByEntryYearWeek(Teampoint teampoint) throws Exception {
		// TODO Auto-generated method stub
		return teampointMapper.findByEntryYearWeek(teampoint);
	}

	@Override
	public List<Teampoint> findByTournamentid(Teampoint teampoint) throws Exception {
		// TODO Auto-generated method stub
		return teampointMapper.findByTournamentid(teampoint);
	}

}
