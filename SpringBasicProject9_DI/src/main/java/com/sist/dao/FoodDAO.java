package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
/*
 * 
		<select id="foodListData" resultType="FoodVO">
		SELECT fno, name address, rownum
		FROM food_location
		WHERE rownum &lt;= 50
		</select>
 */
public class FoodDAO extends SqlSessionDaoSupport{
	public List<FoodVO> foodListData() {
		return getSqlSession().selectList("foodListData");
		/*
		 *   while(rs.next()) {
		 *   	FoodVO vo = new FoodVO();
		 *   	vo.setFno(rs.getInt("fno"))
		 *   	..
		 *   	..
		 *   	list.add(vo)
		 *   }
		 */
	}
	/*
	 * <select id="foodListData" resultType="FoodVO">
		SELECT fno, name address, rownum
		FROM food_location
		WHERE rownum &lt;= 50
		</select>
	 */
	public FoodVO foodDetailData(int fno) {
		return getSqlSession().selectOne("foodDetailData", fno);
		/*
		 *  FoodVO vo = new FoodVO();
		 * 	vo.setFno(rs.getInt("fno"))
		 *	..
		 *	..
		 */
	}
}
