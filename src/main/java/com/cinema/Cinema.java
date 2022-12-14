package com.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = {"com.cinema.service.impl",
        "com.cinema.mapper","com.cinema.*"})
public class Cinema extends WebMvcConfigurerAdapter
{

    public static void main(String[] args)
    {
        SpringApplication.run(Cinema.class, args);
    }





    @Bean
    public Docket docket()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName()))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(generateApiInfo());
    }


    private ApiInfo generateApiInfo()
    {
        return new ApiInfo("Cinema Server Applicant Service", "This service is to manage the cinema of the people..", "Version 1.0 - mw",
                "urn:tos", "canberkerdem@outlook.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
    }
}