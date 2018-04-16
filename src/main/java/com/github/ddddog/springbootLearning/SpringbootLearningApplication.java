package com.github.ddddog.springbootLearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class SpringbootLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLearningApplication.class, args);
	}
}
