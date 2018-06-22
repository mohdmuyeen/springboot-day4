package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SenderClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JmsConfig.class);
		MessageSender sender = (MessageSender) ctx.getBean("messageSender");

		for (int i = 0; i <= 10; i++){

			sender.send("test message -- " + (i + 10));
		}
		System.out.println("Message sent");
	}

	/*
	 * jt.send(new MessageCreator() {
	 * 
	 * @Override public Message createMessage(Session session) throws
	 * JMSException { TextMessage tm = session.createTextMessage();
	 * tm.setText("it my message"); return tm; }
	 * 
	 * });
	 */
	

}
