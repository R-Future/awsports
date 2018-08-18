package com.awsports.mapper;

import com.awsports.pojo.AwApikey;
import com.awsports.pojo.AwApikeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwApikeyMapper {
    long countByExample(AwApikeyExample example);

    int deleteByExample(AwApikeyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwApikey record);

    int insertSelective(AwApikey record);

    List<AwApikey> selectByExample(AwApikeyExample example);

    AwApikey selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwApikey record, @Param("example") AwApikeyExample example);

    int updateByExample(@Param("record") AwApikey record, @Param("example") AwApikeyExample example);

    int updateByPrimaryKeySelective(AwApikey record);

    int updateByPrimaryKey(AwApikey record);
}