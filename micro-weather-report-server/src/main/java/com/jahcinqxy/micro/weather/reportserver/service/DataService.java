package com.jahcinqxy.micro.weather.reportserver.service;

import com.jahcinqxy.micro.weather.reportserver.vo.City;
import com.jahcinqxy.micro.weather.reportserver.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 通过 feign 将所有的请求直接统一交给zuul网关，由网关进行转发
 * 因为 report 预报微服务依赖于城市微服务和天气数据微服务，因此，在使用统一网关后，
 * 便可以把原来的这两个服务的 feign 接口删除，统一使用 DataService
 */
@FeignClient("micro-weather-zuul")
//@Service
public interface DataService {

    @GetMapping("/cities")
    public List<City> getCityIdList() throws Exception;

    @GetMapping("/weather/cityCode/{cityCode}")
    public WeatherResponse getReportByCityCode(@PathVariable("cityCode") String cityCode);
}
