package com.awsports.mapper;

import com.awsports.pojo.AwDoublematchscore;
import com.awsports.pojo.AwDoublematchscoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwDoublematchscoreMapper {
    long countByExample(AwDoublematchscoreExample example);

    int deleteByExample(AwDoublematchscoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwDoublematchscore record);

    int insertSelective(AwDoublematchscore record);

    List<AwDoublematchscore> selectByExampleWithBLOBs(AwDoublematchscoreExample example);

    List<AwDoublematchscore> selectByExample(AwDoublematchscoreExample example);

    AwDoublematchscore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwDoublematchscore record, @Param("example") AwDoublematchscoreExample example);

    int updateByExampleWithBLOBs(@Param("record") AwDoublematchscore record, @Param("example") AwDoublematchscoreExample example);

    int updateByExample(@Param("record") AwDoublematchscore record, @Param("example") AwDoublematchscoreExample example);

    int updateByPrimaryKeySelective(AwDoublematchscore record);

    int updateByPrimaryKeyWithBLOBs(AwDoublematchscore record);

    int updateByPrimaryKey(AwDoublematchscore record);
}