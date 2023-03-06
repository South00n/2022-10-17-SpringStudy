package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	/*@Select("SELECT cno, title, poster "
			+ "FROM project_category")*/
	public List<CategoryVO> categoryListData() {
		return mapper.categoryListData();
	}
	
	/*@Select("SELECT title, subject FROM project_category "
			+ "WHERE cno = #{cno}")*/
	public CategoryVO categoryInfoData(int cno) {
		return mapper.categoryInfoData(cno);
	}
	
	/*@Select("SELECT fno, name, poster, score, tel, address, type "
			+ "FROM project_food "
			+ "WHERE cno = #{cno}")*/
	public List<FoodVO> foodListData(int cno) {
		return mapper.foodListData(cno);
	}

}
