package com.awsports.mapper;

import com.awsports.pojo.AwDoublematch;
import com.awsports.pojo.AwDoublematchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwDoublematchMapper {
    long countByExample(AwDoublematchExample example);

    int deleteByExample(AwDoublematchExample example);

    int insert(AwDoublematch record);

    int insertSelective(AwDoublematch record);

    List<AwDoublematch> selectByExampleWithBLOBs(AwDoublematchExample example);

    List<AwDoublematch> selectByExample(AwDoublematchExample example);

    int updateByExampleSelective(@Param("record") AwDoublematch record, @Param("example") AwDoublematchExample example);

    int updateByExampleWithBLOBs(@Param("record") AwDoublematch record, @Param("example") AwDoublematchExample example);

    int updateByExample(@Param("record") AwDoublematch record, @Param("example") AwDoublematchExample example);
}