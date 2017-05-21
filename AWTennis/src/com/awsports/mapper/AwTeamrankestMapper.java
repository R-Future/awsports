package com.awsports.mapper;

import com.awsports.pojo.AwTeamrankest;
import com.awsports.pojo.AwTeamrankestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwTeamrankestMapper {
    long countByExample(AwTeamrankestExample example);

    int deleteByExample(AwTeamrankestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwTeamrankest record);

    int insertSelective(AwTeamrankest record);

    List<AwTeamrankest> selectByExampleWithBLOBs(AwTeamrankestExample example);

    List<AwTeamrankest> selectByExample(AwTeamrankestExample example);

    AwTeamrankest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwTeamrankest record, @Param("example") AwTeamrankestExample example);

    int updateByExampleWithBLOBs(@Param("record") AwTeamrankest record, @Param("example") AwTeamrankestExample example);

    int updateByExample(@Param("record") AwTeamrankest record, @Param("example") AwTeamrankestExample example);

    int updateByPrimaryKeySelective(AwTeamrankest record);

    int updateByPrimaryKeyWithBLOBs(AwTeamrankest record);

    int updateByPrimaryKey(AwTeamrankest record);
}