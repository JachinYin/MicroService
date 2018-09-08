package com.jachinqxy.micro.weather.collection.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * 天气数据采集服务.
 * @since 2018年07月29日
 * @author Jachin
 */
@Service
public class WDCollectionServiceImpl implements WDCollectionService {

	private final static Logger logger = LoggerFactory.getLogger(WDCollectionServiceImpl.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	private final String WEATHER_API =
			"https://api.seniverse.com/v3/weather/daily.json?key=zqbbicypcfaq5y1v&location=";
	private final String suffix = "&start=0&days=5";

	private final Long TIME_OUT = 1800L; // 缓存超时时间

	@Override
	// cityKey 可以传入城市的 ID，也可以传入城市的拼音Code
	public void syncDataByCityKey(String cityKey) {
		logger.info("Start 同步天气.cityId:"+cityKey);

		String uri = WEATHER_API + cityKey + suffix;
		this.saveWeatherData(uri, cityKey);
		
		logger.info("End 同步天气");
	}
	
	private void saveWeatherData(String uri,String city) {
		ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
		String key = uri;
		String strBody = null;

		try {

			ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

			if (response.getStatusCodeValue() == 200) {
				strBody = response.getBody();
			}

			ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
		}catch (Exception e){
			logger.info("没有该城市的数据",city);
		}
	}

}