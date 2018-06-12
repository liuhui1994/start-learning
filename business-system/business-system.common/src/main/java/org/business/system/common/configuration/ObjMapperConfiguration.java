package org.business.system.common.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
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
//	    JSON字符串中含有我们并不需要的字段，那么当对应的实体类中不含有该字段时，会抛出一个异常，告诉你有些字段没有在实体类中找到。解决办法很简单，在声明ObjectMapper之后，加上上述代码：
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	    return objectMapper;
	  }
}
