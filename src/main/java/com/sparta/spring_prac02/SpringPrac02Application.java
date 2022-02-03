package com.sparta.spring_prac02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringPrac02Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringPrac02Application.class, args);
	}

}
