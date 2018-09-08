package com.jahcinqxy.micro.weather.reportserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test Controller.
 * @since 2018/08/02
 * @author Jachin
 */
@RestController
public class TestController {

	@RequestMapping("/test")
	public String hello() {
	    return "Success!";
	}

}
