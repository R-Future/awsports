package com.awsports.mapper;

import com.awsports.pojo.AwArena;
import com.awsports.pojo.AwArenaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwArenaMapper {
    long countByExample(AwArenaExample example);

    int deleteByExample(AwArenaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwArena record);

    int insertSelective(AwArena record);

    List<AwArena> selectByExampleWithBLOBs(AwArenaExample example);

    List<AwArena> selectByExample(AwArenaExample example);

    AwArena selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwArena record, @Param("example") AwArenaExample example);

    int updateByExampleWithBLOBs(@Param("record") AwArena record, @Param("example") AwArenaExample example);

    int updateByExample(@Param("record") AwArena record, @Param("example") AwArenaExample example);

    int updateByPrimaryKeySelective(AwArena record);

    int updateByPrimaryKeyWithBLOBs(AwArena record);

    int updateByPrimaryKey(AwArena record);
}