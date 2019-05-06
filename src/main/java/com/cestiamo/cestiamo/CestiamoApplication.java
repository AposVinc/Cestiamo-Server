package com.cestiamo.cestiamo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CestiamoApplication {

	@Bean
	public CommandLineRunner loadData() {
		return (args) -> {
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CestiamoApplication.class, args);
	}

}
