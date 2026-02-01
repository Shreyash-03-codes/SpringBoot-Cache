package com.cache.redis.springboot.configs;

import com.cache.redis.springboot.services.auditoraware.AuditOrAwareImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public AuditorAware auditorAware(){
        return new AuditOrAwareImpl();
    }
}
