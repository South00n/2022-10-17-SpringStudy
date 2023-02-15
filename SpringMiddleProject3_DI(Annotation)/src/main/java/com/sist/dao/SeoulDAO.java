package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.SeoulMapper;
import java.util.*;

// 메모리 할당을 요청
@Repository("dao")
public class SeoulDAO {
	
	@Autowired // 자동 주입 => setterDI
	private SeoulMapper mapper;
	public List<SeoulVO> seoulListData() {
		return mapper.seoulListData();
	}
}
