package com.rubyren.firstsearch.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages="com.rubyren")
public class Application {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
