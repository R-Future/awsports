package com.awsports.mapper;

import com.awsports.pojo.AwTeam;
import com.awsports.pojo.AwTeamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwTeamMapper {
    long countByExample(AwTeamExample example);

    int deleteByExample(AwTeamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwTeam record);

    int insertSelective(AwTeam record);

    List<AwTeam> selectByExampleWithBLOBs(AwTeamExample example);

    List<AwTeam> selectByExample(AwTeamExample example);

    AwTeam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwTeam record, @Param("example") AwTeamExample example);

    int updateByExampleWithBLOBs(@Param("record") AwTeam record, @Param("example") AwTeamExample example);

    int updateByExample(@Param("record") AwTeam record, @Param("example") AwTeamExample example);

    int updateByPrimaryKeySelective(AwTeam record);

    int updateByPrimaryKeyWithBLOBs(AwTeam record);

    int updateByPrimaryKey(AwTeam record);
}