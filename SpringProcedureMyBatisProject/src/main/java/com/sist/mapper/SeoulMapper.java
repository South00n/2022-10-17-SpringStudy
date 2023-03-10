package com.sist.mapper;
import java.util.*;
/*
 * CREATE OR REPLACE PROCEDURE seoulLocationListData(
  pStart NUMBER,
  pEnd NUMBER,
  pResult OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN pResult FOR
   SELECT no,title,poster,msg,address,hit,num
   FROM (SELECT no,title,poster,msg,address,hit,rownum as num
   FROM (SELECT no,title,poster,msg,address,hit
   FROM seoul_location ORDER BY no ASC))
   WHERE num BETWEEN pStart AND pEnd;
END;
/

CREATE OR REPLACE PROCEDURE seoulLocationDetailData(
   pNo seoul_location.no%TYPE,
   pResult OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN pResult FOR
    SELECT no,title,poster,msg,address,hit
    FROM seoul_location
    WHERE no=pNo;
END;
/

CREATE OR REPLACE PROCEDURE seoulLocationTotalPage(
   pTotal OUT NUMBER
)
IS
BEGIN
  SELECT CEIL(COUNT(*)/20.0) INTO pTotal
  FROM seoul_location;
END;
/

 */

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.sist.dao.SeoulVO;

public interface SeoulMapper {
  /*
   *    CREATE OR REPLACE PROCEDURE seoulLocationListData(
		  pStart NUMBER,
		  pEnd NUMBER,
		  pResult OUT SYS_REFCURSOR
		)
		IS
		BEGIN
		  OPEN pResult FOR
		   SELECT no,title,poster,msg,address,hit,num
		   FROM (SELECT no,title,poster,msg,address,hit,rownum as num
		   FROM (SELECT no,title,poster,msg,address,hit
		   FROM seoul_location ORDER BY no ASC))
		   WHERE num BETWEEN pStart AND pEnd;
		END;
		/
   */
	@Select(value="{CALL seoulLocationListData(#{pStart,mode=IN,javaType=java.lang.Integer},#{pEnd,mode=IN,javaType=java.lang.Integer},#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=seoulMap})}")
	@Options(statementType = StatementType.CALLABLE)
	public List<SeoulVO> seoulListData(Map map);
	
	/*
	 *  CREATE OR REPLACE PROCEDURE seoulLocationDetailData(
		   pNo seoul_location.no%TYPE,
		   pResult OUT SYS_REFCURSOR
		)
		IS
		BEGIN
		  OPEN pResult FOR
		    SELECT no,title,poster,msg,address,hit
		    FROM seoul_location
		    WHERE no=pNo;
		END;
		/
	 */
	@Select(value="{CALL seoulLocationDetailData(#{pNo,mode=IN,javaType=java.lang.Integer},#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=seoulMap})}")
	@Options(statementType = StatementType.CALLABLE)
	public SeoulVO seoulDetailData(Map map);
	
	/*
	 *   CREATE OR REPLACE PROCEDURE seoulLocationTotalPage(
		   pTotal OUT NUMBER
		)
		IS
		BEGIN
		  SELECT CEIL(COUNT(*)/20.0) INTO pTotal
		  FROM seoul_location;
		END;
		/
	 */
	/*
	 * @Select(
	 * value="{CALL seoulLocationTotalPage(#{pTotal,mode=OUT,javaType=java.lang.Integer})}"
	 * )
	 * 
	 * @Options(statementType = StatementType.CALLABLE) public Integer
	 * seoulTotalPage(Map map);
	 */
	public Integer seoulTotalPage();
	
}










