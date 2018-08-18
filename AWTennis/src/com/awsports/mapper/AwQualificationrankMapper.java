package com.awsports.mapper;

import com.awsports.pojo.AwQualificationrank;
import com.awsports.pojo.AwQualificationrankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwQualificationrankMapper {
    long countByExample(AwQualificationrankExample example);

    int deleteByExample(AwQualificationrankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwQualificationrank record);

    int insertSelective(AwQualificationrank record);

    List<AwQualificationrank> selectByExampleWithBLOBs(AwQualificationrankExample example);

    List<AwQualificationrank> selectByExample(AwQualificationrankExample example);

    AwQualificationrank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwQualificationrank record, @Param("example") AwQualificationrankExample example);

    int updateByExampleWithBLOBs(@Param("record") AwQualificationrank record, @Param("example") AwQualificationrankExample example);

    int updateByExample(@Param("record") AwQualificationrank record, @Param("example") AwQualificationrankExample example);

    int updateByPrimaryKeySelective(AwQualificationrank record);

    int updateByPrimaryKeyWithBLOBs(AwQualificationrank record);

    int updateByPrimaryKey(AwQualificationrank record);
}