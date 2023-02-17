package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper; // null => 스프링에서 구현한 클래스를 받아서 사용 (스프링에서 해당 클래스 객체를 찾아서 자동으로 주입)
	public List<FoodVO> foodListData() {
		return mapper.foodListData();
	}
}
