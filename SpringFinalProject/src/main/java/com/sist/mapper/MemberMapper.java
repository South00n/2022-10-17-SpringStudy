package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface MemberMapper {
	@Select("SELECT COUNT(*) FROM spring_join "
			+ "WHERE id = #{id}")
	public int memberIdCheck(String id);
	
	@Select("SELECT id, pwd, name, admin FROM spring_join "
			+ "WHERE id = #{id}")
	public MemberVO memberLogin(String id);
	
	// JOIN
	@Insert("INSERT INTO spring_join VALUES("
			+ "#{id}, #{pwd}, #{name}, 'n')")
	public void memberInsert(MemberVO vo);
}
