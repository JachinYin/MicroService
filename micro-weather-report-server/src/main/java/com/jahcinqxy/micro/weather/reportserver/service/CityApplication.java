package com.jahcinqxy.micro.weather.reportserver.service;

import com.jahcinqxy.micro.weather.reportserver.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("micro-weather-city-server")
//@Service
public interface CityApplication {

    @GetMapping("/cities")
    public List<City> getCityIdList() throws Exception;
}
