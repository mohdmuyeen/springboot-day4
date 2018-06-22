package com.demo.spring;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJcaListenerContainerFactory;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@ComponentScan(basePackages="com.demo.spring")
@EnableJms
public class JmsConfig {

	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL("tcp://localhost:61616");
		return factory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jt = new JmsTemplate();
		jt.setConnectionFactory(connectionFactory());
		jt.setDefaultDestinationName("myQueue");
		return jt;
	}
	
	/*@Bean
	public DefaultJmsListenerContainerFactory factory(){
		DefaultJmsListenerContainerFactory factory  = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		return factory;
	}*/
}
