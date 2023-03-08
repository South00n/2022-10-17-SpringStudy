package com.sist.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.dao.FoodDAO;
// 공통 모듈 => 공통으로 적용되는 기능을 모아서 관리 => 트랜잭션, 보안 (제작되어 있다)
/*
 * 트랜잰션 :
 *   conn.setAutoCommit (false)
 *   SQL
 *   SQL
 *   ...
 *   conn.commit()
 *   
 *    => conn.rollback()
 *    보안 : 인증 / 인가
 *    => 사용자 정의 : 로그파일 => 빅데이터 (데이터수집, 데이터전처리...) => 데이터 예측
 *                            데이터 전처리 + 데이터 분석
 *                            ---------------------- 딥러닝
 *    어떤 메소드에서 처리 : PointCut
 *    어느 위치에서 대입 : JoinPoint
 *    
 *    ---------------------------- Advice(여러개 : Aspect)
 *    
 *    puublic void dispay() {
 *    	@Before
 *    	try {
 *    		핵심코드
 *    	} catch(Exception ex) {
 *    		@After-Thorwing
 *    	} finally {
 *    		@After
 *    	}
 *    	
 *    	return @After-Returning
 *    }
 */
import com.sist.vo.*;
import java.util.*;
import com.sist.openapi.*;
@Aspect
@Component
public class CommonAspect {
	@Autowired
	private FoodDAO dao;
	@Autowired
	private NaverNewsManager mgr;
	@Around("execution(* com.sist.web.*Controller.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		Object obj = null;
		long start = System.currentTimeMillis();
		System.out.println("============================================");
		System.out.println("클라이언트 요청전:" + jp.getSignature().getName());
		obj = jp.proceed(); // 메소드 호출
		System.out.println("클라이언트 요청 처리 종료");
		long end = System.currentTimeMillis();
		System.out.println("요청 처리에 걸린 시간: "+(end-start));
		return obj;
	}
	
	@After("execution(* com.sist.web.*FController.*(..))")
	public void footerData() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<FoodVO> tList = dao.foodTop7();
		for(FoodVO vo:tList) {
			String address = vo.getAddress();
			String[] addr = address.split(" ");
			vo.setAddress(addr[1].trim());
		}
		request.setAttribute("tList", tList);
		
		List<NewsVO> nList = mgr.newsListData("맛집");
		request.setAttribute("nList", nList);
	}
}
