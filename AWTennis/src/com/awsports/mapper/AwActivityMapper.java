package com.awsports.mapper;

import com.awsports.pojo.AwActivity;
import com.awsports.pojo.AwActivityExample;
import com.awsports.pojo.AwActivityWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwActivityMapper {
    long countByExample(AwActivityExample example);

    int deleteByExample(AwActivityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwActivityWithBLOBs record);

    int insertSelective(AwActivityWithBLOBs record);

    List<AwActivityWithBLOBs> selectByExampleWithBLOBs(AwActivityExample example);

    List<AwActivity> selectByExample(AwActivityExample example);

    AwActivityWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwActivityWithBLOBs record, @Param("example") AwActivityExample example);

    int updateByExampleWithBLOBs(@Param("record") AwActivityWithBLOBs record, @Param("example") AwActivityExample example);

    int updateByExample(@Param("record") AwActivity record, @Param("example") AwActivityExample example);

    int updateByPrimaryKeySelective(AwActivityWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AwActivityWithBLOBs record);

    int updateByPrimaryKey(AwActivity record);
}