package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Individualpoint;
import com.awsports.pojo.IndividualpointQuery;

@Service
public interface IndividualpointService {

	public List<IndividualpointQuery> findAll(IndividualpointQuery individualpointQuery) throws Exception;
	public Individualpoint findById(Integer id) throws Exception;
	public void insertOne(Individualpoint individualpoint) throws Exception;
	public void updateById(Individualpoint individualpoint) throws Exception;
	public void deleteById(Integer id) throws Exception;
	public Individualpoint findByUseridYearWeekTournamentidEntry(Individualpoint individualpoint) throws Exception;
	public List<Individualpoint> findByEntryYearWeek(Individualpoint individualpoint) throws Exception;
	public List<Individualpoint> findByTournamentidYear(Individualpoint individualpoint) throws Exception;
	public List<Individualpoint> findByUseridYearWeekTournamentid(Individualpoint individualpoint) throws Exception;
}
