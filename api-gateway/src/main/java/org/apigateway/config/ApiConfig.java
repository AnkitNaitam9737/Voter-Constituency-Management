package org.apigateway.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
public class ApiConfig {

//    @Bean
//    public RouteLocator customeRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes().route("VOTER-SERVICE", r -> r.path("/api/voter/**").uri("http://localhost:8081"))
//                .route("CONSTITUENCY-SERVICE", r -> r.path("/api/constituency/**").uri("http://localhost:8082"))
//                .build();
//    }
}
