package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Teampoint;
import com.awsports.pojo.TeampointQuery;

@Service
public interface TeampointService {
	public List<TeampointQuery> findAll(TeampointQuery teampointQuery) throws Exception;
    public Teampoint findById(Integer id) throws Exception;
    public Teampoint findByTeamidYearWeekEntry(Teampoint teampoint) throws Exception;
    public void insertOne(Teampoint teampoint) throws Exception;
    public void updateById(Teampoint teampoint) throws Exception;
    public void deleteById(Integer id) throws Exception;
    public List<Teampoint> findByEntryYearWeek(Teampoint teampoint) throws Exception;
}
