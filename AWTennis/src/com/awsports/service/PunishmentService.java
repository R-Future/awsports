package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Punishment;
import com.awsports.pojo.PunishmentQuery;

@Service
public interface PunishmentService {
	public List<PunishmentQuery> findAll(PunishmentQuery punishmentQuery) throws Exception;
    public Punishment findById(Integer id) throws Exception;
    public void updateById(Punishment punishment) throws Exception;
    public void insertOne(Punishment punishment) throws Exception;
    public void deleteById(Integer id) throws Exception;
}
