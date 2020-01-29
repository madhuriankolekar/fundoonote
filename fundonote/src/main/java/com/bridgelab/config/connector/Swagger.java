package com.bridgelab.config.connector;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
//@EnableSwagger2
public class Swagger {
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.bridgelabz.fundoonotes.controller"))
//				.paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndPointsInfo());
//	}
//	private ApiInfo apiEndPointsInfo() {
//		return new ApiInfoBuilder().title("Spring Boot REST API").description("Fundoo Notes User REST API")
//				.contact(new Contact("madhuri ankolekar", "h", "ga"))
//				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0")
//				.build();
//	}
//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.bridgelabz.fundoonotes.controller")).paths(regex("/fundoonote.*"))
//				.build();
//	}

	
}

