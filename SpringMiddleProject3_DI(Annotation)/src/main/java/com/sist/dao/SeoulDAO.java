package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.SeoulMapper;
import java.util.*;

// �޸� �Ҵ��� ��û
@Repository("dao")
public class SeoulDAO {
	
	@Autowired // �ڵ� ���� => setterDI
	private SeoulMapper mapper;
	public List<SeoulVO> seoulListData() {
		return mapper.seoulListData();
	}
}
