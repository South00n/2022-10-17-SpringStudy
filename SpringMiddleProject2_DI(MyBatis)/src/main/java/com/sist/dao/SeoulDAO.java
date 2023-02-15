package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.mapper.*;

import lombok.Setter;

public class SeoulDAO {
	// 사용해야되니까 매퍼에서 끌어와
	@Setter
	private SeoulMapper mapper;
	
	//@Select("SELECT no, title, msg, address FROM ${seoul_tbl}")
	public List<SeoulVO> seoulListData(Map map) {
		return mapper.seoulListData(map);
	}
	
	//@Select("SELECT no, title, msg, address FROM ${seoul_tbl} "
			//+ "WHERE no=#{no}")
	public SeoulVO seoulDetailData(Map map) {
		return mapper.seoulDetailData(map);
	}
}
