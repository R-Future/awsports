package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.QualificationrankMapper;
import com.awsports.pojo.Qualificationrank;
import com.awsports.pojo.QualificationrankQuery;
import com.awsports.service.QualificationrankService;

public class QualificationrankServiceImpl implements QualificationrankService {

	@Autowired
	private QualificationrankMapper qualificationrankMapper;
	@Override
	public List<QualificationrankQuery> findAll(QualificationrankQuery qualificationrankQuery) throws Exception {
		// TODO Auto-generated method stub
		return qualificationrankMapper.findAll(qualificationrankQuery);
	}

	@Override
	public Qualificationrank findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return qualificationrankMapper.findById(id);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		qualificationrankMapper.deleteById(id);
	}

	@Override
	public void insertOne(Qualificationrank qualificationrank) throws Exception {
		// TODO Auto-generated method stub
		qualificationrankMapper.insertOne(qualificationrank);
	}

	@Override
	public void updateById(Qualificationrank qualificationrank) throws Exception {
		// TODO Auto-generated method stub
		qualificationrankMapper.updateById(qualificationrank);
	}

	@Override
	public Qualificationrank findByUseridTournamentidYear(Qualificationrank qualificationrank) throws Exception {
		// TODO Auto-generated method stub
		return qualificationrankMapper.findByUseridTournamentidYear(qualificationrank);
	}

}
