package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Doublematchscore;

public interface DoublematchscoreMapper {
    public List<Doublematchscore> findByMatchid(Integer matchid) throws Exception;
    public void insertOne(Doublematchscore doublematchscore) throws Exception;
    public void updateById(Doublematchscore doublematchscore) throws Exception;
    public void deleteByMatchid(Integer matchid) throws Exception;
}