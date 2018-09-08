package com.jachinqxy.micro.weather.dataserver.controller;

import com.jachinqxy.micro.weather.dataserver.service.WeatherDataService;
import com.jachinqxy.micro.weather.dataserver.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 天气API.
 * @since 2018/08/01
 * @author Jachin
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherDataService weatherDataService;

	@GetMapping("/cityId/{cityId}")
	public WeatherResponse getReportByCityId(@PathVariable("cityId") String cityId) {
		return weatherDataService.getDataByCityId(cityId);
	}

	@GetMapping("/cityCode/{cityCode}")
	public WeatherResponse getReportByCityCode(@PathVariable("cityCode") String cityCode) {
		return weatherDataService.getDataByCityCode(cityCode);
	}

}
