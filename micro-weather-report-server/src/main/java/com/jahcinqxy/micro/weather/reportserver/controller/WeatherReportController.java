package com.jahcinqxy.micro.weather.reportserver.controller;

import com.jahcinqxy.micro.weather.reportserver.service.CityApplication;
import com.jahcinqxy.micro.weather.reportserver.service.WeatherReportService;
import com.jahcinqxy.micro.weather.reportserver.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 天气预报微服务
 * @since 2018/08/02
 * @author Jachin
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
	
	private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);  
	
	private final WeatherReportService weatherReportService;

	private final CityApplication city;


	@Autowired
	public WeatherReportController(WeatherReportService weatherReportService, CityApplication city) {
		this.weatherReportService = weatherReportService;
		this.city = city;
	}

	@GetMapping("/cityCode/{cityCode}")
	public ModelAndView getReportByCityId(@PathVariable("cityCode") String cityCode, Model model) throws Exception {
		// 获取城市列表
		List<City> cityList = null;
		try {
			// 调用城市数据API
			cityList = city.getCityIdList();
		} catch (Exception e) {
			logger.error("获取城市信息异常！", e);
			throw new RuntimeException("获取城市信息异常!",e);
		}
		
		model.addAttribute("title", "简易天气预报");
		model.addAttribute("cityCode", cityCode);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getDataByCityCode(cityCode).get(0));
		return new ModelAndView("weather/report", "reportModel", model);
	}

}
