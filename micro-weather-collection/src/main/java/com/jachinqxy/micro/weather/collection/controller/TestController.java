package com.jachinqxy.micro.weather.collection.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test Controller.
 * 用于测试
 *
 * @since 2018年07月29日
 * @author Jachin
 */
@RestController
public class TestController {

	@RequestMapping("/test")
	public String hello() {
	    return "Success!";
	}

}
