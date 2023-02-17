package com.sist.mapper;
/*
 *  private int no;
 *  private String title, addr, score;
 */

import org.apache.ibatis.annotations.Select;
import java.util.*;
import com.sist.vo.*;

public interface FoodMapper {
	@Select("SELECT no, title, addr, score, rownum FROM jejuFood WHERE rownum <= 30")
	public List<JejuFoodVO> foodListData();
}
