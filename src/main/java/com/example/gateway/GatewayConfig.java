package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("httpbin_route", r -> r.path("/httpbin/**")
                        .filters(f -> f.stripPrefix(1)
                                .addRequestHeader("X-Request-Source", "spring-cloud-gateway"))
                        .uri("https://httpbin.org:443"))
                .build();
    }
}
