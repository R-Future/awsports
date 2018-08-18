package com.awsports.mapper;

import com.awsports.pojo.AwUser;
import com.awsports.pojo.AwUserExample;
import com.awsports.pojo.AwUserKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwUserMapper {
    long countByExample(AwUserExample example);

    int deleteByExample(AwUserExample example);

    int deleteByPrimaryKey(AwUserKey key);

    int insert(AwUser record);

    int insertSelective(AwUser record);

    List<AwUser> selectByExample(AwUserExample example);

    AwUser selectByPrimaryKey(AwUserKey key);

    int updateByExampleSelective(@Param("record") AwUser record, @Param("example") AwUserExample example);

    int updateByExample(@Param("record") AwUser record, @Param("example") AwUserExample example);

    int updateByPrimaryKeySelective(AwUser record);

    int updateByPrimaryKey(AwUser record);
}