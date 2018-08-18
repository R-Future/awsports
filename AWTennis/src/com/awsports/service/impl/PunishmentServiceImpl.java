package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.PunishmentMapper;
import com.awsports.pojo.Punishment;
import com.awsports.pojo.PunishmentQuery;
import com.awsports.service.PunishmentService;

public class PunishmentServiceImpl implements PunishmentService {

	@Autowired
	private PunishmentMapper punishmentMapper;
	
	@Override
	public List<PunishmentQuery> findAll(PunishmentQuery punishmentQuery) throws Exception {
		// TODO Auto-generated method stub
		return punishmentMapper.findAll(punishmentQuery);
	}

	@Override
	public Punishment findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return punishmentMapper.findById(id);
	}

	@Override
	public void updateById(Punishment punishment) throws Exception {
		// TODO Auto-generated method stub
		punishmentMapper.updateById(punishment);
	}

	@Override
	public void insertOne(Punishment punishment) throws Exception {
		// TODO Auto-generated method stub
		punishmentMapper.insertOne(punishment);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		punishmentMapper.deleteById(id);
	}

	@Override
	public Integer findSumByUseridEntry(Punishment punishment) throws Exception {
		// TODO Auto-generated method stub
		return punishmentMapper.findSumByUseridEntry(punishment);
	}

	@Override
	public Integer findSumByUseridTournamentidYear(Punishment punishment) throws Exception {
		// TODO Auto-generated method stub
		return punishmentMapper.findSumByUseridTournamentidYear(punishment);
	}

	@Override
	public Integer findSumByUseridEntryMatchtime(Punishment punishment) throws Exception {
		// TODO Auto-generated method stub
		return punishmentMapper.findSumByUseridEntryMatchtime(punishment);
	}

}
