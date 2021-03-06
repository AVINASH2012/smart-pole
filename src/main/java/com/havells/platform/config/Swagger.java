package com.havells.platform.config;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger {
	
	public static final String AUTHORIZATION_HEADER = "Authorization";
	
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.havells.platform"))
	            .build()
	            .apiInfo(apiInfo())
	            .securitySchemes(Arrays.asList(apiKey()));
	}
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("Street Light Platform Project")
	            .description("work in progress")
	            .termsOfServiceUrl("localhost")
	            .version("1.0")
	            .build();
	}
	private ApiKey apiKey() {
	    return new ApiKey("jwtToken", "Authorization", "header");
	}
}