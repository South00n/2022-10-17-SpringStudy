package com.sist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class DeptDAO extends SqlSessionDaoSupport {
	/*
	 * <select id="deptListData" resultType="DeptVO">
		SELECT deptno, dname, loc
		FROM dept
		</select>
	 */
	public List<DeptVO> deptListData() {
		return getSqlSession().selectList("deptListData");
	}
	
	/*
	 * <select id="deptDetailData" resultType="DeptVO" parameterType="int">
		SELECT deptno, dname, loc
		FROM dept
		WEHRE deptno=#{deptno}
		</select>
	 */
	public DeptVO deptDetailData(int deptno) {
		return getSqlSession().selectOne("deptDetailData", deptno);
	}
}
