package com.cyngofokglobalSalesManagementSystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI salesManagementOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sales Management System API")
                        .description("Comprehensive API documentation for the Sales Management System.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Cyngofok Global Limited")
                                .email("devteam@cngofokglobal.com")
                                .url("https://cngofokglobal.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
