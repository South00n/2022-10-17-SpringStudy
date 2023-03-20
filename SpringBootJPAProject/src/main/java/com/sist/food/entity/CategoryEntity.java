package com.sist.food.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="project_category") // 어떤 테이블인지 확인
public class CategoryEntity {
   // 자동증가번호
   @Id // 프라이머리 키
   private int cno;
   
   private String title;
   private String subject;
   private String poster;
   private String link;
   
}