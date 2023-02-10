package com.douzone.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		// XML Auto Confituration(Annotation Scaning)
		testBeanFactory01();

	}

	private static void testBeanFactory01() {
		 BeanFactory bf= new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext.xml"));
		 User user= bf.getBean(User.class);
		 System.out.println(user.getName());
	}

}
