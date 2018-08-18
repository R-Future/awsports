package com.awsports.mapper;

import com.awsports.pojo.AwSinglesMatch;
import com.awsports.pojo.AwSinglesMatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwSinglesMatchMapper {
    long countByExample(AwSinglesMatchExample example);

    int deleteByExample(AwSinglesMatchExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwSinglesMatch record);

    int insertSelective(AwSinglesMatch record);

    List<AwSinglesMatch> selectByExampleWithBLOBs(AwSinglesMatchExample example);

    List<AwSinglesMatch> selectByExample(AwSinglesMatchExample example);

    AwSinglesMatch selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwSinglesMatch record, @Param("example") AwSinglesMatchExample example);

    int updateByExampleWithBLOBs(@Param("record") AwSinglesMatch record, @Param("example") AwSinglesMatchExample example);

    int updateByExample(@Param("record") AwSinglesMatch record, @Param("example") AwSinglesMatchExample example);

    int updateByPrimaryKeySelective(AwSinglesMatch record);

    int updateByPrimaryKeyWithBLOBs(AwSinglesMatch record);

    int updateByPrimaryKey(AwSinglesMatch record);
}