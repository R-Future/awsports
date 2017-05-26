package com.awsports.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.awsports.mapper.ArenaMapper;
import com.awsports.pojo.Arena;
import com.awsports.service.ArenaService;

public class ArenaServiceImpl implements ArenaService {
	
	@Autowired
	private ArenaMapper arenaMapper;

	@Override
	public List<Arena> findAll(Arena arena) throws Exception {
		// TODO Auto-generated method stub
		return arenaMapper.findAll(arena);
	}

	@Override
	public Arena findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return arenaMapper.findById(id);
	}

	@Override
	public void updateById(Arena arena) throws Exception {
		// TODO Auto-generated method stub
		arenaMapper.updateById(arena);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		arenaMapper.deleteById(id);
	}

}
