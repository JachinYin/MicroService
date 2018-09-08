package com.jachinqxy.micro.weather.collection.config;

import com.jachinqxy.micro.weather.collection.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Quartz 配置类.
 * @since 2018年07月29日
 * @author Jachin
 */
@Configuration
public class QuartzConfiguration {
	
	private final int TIME = 1800; // 更新频率
	
	@Bean
	public JobDetail weatherDataSyncJobJobDetail() {
		return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
				.storeDurably().build();
	}

	@Bean
	public Trigger sampleJobTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(TIME).repeatForever();

		return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobJobDetail())
				.withIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
	}
}
