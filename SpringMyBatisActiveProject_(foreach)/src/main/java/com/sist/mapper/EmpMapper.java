package com.sist.mapper;

import java.util.*;

import com.sist.dao.EmpVO;
/*
 *   <trim>
 *   <foreach>
 *   <if>
 *   <choose>
 *   <when>
 */
public interface EmpMapper {
	
	public List<String> empNameListData();
	
	/*
	 <select id="empInfoData" resultType="EmpVO" parameterType="hashmap">
     SELECT * FROM emp
     WHERE ename
	 */
	public List<EmpVO> empInfoData(Map map);
}
