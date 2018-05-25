package org.business.system.notice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ObjMapperConfiguration {

	  /**
	   * 具体用法可百度搜索  springboot 集成 jackson
	   * @return
	   */
	  @Bean
	  public ObjectMapper ObjectMapper(){
	    ObjectMapper objectMapper=new ObjectMapper();
	    return objectMapper;
	  }
}
