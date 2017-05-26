package com.awsports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsports.pojo.Arena;

@Service
public interface ArenaService {
	public List<Arena> findAll(Arena arena) throws Exception;
	public Arena findById(Integer id) throws Exception;
	public void updateById(Arena arena) throws Exception;
	public void deleteById(Integer id) throws Exception;
}
