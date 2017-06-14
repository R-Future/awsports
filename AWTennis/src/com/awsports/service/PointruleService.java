package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Pointrule;

@Service
public interface PointruleService {

	public List<Pointrule> findByTournamentId(Integer tournamentid) throws Exception;
	public Pointrule findById(Integer id) throws Exception;
	public Pointrule findByTournamentIdAndRound(Pointrule pointrule) throws Exception;
	public void insertOne(Pointrule pointrule) throws Exception;
	public void updateById(Pointrule pointrule) throws Exception;
	public void deleteById(Integer id) throws Exception;
}
