package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Level;

public interface LevelMapper {
    public List<Level> findAll(Level level) throws Exception;
    public Level findById(Integer id) throws Exception;
    public void updateById(Level level) throws Exception;
    public void insertOne(Level level) throws Exception;
    public void deleteById(Integer id) throws Exception;
}