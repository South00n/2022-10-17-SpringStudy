package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.SeoulMapper;
import com.sist.vo.FoodVO;
import com.sist.vo.SeoulLocationVO;

@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
	
	/*
	@Select("SELECT poster, title, msg, address "
	+ "FROM seoul_location")
	 */
	public List<SeoulLocationVO> seoulListData(Map map) {
		return mapper.seoulListData(map);
	}
	
	// @Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_location")
	public int seoulTotalPage() {
		return mapper.seoulTotalPage();
	}
	
	/*@Select("SELECT no, poster, title, msg, address "
			+ "FROM seoul_location")*/
	public SeoulLocationVO seoulDetailData(int no) {
		return mapper.seoulDetailData(no);
	}
	
	/*@Select("SELECT fno, name, poster, rownum "
			+ "FROM food_location "
			+ "WHERE rownum <= 4 AND address LIKE '%'||#{addr}||'%'")*/
	public List<FoodVO> SeoulFoodData(Map map) {
		return mapper.SeoulFoodData(map);
	}
}
