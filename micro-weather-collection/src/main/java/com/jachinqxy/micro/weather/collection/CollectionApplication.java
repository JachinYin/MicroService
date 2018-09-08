package com.jachinqxy.micro.weather.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 该微服务负责进行数据采集，隔半小时会自动进行一次采集工作
 * 将从第三方采集到的数据缓存到 Redis 中提供给服务使用。
 * 主程序类
 * @since 2018年07月29日
 * @author Jachin
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollectionApplication.class, args);
    }
}
