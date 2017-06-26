package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Individualrank;
import com.awsports.pojo.IndividualrankQuery;

public interface IndividualrankMapper {
    public List<IndividualrankQuery> findAll(IndividualrankQuery individualrankQuery) throws Exception;
    public Individualrank findById(Integer id) throws Exception;
    public void insertOne(Individualrank individualrank) throws Exception;
    public void updateById(Individualrank indiviudalrank) throws Exception;
    public void deleteById(Integer id) throws Exception;
    public Individualrank findByUseridEntry(Individualrank individualrank) throws Exception;
}