package com.awsports.mapper;

import com.awsports.pojo.AwLevel;
import com.awsports.pojo.AwLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwLevelMapper {
    long countByExample(AwLevelExample example);

    int deleteByExample(AwLevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwLevel record);

    int insertSelective(AwLevel record);

    List<AwLevel> selectByExampleWithBLOBs(AwLevelExample example);

    List<AwLevel> selectByExample(AwLevelExample example);

    AwLevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwLevel record, @Param("example") AwLevelExample example);

    int updateByExampleWithBLOBs(@Param("record") AwLevel record, @Param("example") AwLevelExample example);

    int updateByExample(@Param("record") AwLevel record, @Param("example") AwLevelExample example);

    int updateByPrimaryKeySelective(AwLevel record);

    int updateByPrimaryKeyWithBLOBs(AwLevel record);

    int updateByPrimaryKey(AwLevel record);
}