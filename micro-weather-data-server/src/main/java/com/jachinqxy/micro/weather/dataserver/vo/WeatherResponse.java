package com.jachinqxy.micro.weather.dataserver.vo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @since  2018/08/01 10:02
 * @author Jachin
 */
public class WeatherResponse implements Serializable {
    private ArrayList<Weather> results;

    public ArrayList<Weather> getResults() {
        return results;
    }

    public void setResults(ArrayList<Weather> results) {
        this.results = results;
    }
}
