package org.business.system.account;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages="org.business.system.*")
@ComponentScan(basePackages="org.business.system.*")
public class AccountApp {
	public static void main(String[] args) {
		 SpringApplication.run(AccountApp.class, args);	
	}

//	@Bean
//	public NoticeCloudService noticeCloudService() {
//		return 
//	}
}
