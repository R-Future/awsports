package com.awsports.mapper;

import com.awsports.pojo.Individualrankest;
import com.awsports.pojo.IndividualrankestQuery;

public interface IndividualrankestMapper {
    public IndividualrankestQuery findAll(IndividualrankestQuery individualrankestQuery) throws Exception;
    public Individualrankest findById(Integer id) throws Exception;
    public void insertOne(Individualrankest individualrankest) throws Exception;
    public void updateById(Individualrankest individualrankest) throws Exception;
    public void deleteById(Integer id) throws Exception;
    public Individualrankest findByUseridEntry(Individualrankest individualrankest) throws Exception;
}