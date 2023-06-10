package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan("com.atm.management.model")
@ComponentScan(basePackages = {"com"})
@EnableJpaRepositories("com")
@SpringBootApplication
public class AtmManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmManagementSystemApplication.class, args);
	}

}
