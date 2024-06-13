package org.constituencyservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "org.constituencyservice.*")
public class ConConfigClass {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
