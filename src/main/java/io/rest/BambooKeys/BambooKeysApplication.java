package io.rest.BambooKeys;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;
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
			initializationTest.initProductDB();
			initializationTest.initRequest();
			initializationTest.initReviw();
		};
	}
}
