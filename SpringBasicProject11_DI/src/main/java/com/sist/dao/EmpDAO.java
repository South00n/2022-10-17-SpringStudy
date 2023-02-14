package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;

public class EmpDAO extends SqlSessionDaoSupport{
							// 마이바티스랑 스프링 연결하는거
	/*
	 * <select id="empListData" resultType="EmpVO">
		SELECT empno, ename, job
		FROM emp
		</select>
	 */
	public List<EmpVO> empListData() {
		return getSqlSession().selectList("empListData");
	}
	public EmpVO empDetailData(int empno) {
		return getSqlSession().selectOne("empDetailData", empno);
	}
}
