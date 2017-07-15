package com.awsports.mapper;

import com.awsports.pojo.Punishment;
import com.awsports.pojo.PunishmentQuery;

import java.util.List;

public interface PunishmentMapper {
    public List<PunishmentQuery> findAll(PunishmentQuery punishmentQuery) throws Exception;
    public Punishment findById(Integer id) throws Exception;
    public Integer findSumByUseridEntry(Punishment punishment) throws Exception;
    public Integer findSumByUseridTournamentidYear(Punishment punishment) throws Exception;
    public void updateById(Punishment punishment) throws Exception;
    public void insertOne(Punishment punishment) throws Exception;
    public void deleteById(Integer id) throws Exception;
}