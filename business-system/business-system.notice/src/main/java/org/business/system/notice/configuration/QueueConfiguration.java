package org.business.system.notice.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfiguration {

	@Bean 
	public Queue createAccount(){
		return new Queue("createAccount");
	}
	
	
//	@Bean 
//	public Queue queue(){
//		return new Queue("createAccount");
//	}
}
