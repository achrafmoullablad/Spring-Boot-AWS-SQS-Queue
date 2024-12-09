package com.achrafmoullablad.aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootAwsSqsQueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAwsSqsQueueApplication.class, args);
	}

}
