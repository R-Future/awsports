package com.awsports.mapper;

import com.awsports.pojo.AwStatistic;
import com.awsports.pojo.AwStatisticExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwStatisticMapper {
    long countByExample(AwStatisticExample example);

    int deleteByExample(AwStatisticExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwStatistic record);

    int insertSelective(AwStatistic record);

    List<AwStatistic> selectByExampleWithBLOBs(AwStatisticExample example);

    List<AwStatistic> selectByExample(AwStatisticExample example);

    AwStatistic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwStatistic record, @Param("example") AwStatisticExample example);

    int updateByExampleWithBLOBs(@Param("record") AwStatistic record, @Param("example") AwStatisticExample example);

    int updateByExample(@Param("record") AwStatistic record, @Param("example") AwStatisticExample example);

    int updateByPrimaryKeySelective(AwStatistic record);

    int updateByPrimaryKeyWithBLOBs(AwStatistic record);

    int updateByPrimaryKey(AwStatistic record);
}