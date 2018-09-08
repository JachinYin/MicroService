package com.jachinqxy.micro.weather.dataserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test Controller.
 * @since 2018/07/30
 * @author Jachin
 */
@RestController
public class TestController {

	@RequestMapping("/test")
	public String hello() {
	    return "Success!";
	}

}
