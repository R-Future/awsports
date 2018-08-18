package com.awsports.mapper;

import com.awsports.pojo.AwEvent;
import com.awsports.pojo.AwEventExample;
import com.awsports.pojo.AwEventWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwEventMapper {
    long countByExample(AwEventExample example);

    int deleteByExample(AwEventExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwEventWithBLOBs record);

    int insertSelective(AwEventWithBLOBs record);

    List<AwEventWithBLOBs> selectByExampleWithBLOBs(AwEventExample example);

    List<AwEvent> selectByExample(AwEventExample example);

    AwEventWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwEventWithBLOBs record, @Param("example") AwEventExample example);

    int updateByExampleWithBLOBs(@Param("record") AwEventWithBLOBs record, @Param("example") AwEventExample example);

    int updateByExample(@Param("record") AwEvent record, @Param("example") AwEventExample example);

    int updateByPrimaryKeySelective(AwEventWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AwEventWithBLOBs record);

    int updateByPrimaryKey(AwEvent record);
}