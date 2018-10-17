package com.github.hartorn.crystalchain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@Import(springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class)
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        //.apis(RequestHandlerSelectors.basePackage("com.github.hartorn.crystalchain"))
        //.apis(RequestHandlerSelectors.withClassAnnotation(RepositoryRestResource.class))
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.regex("/error").negate().and(PathSelectors.regex("/profile").negate())) // Exclude Spring error controllers
//        .paths(PathSelectors.any())
        .build()
        .apiInfo(buildMetadata());
  }

  private ApiInfo buildMetadata() {
    return new ApiInfoBuilder()
        .title("Crystal Chain")
        .description("Small api example for test")
        .version("1.0")
        .contact(new Contact("Hartorn", "https://github.com/Hartorn", "hartorn.github@gmail.com"))
        .build();
  }
}
