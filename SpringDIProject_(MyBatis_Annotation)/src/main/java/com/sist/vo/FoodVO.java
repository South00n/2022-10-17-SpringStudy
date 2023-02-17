package com.sist.vo;

import lombok.Getter;
import lombok.Setter;
/*
	FNO         NOT NULL NUMBER         
	NAME        NOT NULL VARCHAR2(1000) 
	SCORE       NOT NULL NUMBER(2,1)    
	ADDRESS     NOT NULL VARCHAR2(1000) 
	TEL         NOT NULL VARCHAR2(20)   
	TYPE        NOT NULL VARCHAR2(50)   
	PRICE                VARCHAR2(60)   
	TIME                 VARCHAR2(60)   
	PARKING              VARCHAR2(60)   
	MENU                 VARCHAR2(1000) 
	HIT                  NUMBER         
	POSTER               VARCHAR2(2000) 
	RESERVE_DAY          VARCHAR2(100)
	
	= XML
	= Annotation + XML (*****)
	
	분업 : 개인마다 (어노테이션) => 사용자 정의 클래스 (1.VO 2.DAO 3.Model 4.JSP(Front)=Ajax(X), VueJS)
	     ---------------- 공통으로 사용(XML) => 라이브러리
	
 */
@Getter
@Setter
public class FoodVO {
	private int fno;
	private String name, type;
}
