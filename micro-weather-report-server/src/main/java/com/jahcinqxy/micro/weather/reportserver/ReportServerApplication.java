package com.jahcinqxy.micro.weather.reportserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient // eureka 服务注册
@EnableFeignClients // feign 服务消费
@EnableCircuitBreaker // 开启熔断器功能
public class ReportServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportServerApplication.class, args);
    }
}
