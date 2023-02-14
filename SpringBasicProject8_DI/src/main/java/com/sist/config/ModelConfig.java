package com.sist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// <context:component-scan base-package="com.sist.model"/> 이게 자바로 바뀌면서 어노테이션으로 변함
@ComponentScan(basePackages = "com.sist.model")
public class ModelConfig {

}
