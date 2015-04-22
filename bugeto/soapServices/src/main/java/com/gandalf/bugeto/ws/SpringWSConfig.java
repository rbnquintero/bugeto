package com.gandalf.bugeto.ws;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringWSConfig {
	
	@Bean
	public SimpleDateFormat dateFormat(){
		return new SimpleDateFormat("dd-MM-yyyy");
	}
	
}
