package com.jachinqxy.micro.weather.dataserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 天气数据API微服务，提供数据的展示
 * @since 2018/07/30
 * @author Jachin
 */
@SpringBootApplication
public class DataServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataServerApplication.class, args);
    }
}
