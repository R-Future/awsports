package com.awsports.mapper;

import com.awsports.pojo.AwSinglematchscore;
import com.awsports.pojo.AwSinglematchscoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwSinglematchscoreMapper {
    long countByExample(AwSinglematchscoreExample example);

    int deleteByExample(AwSinglematchscoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwSinglematchscore record);

    int insertSelective(AwSinglematchscore record);

    List<AwSinglematchscore> selectByExampleWithBLOBs(AwSinglematchscoreExample example);

    List<AwSinglematchscore> selectByExample(AwSinglematchscoreExample example);

    AwSinglematchscore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwSinglematchscore record, @Param("example") AwSinglematchscoreExample example);

    int updateByExampleWithBLOBs(@Param("record") AwSinglematchscore record, @Param("example") AwSinglematchscoreExample example);

    int updateByExample(@Param("record") AwSinglematchscore record, @Param("example") AwSinglematchscoreExample example);

    int updateByPrimaryKeySelective(AwSinglematchscore record);

    int updateByPrimaryKeyWithBLOBs(AwSinglematchscore record);

    int updateByPrimaryKey(AwSinglematchscore record);
}