package com.sist.main;
/*
 * 	 XML => JAXB / JAXP
 *                 ==== DOM/SAX(프레임워크) => Spring / MyBatis
 *                 		    -------------
 *                          <?xml version="1.0" encoding="utf-8"> => startDocument() => 자동호출
 *                          <beans> => startElement()
 *                            <bean id="" class=""/> => startElement(), endElement()
 *                            						    ============== 재정의
 *                            <bean id="" class=""/> => startElement(), endElement()
 *                          </beans> => endElement()
 *                          endDocument()
 */
public class Sawon {
	private int sabun;
	private String name, dept, job;
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
}
