package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Individualrank;
import com.awsports.pojo.IndividualrankQuery;

@Service
public interface IndividualrankService {
	public List<IndividualrankQuery> findAll(IndividualrankQuery individualrankQuery) throws Exception;
    public Individualrank findById(Integer id) throws Exception;
    public void insertOne(Individualrank individualrank) throws Exception;
    public void updateById(Individualrank indiviudalrank) throws Exception;
    public void deleteById(Integer id) throws Exception;
    public List<Individualrank> findByUseridEntry(Individualrank individualrank) throws Exception;
    public Individualrank findByUseridEntryYear(Individualrank individualrank) throws Exception;
}
