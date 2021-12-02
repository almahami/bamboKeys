package io.rest.BambooKeys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.rest.BambooKeys.service.InitializationTest;

@SpringBootApplication
public class BambooKeysApplication {

	@Autowired
	private InitializationTest initializationTest;



	public static void main(String[] args) {
		SpringApplication.run(BambooKeysApplication.class, args);
	}

	@Bean
	CommandLineRunner init(){
		return (evt)->{
			
			initializationTest.initUserDB();
		};
	}
}
