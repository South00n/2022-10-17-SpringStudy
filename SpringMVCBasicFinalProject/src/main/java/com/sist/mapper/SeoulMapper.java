package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;
import com.sist.vo.JejuFoodVO;
import com.sist.vo.SeoulLocationVO; 

public interface SeoulMapper {
	@Select("SELECT no, poster, title, msg, address, num "
			+ "FROM (SELECT no, poster, title, msg, address, rownum as num "
			+ "FROM (SELECT no, poster, title, msg, address "
			+ "FROM seoul_location ORDER BY no)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<SeoulLocationVO> seoulListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_location")
	public int seoulTotalPage();
	
	@Select("SELECT no, poster, title, msg, address "
			+ "FROM seoul_location WHERE no = #{no}")
	public SeoulLocationVO seoulDetailData(int no);
	
	
	@Select("SELECT fno, name, poster, rownum "
			+ "FROM food_location "
			+ "WHERE rownum <= 4 AND address LIKE '%'||#{addr}||'%'")
	public List<FoodVO> SeoulFoodData(Map map);
}
