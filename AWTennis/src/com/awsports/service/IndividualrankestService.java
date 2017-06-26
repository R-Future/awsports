package com.awsports.service;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Individualrankest;
import com.awsports.pojo.IndividualrankestQuery;

@Service
public interface IndividualrankestService {
	 	public IndividualrankestQuery findAll(IndividualrankestQuery individualrankestQuery) throws Exception;
	    public Individualrankest findById(Integer id) throws Exception;
	    public void insertOne(Individualrankest individualrankest) throws Exception;
	    public void updateById(Individualrankest individualrankest) throws Exception;
	    public void deleteById(Integer id) throws Exception;
	    public Individualrankest findByUseridEntry(Individualrankest individualrankest) throws Exception;
}
