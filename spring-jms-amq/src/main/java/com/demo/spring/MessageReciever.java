package com.demo.spring;

import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageReciever {

	@Autowired
	JmsTemplate jt;

	public String receive() throws Exception {
		TextMessage tm = (TextMessage) jt.receive();
		return tm.getText();
	}
}
