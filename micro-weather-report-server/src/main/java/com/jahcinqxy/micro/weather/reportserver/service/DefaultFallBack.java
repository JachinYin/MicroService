package com.jahcinqxy.micro.weather.reportserver.service;

import com.jahcinqxy.micro.weather.reportserver.vo.City;
import com.jahcinqxy.micro.weather.reportserver.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @des:
 * @author Jachin
 * @since  2018/8/9 09:48
 */
@Component
public class DefaultFallBack implements DataService{
    // 默认返回一个城市的数据
    @Override
    public List<City> getCityIdList() throws Exception {
        City city = new City();
        city.setCityCode("guangzhou");
        city.setCityName("广州");
        List<City> list = new ArrayList<>();
        list.add(city);
        return list;
    }

    // 天气数据为空
    @Override
    public WeatherResponse getReportByCityCode(String cityCode) {

        return null;
    }
}
