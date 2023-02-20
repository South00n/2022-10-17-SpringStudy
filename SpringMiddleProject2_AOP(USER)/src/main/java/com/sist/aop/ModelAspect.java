package com.sist.aop;

import java.util.List;
import java.util.*;
import com.sist.model.*;

import org.aspectj.lang.ProceedingJoinPoint;
/*
 *     AOP의 적용 부분
 *     @Transactional() -> 트랜잭션 한방에 처리
 *     public List<MovieVO> movieListData() {
 *         List<MovieVO> list = new ArrayList<MovieVO>();
 *         try {
 *             getConnection() ==> Before
 *             =========================
 *                 around => setAutoCommit(false)
 *                 오라클 처리
 *                 around => commit()
 *             =========================
 *         } cathch(Exception ex) {
 *             오류 처리 => rollbackup()
 *             ex.printStackTrace() ==> AfterThrowing
 *         } finally {
 *             오라클 닫기
 *             disConnection() ==> After
 *         }
 *         return; => AfterReturning
 *     }
 */
import com.sist.model.*;

import lombok.Setter;
public class ModelAspect {
	@Setter
	private EmpDAO dao;
	
	public void before() {
		System.out.println("before Call...");
		dao.getConnection();
	}
	public void after() {
		System.out.println("after Call... : finally");
		dao.disConnection();
	}
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("around Call... try위 ~ try 종료전" );
		Object obj = null;
		// 수행 시간 계산
		long start = 0;
		long end = 0;
		try {
			start = System.currentTimeMillis();
			System.out.println("Client 요청 메소드 : " + jp.getSignature().getName());
			obj=jp.proceed(); // 메소드 호출
 		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			end = System.currentTimeMillis();
			System.out.println("수행 시간 :" + (end-start));
		}
		return obj;
	}
	
	public void afterReturning(Object obj) throws Throwable {
		// 결과값을 받아서 출력 ==> web에서 return값을 먼저 처리
		System.out.println("afterReturning Call... : 정상 수행시 처리");
		List<EmpVO> list = (List<EmpVO>)obj;
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno() + " " + vo.getEname() + " " + vo.getJob());
		}
	}
	
	// Throwalbe Exception의 상위클래스
	public void afterThrowing(Throwable ex) throws Throwable {
		System.out.println("afterThrowing Call... : 오류 발생시 처리");
		// catch수행
		System.out.println(ex.getMessage());
	}
 }
