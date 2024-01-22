package com.training.learning;

import com.training.learning.domain.Services;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearningApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
	}

	@Bean
	Services services() {
		return new Services(12345);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
