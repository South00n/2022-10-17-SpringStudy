package com.sist.dao;

import org.springframework.stereotype.Repository;

import com.sist.vo.ReplyVO;

import oracle.jdbc.OracleTypes;

import java.util.*;
import java.sql.*;

@Repository
public class ReplyDAO {
	private Connection conn;
	private CallableStatement cs; // PROCEDURE 호출할떄 사용
	// <select id="" resultType="" parameterType="" statement="CALLABLE">
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	public ReplyDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {}
	}
	
	// 연결
	public void getConnection() {
		try {
			conn  = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception e) {}
	}
	// 해제
	public void disConnection() {
		try {
			if(cs != null) cs.close();
			if(conn != null) conn.close();
		} catch (Exception e) {}
	}
	
	// 기능
	// 1. 추가
	/*
		CREATE OR REPLACE PROCEDURE replyInsert(
	    pRno spring_reply.rno%TYPE,
	    pType spring_reply.type%TYPE,
	    pId spring_reply.id%TYPE,
	    pName spring_reply.name%TYPE,
	    pMsg spring_reply.msg%TYPE
		)
		IS
		BEGIN
		    INSERT INTO spring_reply VALUES(sr_no_seq.nextval,pRno,pType,pId,pName,pMsg,SYSDATE);
		    COMMIT;
		END;
	 */
	public void replyInsert(ReplyVO vo) {
		try {
			getConnection();
			String sql = "{CALL replyInsert(?, ?, ?, ?, ?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, vo.getRno()); 
			cs.setInt(2, vo.getType());
			cs.setString(3, vo.getId());
			cs.setString(4, vo.getName());
			cs.setString(5, vo.getMsg());
			cs.executeQuery(); // 업데이트가 아니다
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}
	
	// 2. 목록
	/*
	 	CREATE OR REPLACE PROCEDURE replyList(
	    pRno spring_reply.rno%TYPE,
	    pType spring_reply.type%TYPE,
	    pResult OUT SYS_REFCURSOR /* 위에 해당되는 데이트를 모아서 받아온다 (resultset) OUT = 값을 받아오는 변수    
		)
		IS
		BEGIN
		  OPEN pResult FOR
		    SELECT no, rno, type, id, name, msg, regdate, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') as dbday
		    FROM spring_reply
		    WHERE rno = pRno AND type = pType;
		END;
		/
	 */
	public List<ReplyVO> replyListData(int rno, int type) {
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		try {
			getConnection();
			String sql = "{CALL replyList(?, ?, ?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, rno);
			cs.setInt(2, type);
			cs.registerOutParameter(3, OracleTypes.CURSOR); // pResult OUT SYS_REFCURSOR -> 데이터형을 맞춰야함
			// 실행
			cs.executeQuery();
			ResultSet rs = (ResultSet)cs.getObject(3);
			while(rs.next()) {
				ReplyVO vo = new ReplyVO();
				vo.setNo(rs.getInt(1));
				vo.setRno(rs.getInt(2));
				vo.setType(rs.getInt(3));
				vo.setId(rs.getString(4));
				vo.setName(rs.getString(5));
				vo.setMsg(rs.getString(6));
				vo.setRegdate(rs.getDate(7));
				vo.setDbday(rs.getString(8));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}
	// 3. 수정
	/*
		 CREATE OR REPLACE PROCEDURE replyUpdate(
	    /* 선언부 
	    pNo spring_reply.no%TYPE,
	    pMsg spring_reply.msg%TYPE
		)
		IS
		BEGIN
		  /* 구현부 
		  UPDATE spring_reply SET
		  msg = pMsg
		  WHERE no = pNo;
		  COMMIT;
		  END;
		/
	 */
	public void replyUpdate(int no, String msg) {
		try {
			getConnection();
			String sql = "{CALL replyUpdate (?, ?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, no);
			cs.setString(2, msg);
			cs.executeQuery(); // 업데이트 아님
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}
	// 4. 삭제
	/*
	 	CREATE OR REPLACE PROCEDURE replyDelete(
	    pNo spring_reply.no%TYPE
		)
		IS
		BEGIN
		    DELETE FROM spring_reply
		    WHERE no = pNo;
		    COMMIT;
		END;
	 */
	public void replyDelete(int no) {
		try {
			getConnection();
			String sql = "{CALL replyDelete(?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, no);
			cs.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}
}
