package com.sist.vo;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
// MyBatis => 변수명 = 컬럼명이 동일 
/*
 *   SELECT empno,hiredate as regdate,ename, NVL(comm,0) as comm  FROM ...
 *         ---------------------
 *         setEmpno() 
 */
// <resultMap> <result property="regdate" column="hiredate">
@Setter
@Getter
public class EmpVO {
  private int empno,sal,deptno,rank;
  private String ename,job;
  private Date  regdate;
  private String dname,loc;
  private int grade;
}