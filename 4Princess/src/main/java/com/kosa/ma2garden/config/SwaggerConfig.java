package com.kosa.ma2garden.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
public class SwaggerConfig implements WebMvcConfigurer {

	private static final String API_NAME = "Ma2Garden API";
	private static final String API_VERSION = "0.9.0";
	private static final String API_DESCRIPTION = "Ma2Garden API 명세서";

	@Bean
	public Docket api() {
		Parameter parameterBuilder = new ParameterBuilder().name(HttpHeaders.AUTHORIZATION)
				.description("Access Tocken")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false)
				.build();

		List<Parameter> globalParamters = new ArrayList<>();
		globalParamters.add(parameterBuilder);

		return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(globalParamters)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.kosa.ma2garden.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(API_NAME)
				.version(API_VERSION)
				.description(API_DESCRIPTION)
				.build();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
