/**
 * 
 */
package com.example.websocketdemo.service.helper;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.example.websocketdemo.config.PropertyLoader;
import com.example.websocketdemo.model.EnvironmentConfig;

/**
 * @author amkumar
 *
 */
@Service
public class Helper {

	public EnvironmentConfig getEnvironmentBean() {
		
	    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PropertyLoader.class);
		EnvironmentConfig myBean = ctx.getBean(EnvironmentConfig.class);
		ctx.close();
		return myBean;
	
	}

}
