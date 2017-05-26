package com.awsports.mapper;

import java.util.List;

import com.awsports.pojo.Arena;

public interface ArenaMapper {
	public List<Arena> findAll(Arena arena) throws Exception;
	public Arena findById(Integer id) throws Exception;
	public void updateById(Arena arena) throws Exception;
	public void deleteById(Integer id) throws Exception;
}
