package com.jachinqxy.micro.weather.cityserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test Controller.
 * @since 2018年07月30日
 * @author Jachin
 */
@RestController
public class TestController {

	@RequestMapping("/test")
	public String hello() {
	    return "Success!";
	}

}
