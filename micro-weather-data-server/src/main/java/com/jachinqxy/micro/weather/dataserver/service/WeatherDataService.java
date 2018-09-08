package com.jachinqxy.micro.weather.dataserver.service;

import com.jachinqxy.micro.weather.dataserver.vo.WeatherResponse;

/**
 * 天气数据服务.
 * @since 2018/08/01
 * @author Jachin
 */
public interface WeatherDataService {

	/**
	 * 根据城市ID查询天气数据
	 * 
	 */
	WeatherResponse getDataByCityId(String cityId);

	/**
	 * 根据城市名称拼音查询天气数据
	 * 
	 */
	WeatherResponse getDataByCityCode(String cityCode);

}
