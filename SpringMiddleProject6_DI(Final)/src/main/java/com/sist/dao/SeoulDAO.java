package com.sist.dao;

import com.sist.mapper.SeoulMapper;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
// IoC
@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
	
	public List<SeoulVO> seoulListData(Map map) {
		return mapper.SeoulListData(map);
	}
}
