package com.gandalf.bugeto.config;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.gandalf.bugeto.util.Properties;

@Configuration
@ComponentScan({ "com.gandalf.bugeto.service.impl" })
@PropertySource(value = { "classpath:application.properties", "classpath:environment.properties" })
public class SpringConfig {
	@Bean
	public Properties properties() {
		return new Properties();
	}
	
	@Bean
	public SimpleDateFormat dateFormat(){
		return new SimpleDateFormat("dd-MM-yyyy");
	}
}
