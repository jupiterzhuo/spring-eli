package id.equity.RestExample.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.*;
import com.google.common.collect.Lists;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
//	@Bean
//    public Docket api() { 
//        return new Docket(DocumentationType.SWAGGER_2)  
//          .select()                                  
//          .apis(RequestHandlerSelectors.any())              
//          .paths(PathSelectors.any())                          
//          .build();                                           
//    }
	
	
	@Bean
	public Docket api() {
		//Adding Header
		ParameterBuilder aParameterBuilder = new ParameterBuilder();
		aParameterBuilder.name("Authorization")
				.modelRef(new ModelRef("String"))
				.parameterType("header")
				.required(true)
				.build();
		List<Parameter> aParameters =new ArrayList<>();
		aParameters.add(aParameterBuilder.build());

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
                .apiInfo(apiInfo())
				.pathMapping("")
//                .securitySchemes(Lists.newArrayList(apiKey()));
               .globalOperationParameters(aParameters);
	}


	private ApiKey apiKey() {
		return new ApiKey("Authorization", "Bearer", "header");
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"School REST API",
				"Some custom description of API.",
				"v1",
				"Terms of service",
				new Contact("jupiter", "www.equity.id", "jupiterc@gmail.com"),
				"License of API", "API license URL", Collections.emptyList());
	}
}
