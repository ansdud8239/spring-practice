package com.douznoe.aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		ProductService ps = ac.getBean(ProductService.calss);
		ProductVo vo = ps.find("TV");
		System.out.println(vo);
	}
}
