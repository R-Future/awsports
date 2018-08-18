package com.awsports.mapper;

import com.awsports.pojo.AwIndividualrankest;
import com.awsports.pojo.AwIndividualrankestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwIndividualrankestMapper {
    long countByExample(AwIndividualrankestExample example);

    int deleteByExample(AwIndividualrankestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwIndividualrankest record);

    int insertSelective(AwIndividualrankest record);

    List<AwIndividualrankest> selectByExampleWithBLOBs(AwIndividualrankestExample example);

    List<AwIndividualrankest> selectByExample(AwIndividualrankestExample example);

    AwIndividualrankest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwIndividualrankest record, @Param("example") AwIndividualrankestExample example);

    int updateByExampleWithBLOBs(@Param("record") AwIndividualrankest record, @Param("example") AwIndividualrankestExample example);

    int updateByExample(@Param("record") AwIndividualrankest record, @Param("example") AwIndividualrankestExample example);

    int updateByPrimaryKeySelective(AwIndividualrankest record);

    int updateByPrimaryKeyWithBLOBs(AwIndividualrankest record);

    int updateByPrimaryKey(AwIndividualrankest record);
}