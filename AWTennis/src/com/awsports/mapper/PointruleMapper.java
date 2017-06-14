package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Pointrule;

public interface PointruleMapper {
	
	public List<Pointrule> findByTournamentId(Integer tournamentid) throws Exception;
	public Pointrule findById(Integer id) throws Exception;
	public Pointrule findByTournamentIdAndRound(Pointrule pointrule) throws Exception;
	public void insertOne(Pointrule pointrule) throws Exception;
	public void updateById(Pointrule pointrule) throws Exception;
	public void deleteById(Integer id) throws Exception;

}
