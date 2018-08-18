package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Individualrankest;
import com.awsports.pojo.IndividualrankestQuery;
import com.awsports.pojo.User;

@Service
public interface IndividualrankestService {
	public List<IndividualrankestQuery> findAll(IndividualrankestQuery individualrankestQuery) throws Exception;
    public Individualrankest findById(Integer id) throws Exception;
    public void insertOne(Individualrankest individualrankest) throws Exception;
    public void updateById(Individualrankest individualrankest) throws Exception;
    public void deleteById(Integer id) throws Exception;
    public Individualrankest findByUseridEntry(Individualrankest individualrankest) throws Exception;
    public List<Individualrankest> findByUser(User user) throws Exception;
}
