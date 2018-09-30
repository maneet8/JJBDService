package com.jjbd.depot.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Profile("dev")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/depot*")).build().apiInfo(apiInfo()).tags(tags())
				.useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Depot Details",
				"Depot Details Jai Jawan Biodiesel Pvt Ltd.",
				"1.0.0", "All rights reserved under maneetkum@gmail.com Policies",
				new Contact("JJBD", "http://jaijawanbiodiesel.com",
						"maneetkum@gmail.com"),
				"JJBD", "All rights reserved under maneetkum@gmail.com Policies", Collections.emptyList());
	}

	private Tag tags() {
		return new Tag("JJBDService", "Depot Details.");
	}

}
