package com.demo.spring;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MyMessageListener {

	@JmsListener(destination = "myQueue", containerFactory = "factory")
	public void getMessage(Message message) throws Exception {
		TextMessage tm = (TextMessage) message;
		System.out.println("Recieved " + tm.getText());
	}
}
