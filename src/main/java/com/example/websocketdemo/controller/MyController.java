package com.example.websocketdemo.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.websocketdemo.model.EnvironmentConfig;
import com.example.websocketdemo.service.helper.Helper;


/**
 * @author amkumar
 *
 */
@RestController
public class MyController {
	
	@Autowired
	Helper helper;

	@GetMapping("/delay/{sec}")
	public String CreateDelay(@PathVariable("sec") long delay) {

		EnvironmentConfig myBean = helper.getEnvironmentBean();

		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getProperty("env.server.ip");

	}
	
	private String getProperty(String s) {
		Properties prop = new Properties();

		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("enviprop.properties"));
		} catch (java.io.IOException e) {
			System.out.println(e);
		}

		return prop.getProperty(s);

	}

}
