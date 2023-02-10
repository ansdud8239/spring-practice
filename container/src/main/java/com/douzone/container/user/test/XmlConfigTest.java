package com.douzone.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		// XML Auto Confituration(Annotation Scaning)
		// 자동설정
		// testBeanFactory01();

		// XML Bean Confituration(Explicit Scaning)
		// 수동설정 명시적
		// testBeanFactory02();

		// XML Auto Confituration(Annotation Scaning)
		// testApplicationContext01();

		// XML Bean Confituration(Explicit Scaning)
		testApplicationContext02();
	}

	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/douzone/container/config/user/applicationContext02.xml");
		User user = null;
		// 수동일 경우 설정해줘야함

		// id로 빈 가져오기
		user = (User) ac.getBean("user1");
		// System.out.println(user.getName());
		// name로 빈 가져오기
		user = (User) ac.getBean("usr1");
		// System.out.println(user.getName());
		// Type으로 빈 가져오기
		// user = ac.getBean(User.class);
		// System.out.println(user.getName());

		// Type으로 빈 가져오기
		// 같은 타입의 빈이 2개 이상 있으면 Type으로 가졍오기 실패
		// 1. id + type
		// 2. name + type
		user = (User) ac.getBean("user2", User.class);
		System.out.println(user);

		// 파라미터 2개인 생성자로 빈1 가져오기
		user = (User) ac.getBean("user3", User.class);
		System.out.println(user);
		// 파라미터 2개인 생성자로 빈2 가져오기
		user = (User) ac.getBean("user4", User.class);
		System.out.println(user);

		// setter를 사용한 빈 가져오기1 
		user = (User) ac.getBean("user5", User.class);
		System.out.println(user);

		// setter를 사용한 빈 가져오기2 (DI)
		user = (User) ac.getBean("user6", User.class);
		System.out.println(user);

		//setter를 사용한 빈 가져오기3 (Collection Property)
		user = (User) ac.getBean("user7", User.class);
		System.out.println(user);
	}

	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/douzone/container/config/user/applicationContext01.xml");
		User user = null;

		user = ac.getBean(User.class);
		System.out.println(user.getName());

		// Annotaion Scan 설정에서는 Bean id가 자동으로 부여 된다
		user = (User) ac.getBean("user");
		System.out.println(user.getName());
	}

	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(
				new ClassPathResource("com/douzone/container/config/user/applicationContext01.xml"));
		User user = bf.getBean(User.class);
		System.out.println(user.getName());
	}

	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(
				new ClassPathResource("com/douzone/container/config/user/applicationContext02.xml"));
		User user = bf.getBean(User.class);
		System.out.println(user.getName());
	}

}
