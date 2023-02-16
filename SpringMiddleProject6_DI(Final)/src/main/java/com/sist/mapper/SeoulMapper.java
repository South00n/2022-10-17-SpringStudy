package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface SeoulMapper {
	@Select("SELECT no, title, address FROM ${seoul_tbl}")
	public List<SeoulVO> SeoulListData(Map map);
}
