package com.awsports.mapper;

import com.awsports.pojo.AwSinglematch;
import com.awsports.pojo.AwSinglematchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwSinglematchMapper {
    long countByExample(AwSinglematchExample example);

    int deleteByExample(AwSinglematchExample example);

    int insert(AwSinglematch record);

    int insertSelective(AwSinglematch record);

    List<AwSinglematch> selectByExampleWithBLOBs(AwSinglematchExample example);

    List<AwSinglematch> selectByExample(AwSinglematchExample example);

    int updateByExampleSelective(@Param("record") AwSinglematch record, @Param("example") AwSinglematchExample example);

    int updateByExampleWithBLOBs(@Param("record") AwSinglematch record, @Param("example") AwSinglematchExample example);

    int updateByExample(@Param("record") AwSinglematch record, @Param("example") AwSinglematchExample example);
}