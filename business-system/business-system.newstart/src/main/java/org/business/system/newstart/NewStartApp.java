package org.business.system.newstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.business.system.*")
@EnableDiscoveryClient
public class NewStartApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(NewStartApp.class, args);
    }
}
