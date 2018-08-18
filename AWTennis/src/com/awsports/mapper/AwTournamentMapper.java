package com.awsports.mapper;

import com.awsports.pojo.AwTournament;
import com.awsports.pojo.AwTournamentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwTournamentMapper {
    long countByExample(AwTournamentExample example);

    int deleteByExample(AwTournamentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwTournament record);

    int insertSelective(AwTournament record);

    List<AwTournament> selectByExampleWithBLOBs(AwTournamentExample example);

    List<AwTournament> selectByExample(AwTournamentExample example);

    AwTournament selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwTournament record, @Param("example") AwTournamentExample example);

    int updateByExampleWithBLOBs(@Param("record") AwTournament record, @Param("example") AwTournamentExample example);

    int updateByExample(@Param("record") AwTournament record, @Param("example") AwTournamentExample example);

    int updateByPrimaryKeySelective(AwTournament record);

    int updateByPrimaryKeyWithBLOBs(AwTournament record);

    int updateByPrimaryKey(AwTournament record);
}