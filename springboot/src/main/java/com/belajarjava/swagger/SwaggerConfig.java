package com.belajarjava.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.belajarjava.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "My Demo Api",
                "Ini adalah Demo Api",
                "API TOS",
                "Terms Of Service",
                new Contact("Fahmi Rachmadian", "www.tabledata.com", "reega009"),
                "Apache License",
                "www.Apache.com",
                Collections.emptyList());
        return apiInfo;
    }
}

// Swagger Verif = http://localhost:8080/v2/api-docs
// /v2/api-docs
