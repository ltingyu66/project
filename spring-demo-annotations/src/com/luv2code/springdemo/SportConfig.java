package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	//bean for fortune
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	//bean for swim
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());	
	}

}
