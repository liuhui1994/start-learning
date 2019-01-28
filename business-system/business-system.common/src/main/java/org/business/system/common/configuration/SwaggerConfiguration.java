package org.business.system.common.configuration;

import java.util.ArrayList;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	

	/**
	 * -------------查看地址-------------------
	 * http://localhost:8081/notice/swagger-ui.html
	 * 
	 */
	
	@Bean
    public Docket createRestApi() {
		ParameterBuilder tokenBar = new ParameterBuilder();
		List<Parameter> par = new ArrayList<>();
		tokenBar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterAccess("query").required(false).build();
		par.add(tokenBar.build());
        return new Docket(DocumentationType.SWAGGER_2)
        		.globalOperationParameters(par)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.business.system"))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
		
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("org.business.system"))
//                .paths(PathSelectors.any())
//                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("XXX-对外开放测试接口")
                .description("简单优雅的restfun风格，https://github.com/liuhui1994/start-learning")
                .termsOfServiceUrl("https://github.com/liuhui1994/start-learning")
                .version("1.0")
                .build();
    }
    
  

}
