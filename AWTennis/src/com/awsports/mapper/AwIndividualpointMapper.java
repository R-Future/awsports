package com.awsports.mapper;

import com.awsports.pojo.AwIndividualpoint;
import com.awsports.pojo.AwIndividualpointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwIndividualpointMapper {
    long countByExample(AwIndividualpointExample example);

    int deleteByExample(AwIndividualpointExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwIndividualpoint record);

    int insertSelective(AwIndividualpoint record);

    List<AwIndividualpoint> selectByExampleWithBLOBs(AwIndividualpointExample example);

    List<AwIndividualpoint> selectByExample(AwIndividualpointExample example);

    AwIndividualpoint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwIndividualpoint record, @Param("example") AwIndividualpointExample example);

    int updateByExampleWithBLOBs(@Param("record") AwIndividualpoint record, @Param("example") AwIndividualpointExample example);

    int updateByExample(@Param("record") AwIndividualpoint record, @Param("example") AwIndividualpointExample example);

    int updateByPrimaryKeySelective(AwIndividualpoint record);

    int updateByPrimaryKeyWithBLOBs(AwIndividualpoint record);

    int updateByPrimaryKey(AwIndividualpoint record);
}