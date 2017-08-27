package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Qualificationrank;
import com.awsports.pojo.QualificationrankQuery;

@Service
public interface QualificationrankService {
	public List<QualificationrankQuery> findAll(QualificationrankQuery qualificationrankQuery) throws Exception;
    public Qualificationrank findById(Integer id) throws Exception;
    public Qualificationrank findByUseridTournamentidYear(Qualificationrank qualificationrank) throws Exception;
    public void deleteById(Integer id) throws Exception;
    public void insertOne(Qualificationrank qualificationrank) throws Exception;
    public void updateById(Qualificationrank qualificationrank) throws Exception;
}
