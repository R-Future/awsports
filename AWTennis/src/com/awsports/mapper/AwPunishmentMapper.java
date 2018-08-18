package com.awsports.mapper;

import com.awsports.pojo.AwPunishment;
import com.awsports.pojo.AwPunishmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwPunishmentMapper {
    long countByExample(AwPunishmentExample example);

    int deleteByExample(AwPunishmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwPunishment record);

    int insertSelective(AwPunishment record);

    List<AwPunishment> selectByExampleWithBLOBs(AwPunishmentExample example);

    List<AwPunishment> selectByExample(AwPunishmentExample example);

    AwPunishment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwPunishment record, @Param("example") AwPunishmentExample example);

    int updateByExampleWithBLOBs(@Param("record") AwPunishment record, @Param("example") AwPunishmentExample example);

    int updateByExample(@Param("record") AwPunishment record, @Param("example") AwPunishmentExample example);

    int updateByPrimaryKeySelective(AwPunishment record);

    int updateByPrimaryKeyWithBLOBs(AwPunishment record);

    int updateByPrimaryKey(AwPunishment record);
}