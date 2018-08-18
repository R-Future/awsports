package com.awsports.mapper;

import com.awsports.pojo.AwDoublesMatch;
import com.awsports.pojo.AwDoublesMatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwDoublesMatchMapper {
    long countByExample(AwDoublesMatchExample example);

    int deleteByExample(AwDoublesMatchExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwDoublesMatch record);

    int insertSelective(AwDoublesMatch record);

    List<AwDoublesMatch> selectByExampleWithBLOBs(AwDoublesMatchExample example);

    List<AwDoublesMatch> selectByExample(AwDoublesMatchExample example);

    AwDoublesMatch selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwDoublesMatch record, @Param("example") AwDoublesMatchExample example);

    int updateByExampleWithBLOBs(@Param("record") AwDoublesMatch record, @Param("example") AwDoublesMatchExample example);

    int updateByExample(@Param("record") AwDoublesMatch record, @Param("example") AwDoublesMatchExample example);

    int updateByPrimaryKeySelective(AwDoublesMatch record);

    int updateByPrimaryKeyWithBLOBs(AwDoublesMatch record);

    int updateByPrimaryKey(AwDoublesMatch record);
}