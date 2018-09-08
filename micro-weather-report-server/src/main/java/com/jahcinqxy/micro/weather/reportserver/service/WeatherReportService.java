package com.jahcinqxy.micro.weather.reportserver.service;

import com.jahcinqxy.micro.weather.reportserver.vo.Weather;

import java.util.List;

/**
 * 天气预报服务.
 * @since 2018/08/02
 * @author Jachin
 */
public interface WeatherReportService {

	/**
	 * 根据城市ID查询天气信息
	 */
	List<Weather> getDataByCityCode(String cityCode);

}
