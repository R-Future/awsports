package com.awsports.mapper;

import com.awsports.pojo.AwTeampoint;
import com.awsports.pojo.AwTeampointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwTeampointMapper {
    long countByExample(AwTeampointExample example);

    int deleteByExample(AwTeampointExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwTeampoint record);

    int insertSelective(AwTeampoint record);

    List<AwTeampoint> selectByExampleWithBLOBs(AwTeampointExample example);

    List<AwTeampoint> selectByExample(AwTeampointExample example);

    AwTeampoint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwTeampoint record, @Param("example") AwTeampointExample example);

    int updateByExampleWithBLOBs(@Param("record") AwTeampoint record, @Param("example") AwTeampointExample example);

    int updateByExample(@Param("record") AwTeampoint record, @Param("example") AwTeampointExample example);

    int updateByPrimaryKeySelective(AwTeampoint record);

    int updateByPrimaryKeyWithBLOBs(AwTeampoint record);

    int updateByPrimaryKey(AwTeampoint record);
}