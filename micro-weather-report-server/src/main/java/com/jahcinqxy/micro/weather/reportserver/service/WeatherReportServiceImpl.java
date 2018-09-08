package com.jahcinqxy.micro.weather.reportserver.service;

import com.jahcinqxy.micro.weather.reportserver.vo.Daily;
import com.jahcinqxy.micro.weather.reportserver.vo.Location;
import com.jahcinqxy.micro.weather.reportserver.vo.Weather;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * 天气预报服务.
 * @since 2018/08/02
 * @author Jachin
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Override
	public Weather getDataByCityId(String cityId) {
		// TODO 改为由天气数据API微服务来提供数据
		
		Weather data = new Weather();
		data.setLast_update(new Date("2018/09/07"));

        Location location = new Location();
        location.setId("WX4FBXXFKE4F");
        location.setName("北京");
        location.setCountry("CN");
        location.setPath("北京,北京,中国");
        location.setTimezone("Asia/Shanghai");
        location.setTimezone_offset("+08:00");
        data.setLocation(location);

        ArrayList<Daily> dailies = new ArrayList<>();

        Daily d1 = new Daily();
        d1.setDate("2018-09-07");
        d1.setText_day("晴");
        d1.setCode_day("0");
        d1.setCode_night("晴");
        d1.setCode_night("1");
        d1.setHigh("27");
        d1.setLow("16");
        d1.setPrecip("");
        d1.setWind_direction("西北");
        d1.setWind_direction_degree("315");
        d1.setWind_scale("15");
        d1.setWind_speed("3");

        dailies.add(d1);

        data.setDaily(dailies);
		return data;
	}

}
