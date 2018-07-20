package com.example.sample.test;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

import org.chiknrice.test.SpringifiedConcordionRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsOperations;

@RunWith(SpringifiedConcordionRunner.class)
public class FirstTestFixture {

	@Value("${spring.profiles.active}") 
	String profiles;
	
	@Autowired
	JmsOperations jmsOps;
	
	public void send(String queue, String msg) {
		//System.out.print("send() :"+profiles);
		
		jmsOps.convertAndSend(queue, msg);
	}
	
	public String recv(String queue) {
		
		return (String) jmsOps.receiveAndConvert(queue);
		
		//throw new RuntimeException("timeout waiting for output");
	}
}
