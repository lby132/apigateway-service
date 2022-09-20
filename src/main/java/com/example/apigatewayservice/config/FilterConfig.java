package com.example.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

  //  @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/first-service/**") // path를 등록하고 이 경로로 들어오면
                        .filters(f -> f.addRequestHeader("first-request", "first-request-header")   // Request 헤더에는 이 정보를 추가하고
                                .addResponseHeader("first-response", "first-response-header"))      // Response 헤더에는 이 정보를 추가한다.
                        .uri("http://localhost:8081"))  // 여기로 이동한다.
                .route(r -> r.path("/second-service/**")
                        .filters(f -> f.addRequestHeader("second-request", "second-request-header")
                                .addResponseHeader("second-response", "second-response-header"))
                        .uri("http://localhost:8082"))
                .build();
    }
}
