package com.jachinqxy.micro.weather.dataserver.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jachinqxy.micro.weather.dataserver.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 天气数据服务.
 * @since 2018/08/01
 * @author Jachin
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

	private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);  

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	private final String WEATHER_API = "https://api.seniverse.com/v3/weather/daily.json?key=zqbbicypcfaq5y1v&location=";
	private final String suffix ="&start=0&days=5";
	
	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		String uri = WEATHER_API + cityId + suffix;
		return this.doGetWeatherData(uri);
	}

	@Override
	public WeatherResponse getDataByCityCode(String cityCode) {
		String uri = WEATHER_API + cityCode + suffix;
		return this.doGetWeatherData(uri);
	}

	private WeatherResponse doGetWeatherData(String uri) {
		ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
		String key = uri;
		String strBody = null;

		// 先查缓存，查不到抛出异常
		if (!this.stringRedisTemplate.hasKey(key)) {
			logger.error("不存在 key " + key);
			 
			throw new RuntimeException("没有相应的天气信息");
		} else {
			logger.info("存在 key " + key + ", value=" + ops.get(key));
			
			strBody = ops.get(key);
		}

		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse weather = null;

		try {
			weather = mapper.readValue(strBody, WeatherResponse.class);
		} catch (IOException e) {
			logger.error("JSON反序列化异常！",e);
			throw new RuntimeException("天气信息解析失败");
		}

		return weather;
	}
	
}