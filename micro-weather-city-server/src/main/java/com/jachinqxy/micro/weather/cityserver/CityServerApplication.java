package com.jachinqxy.micro.weather.cityserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityServerApplication.class, args);
    }
}
