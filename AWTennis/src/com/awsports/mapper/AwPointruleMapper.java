package com.awsports.mapper;

import com.awsports.pojo.AwPointrule;
import com.awsports.pojo.AwPointruleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwPointruleMapper {
    long countByExample(AwPointruleExample example);

    int deleteByExample(AwPointruleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwPointrule record);

    int insertSelective(AwPointrule record);

    List<AwPointrule> selectByExampleWithBLOBs(AwPointruleExample example);

    List<AwPointrule> selectByExample(AwPointruleExample example);

    AwPointrule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwPointrule record, @Param("example") AwPointruleExample example);

    int updateByExampleWithBLOBs(@Param("record") AwPointrule record, @Param("example") AwPointruleExample example);

    int updateByExample(@Param("record") AwPointrule record, @Param("example") AwPointruleExample example);

    int updateByPrimaryKeySelective(AwPointrule record);

    int updateByPrimaryKeyWithBLOBs(AwPointrule record);

    int updateByPrimaryKey(AwPointrule record);
}