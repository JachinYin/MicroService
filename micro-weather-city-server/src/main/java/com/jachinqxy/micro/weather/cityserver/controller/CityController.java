package com.jachinqxy.micro.weather.cityserver.controller;

import com.jachinqxy.micro.weather.cityserver.service.CityDataService;
import com.jachinqxy.micro.weather.cityserver.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 城市API.
 * 
 * @since 2018年07月30日
 * @author Jachin
 */
@RestController
@RequestMapping("/cities")
public class CityController {

	@Autowired
	private CityDataService cityDataService;

	@GetMapping
	public List<City> listCity() throws Exception {
		return cityDataService.listCity();
	}

}
