package br.com.thebook.controller.utils;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info = 
@Info(title="TheBook-service API",
version = "v1.0.0",
description = "Documentation of TheBook-service API"))
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components())
				.info(
						new io.swagger.v3.oas.models.info.Info()
						.title("TheBook-service API")
						.version("v1.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://springdoc.org")
								)
						);
	}
}
