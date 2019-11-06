package com.cg.onlinetraining;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.onlinetraining.config.JwtAuthTokenFilter;

@SpringBootApplication
public class OnlineTrainingApplication {
	private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);
	public static void main(String[] args) {
		SpringApplication.run(OnlineTrainingApplication.class, args);
		logger.info("Online Training Management System running .....");
	}

}
