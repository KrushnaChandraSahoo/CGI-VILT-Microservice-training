package com.pritam.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pritam.orderservice.external.decoder.CustomErrorDecoder;

import feign.codec.ErrorDecoder;

@Configuration
public class FeignConfig {
	@Bean
    ErrorDecoder errorDecoder(){
        return new CustomErrorDecoder();
    }
}
