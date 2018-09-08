package com.jachinqxy.micro.weather.collection.service;

import com.jachinqxy.micro.weather.collection.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("micro-weather-city-server")
public interface CityApplication {

    @GetMapping("/cities")
    public List<City> getCityIdList() throws Exception;
}
