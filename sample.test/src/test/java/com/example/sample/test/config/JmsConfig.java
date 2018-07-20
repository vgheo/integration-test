package com.example.sample.test.config;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {

	@Resource(mappedName="jms.cf")
	private ConnectionFactory connectionFactory;

	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory, 
			@Value("${jms.template.receiveTimeout}") long receiveTimeout) {
	       JmsTemplate jmsTemplate = new JmsTemplate();
	       jmsTemplate.setConnectionFactory(connectionFactory);
	       jmsTemplate.setReceiveTimeout(receiveTimeout);
	       return jmsTemplate;
	}
	
}
