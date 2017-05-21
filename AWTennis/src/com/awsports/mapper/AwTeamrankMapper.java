package com.awsports.mapper;

import com.awsports.pojo.AwTeamrank;
import com.awsports.pojo.AwTeamrankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwTeamrankMapper {
    long countByExample(AwTeamrankExample example);

    int deleteByExample(AwTeamrankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwTeamrank record);

    int insertSelective(AwTeamrank record);

    List<AwTeamrank> selectByExampleWithBLOBs(AwTeamrankExample example);

    List<AwTeamrank> selectByExample(AwTeamrankExample example);

    AwTeamrank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwTeamrank record, @Param("example") AwTeamrankExample example);

    int updateByExampleWithBLOBs(@Param("record") AwTeamrank record, @Param("example") AwTeamrankExample example);

    int updateByExample(@Param("record") AwTeamrank record, @Param("example") AwTeamrankExample example);

    int updateByPrimaryKeySelective(AwTeamrank record);

    int updateByPrimaryKeyWithBLOBs(AwTeamrank record);

    int updateByPrimaryKey(AwTeamrank record);
}