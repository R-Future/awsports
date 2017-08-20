package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Level;

@Service
public interface LevelService {
	public List<Level> findAll(Level level) throws Exception;
    public Level findById(Integer id) throws Exception;
    public Level findByChineseName(Level level) throws Exception;
    public void updateById(Level level) throws Exception;
    public void insertOne(Level level) throws Exception;
    public void deleteById(Integer id) throws Exception;
}
