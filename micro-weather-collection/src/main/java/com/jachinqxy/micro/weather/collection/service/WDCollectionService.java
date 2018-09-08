package com.jachinqxy.micro.weather.collection.service;

public interface WDCollectionService {
	
	/**
	 * 根据城市ID同步天气数据
	 */
	void syncDataByCityKey(String cityKey);

}
