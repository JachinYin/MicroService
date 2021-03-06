package com.jachinqxy.micro.weather.collection.job;

import com.jachinqxy.micro.weather.collection.service.CityApplication;
import com.jachinqxy.micro.weather.collection.service.WDCollectionService;
import com.jachinqxy.micro.weather.collection.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;


/**
 * 天气数据同步任务.
 * @since 2018年07月29日
 * @author Jachin
 */
public class WeatherDataSyncJob extends QuartzJobBean {
	
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class); 

	@Autowired
	private WDCollectionService WDCollectionService;

	// 注入城市API服务的客户端应用
	@Autowired
	private CityApplication city;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("【天气数据同步任务】开始：");
		
		// 由城市数据API微服务来提供数据
		List<City> cityList = null;
		try {
			//调用城市数据API
				cityList = city.getCityIdList();
		} catch (Exception e) {
			logger.error("获取城市信息异常！", e);
			throw new RuntimeException("获取城市信息异常！", e);
		}
		logger.info("城市列表获取成功，下面开始同步每个城市天气数据。");
		for (City city : cityList) {
			String cityCode = city.getCityCode();
			logger.info("天气数据同步任务中，cityCode:" + cityCode);
			
			// 根据城市 Code 同步天气数据
			WDCollectionService.syncDataByCityKey(cityCode);
		}
		
		logger.info("End 天气数据同步任务");
	}

}
