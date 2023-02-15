package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;

@Repository // DAO를 알려주는 별칭 (Spring에 알려주고 메모리 할당받음)
public class EmpDAO {
	//Mapper = interface => 구현된 클래스를 받는다
	@Autowired
	private EmpMapper mapper;
	
	public List<EmpVO> empListData() {
		return mapper.empListData();
	}
	
}
