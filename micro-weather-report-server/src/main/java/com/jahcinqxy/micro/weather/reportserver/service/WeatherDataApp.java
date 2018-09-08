package com.jahcinqxy.micro.weather.reportserver.service;

import com.jahcinqxy.micro.weather.reportserver.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("micro-weather-data-server")
//@Service
public interface WeatherDataApp {

    @GetMapping("/weather/cityCode/{cityCode}")
    public WeatherResponse getReportByCityCode(@PathVariable("cityCode") String cityCode);
}
