package com.jahcinqxy.micro.weather.reportserver.service;

import com.jahcinqxy.micro.weather.reportserver.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 天气预报服务.
 * @since 2018/08/02
 * @author Jachin
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	private final WeatherDataApp data;

	// 使用构造器注入
	@Autowired
	public WeatherReportServiceImpl(WeatherDataApp data) {
		this.data = data;
	}	

	@Override
	public List<Weather> getDataByCityCode(String cityCode) {
		//由天气数据API微服务来提供数据
		return data.getReportByCityCode(cityCode).getResults();
	}

}
