package com.sist.aop;
/*
 *   aspect : 공통모듈 (자주 호출)
 *   -----------------------
 *     공통 / 핵심
 *   OOP는 공통으로 사용시에 => 한개의 클래스를 이용할때 메소드
 *                                         -----
 *                           = getConnection(), disConnection()
 *                        여러개 클래스 이용할때 클래스
 *                           = CreateConnection
 *   스프링에서는 => 공통으로 사용되는 부분을 자동화 처리 => AOP => Commons.footData() => AOP
 *   AOP에서 처리할 수 있는 분야 => 로그파일 생성시, 트랜잭션 처리, 보안  
 *   --------------------
 *     1) 시점 (언제 호출) ==> JoinPoint
 *         = Before
 *         = After
 *         = AfterReturning
 *         = AfterThrowing
 *         = Around
 *         
 *         public String display() {
 *             @Before (getConnection())
 *             try {
 *                 ================== Around (처리 시간계산에 많이 사용) or setAutoCommit(false0
 *                 
 *                 
 *                 ==================
 *             
 *             } catch(Exception ex) {
 *                 에러발생시 => AfterThorwing
 *             } finally {
 *                 @After disConnection()
 *             }
 *             return = "" => AfterReturning(정상수행시) => 리턴값을 받아서 처리
 *         }
 *     2) 어떤 메소드에서 자동화 ==> PointCut
 *         execution("* com.sist.main.*.*(..)")
 *                   -- ------------- - - -- 모든 매개변수
 *                   |                | | 메소드
 *                  리턴형            모든 클래스
 *         within("com.sist.main,.*") ==> 패키지 단위로 모든 클래스에 적용
 *     3) Advice (JoinPount + PointCut) ==> Aspect
 *     4) Weaving : 통합 ==> Proxy패턴 (대리자)
 *     -----------------------------------------------------------
 *     예)
 *         public class A {
 *             public void display() {
 *             
 *             }
 *         }
 *        
 *         public class Proxy {
 *             private A a;
 *             public Proxy(A a) {
 *                 this.a = a;
 *             }
 *             public void display() {
 *                 @Before
 *                 System.out.println("Before")
 *                 a.display()
 *                 @After
 *                 System.out.println("After")
 *             }
 *         }
 *     
 */
public class MyAspect {
    public void getConnection() {
    	System.out.println("오라클 연결");
    }
    public void disConnection() {
    	System.out.println("오라클 닫기");
    }
}
