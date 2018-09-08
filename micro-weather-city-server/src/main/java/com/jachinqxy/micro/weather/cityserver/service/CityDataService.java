package com.jachinqxy.micro.weather.cityserver.service;

import com.jachinqxy.micro.weather.cityserver.vo.City;

import java.util.List;

/**
 * 城市数据服务接口.
 * @since 2018年07月30日
 * @author Jachin
 */
public interface CityDataService {

	/**
	 * 获取城市列表.
	 * 
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
