package com.awsports.mapper;

import com.awsports.pojo.AwEventWorker;
import com.awsports.pojo.AwEventWorkerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwEventWorkerMapper {
    long countByExample(AwEventWorkerExample example);

    int deleteByExample(AwEventWorkerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwEventWorker record);

    int insertSelective(AwEventWorker record);

    List<AwEventWorker> selectByExampleWithBLOBs(AwEventWorkerExample example);

    List<AwEventWorker> selectByExample(AwEventWorkerExample example);

    AwEventWorker selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwEventWorker record, @Param("example") AwEventWorkerExample example);

    int updateByExampleWithBLOBs(@Param("record") AwEventWorker record, @Param("example") AwEventWorkerExample example);

    int updateByExample(@Param("record") AwEventWorker record, @Param("example") AwEventWorkerExample example);

    int updateByPrimaryKeySelective(AwEventWorker record);

    int updateByPrimaryKeyWithBLOBs(AwEventWorker record);

    int updateByPrimaryKey(AwEventWorker record);
}