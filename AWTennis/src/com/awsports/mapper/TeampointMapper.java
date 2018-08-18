package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Teampoint;
import com.awsports.pojo.TeampointQuery;

public interface TeampointMapper {
    public List<TeampointQuery> findAll(TeampointQuery teampointQuery) throws Exception;
    public Teampoint findById(Integer id) throws Exception;
    public Teampoint findByTeamidYearWeekTournamentidEntry(Teampoint teampoint) throws Exception;
    public void insertOne(Teampoint teampoint) throws Exception;
    public void updateById(Teampoint teampoint) throws Exception;
    public void deleteById(Integer id) throws Exception;
    public List<Teampoint> findByEntryYearWeek(Teampoint teampoint) throws Exception;
    public List<Teampoint> findByTournamentid(Teampoint teampoint) throws Exception;
    public List<Teampoint> findByTeamidYearWeekTournamentid(Teampoint teampoint) throws Exception;
}