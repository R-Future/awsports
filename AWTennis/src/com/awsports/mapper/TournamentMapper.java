package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Tournament;
import com.awsports.pojo.TournamentQuery;

public interface TournamentMapper {
	public List<TournamentQuery> findAll(TournamentQuery tournamentQuery) throws Exception;
	public Tournament findById(Integer id) throws Exception;
	public void updateById(Tournament tournament) throws Exception;
	public void insertOne(Tournament tournament) throws Exception;
	public void deleteById(Integer id) throws Exception;
}
