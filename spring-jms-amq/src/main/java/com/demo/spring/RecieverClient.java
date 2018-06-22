package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RecieverClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new AnnotationConfigApplicationContext(JmsConfig.class);
		
		MessageReciever r=(MessageReciever)ctx.getBean("messageReciever");
		
		System.out.println(r.receive());

	}

}
