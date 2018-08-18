package com.awsports.mapper;

import com.awsports.pojo.AwIndividualrank;
import com.awsports.pojo.AwIndividualrankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwIndividualrankMapper {
    long countByExample(AwIndividualrankExample example);

    int deleteByExample(AwIndividualrankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwIndividualrank record);

    int insertSelective(AwIndividualrank record);

    List<AwIndividualrank> selectByExampleWithBLOBs(AwIndividualrankExample example);

    List<AwIndividualrank> selectByExample(AwIndividualrankExample example);

    AwIndividualrank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwIndividualrank record, @Param("example") AwIndividualrankExample example);

    int updateByExampleWithBLOBs(@Param("record") AwIndividualrank record, @Param("example") AwIndividualrankExample example);

    int updateByExample(@Param("record") AwIndividualrank record, @Param("example") AwIndividualrankExample example);

    int updateByPrimaryKeySelective(AwIndividualrank record);

    int updateByPrimaryKeyWithBLOBs(AwIndividualrank record);

    int updateByPrimaryKey(AwIndividualrank record);
}