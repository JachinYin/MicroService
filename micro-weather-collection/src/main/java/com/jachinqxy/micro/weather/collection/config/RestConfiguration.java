package com.jachinqxy.micro.weather.collection.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * REST 配置类.
 * Spring Boot 要想使用 RestTemplate，必须先进行注入
 * @since 2018年07月29日
 * @author Jachin
 */
@Configuration
public class RestConfiguration {

	@Autowired
	private RestTemplateBuilder builder;

	@Bean
	public RestTemplate restTemplate() {
		return builder.build();
	}

}
