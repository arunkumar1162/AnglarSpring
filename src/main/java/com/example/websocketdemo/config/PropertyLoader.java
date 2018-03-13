/**
 * 
 */
package com.example.websocketdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.example.websocketdemo.model.EnvironmentConfig;

/**
 * @author amkumar
 *
 */
@Configuration
@PropertySource("classpath:enviprop.properties")
public class PropertyLoader {

	 @Autowired
     Environment env;

     @Bean
     public EnvironmentConfig testBean() {
    	 EnvironmentConfig testBean = new EnvironmentConfig();
         testBean.setServerIP(env.getProperty("env.server.ip"));
         return testBean;
     }
	
}
