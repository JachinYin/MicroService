package com.jahcinqxy.micro.weather.reportserver.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @since 2018/08/01 10:32
 * @author Jachin
 */
public class Weather {
    private Location location;
    private ArrayList<Daily> daily;
    private Date last_update;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<Daily> getDaily() {
        return daily;
    }

    public void setDaily(ArrayList<Daily> daily) {
        this.daily = daily;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
