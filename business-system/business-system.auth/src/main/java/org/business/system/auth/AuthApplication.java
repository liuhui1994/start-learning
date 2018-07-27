package org.business.system.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("org.business.system.*")
@EnableFeignClients(basePackages="org.business.system.*")
public class AuthApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
		
				
//				AuthorizationEndpoint
//				
//				CheckTokenEndpoint
//				
//				TokenEndpoint
		
//		Authentication
//		Authenticatio
	}
	
}
