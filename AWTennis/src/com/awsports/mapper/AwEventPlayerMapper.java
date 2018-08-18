package com.awsports.mapper;

import com.awsports.pojo.AwEventPlayer;
import com.awsports.pojo.AwEventPlayerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwEventPlayerMapper {
    long countByExample(AwEventPlayerExample example);

    int deleteByExample(AwEventPlayerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwEventPlayer record);

    int insertSelective(AwEventPlayer record);

    List<AwEventPlayer> selectByExampleWithBLOBs(AwEventPlayerExample example);

    List<AwEventPlayer> selectByExample(AwEventPlayerExample example);

    AwEventPlayer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwEventPlayer record, @Param("example") AwEventPlayerExample example);

    int updateByExampleWithBLOBs(@Param("record") AwEventPlayer record, @Param("example") AwEventPlayerExample example);

    int updateByExample(@Param("record") AwEventPlayer record, @Param("example") AwEventPlayerExample example);

    int updateByPrimaryKeySelective(AwEventPlayer record);

    int updateByPrimaryKeyWithBLOBs(AwEventPlayer record);

    int updateByPrimaryKey(AwEventPlayer record);
}