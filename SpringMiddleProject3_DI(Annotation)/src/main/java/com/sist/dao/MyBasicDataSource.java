package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;

@Component("ds")
// 사용자 정의는 어노테이션, 라이브러리는 XML
public class MyBasicDataSource extends BasicDataSource {
	/*
	  <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
      p:driverClassName="oracle.jdbc.driver.OracleDriver"
      p:url="jdbc:oracle:thin:@localhost:1521:xe"
      p:username="hr"
      p:password="happy"
      p:maxActive="10"
      p:maxIdle="10"
      p:maxWait="-1"
      />
	 */
	public MyBasicDataSource() {
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		setUsername("hr");
		setPassword("happy");
		setMaxActive(10);
		setMaxIdle(10);
		setMaxWait(-1);
	}
}
