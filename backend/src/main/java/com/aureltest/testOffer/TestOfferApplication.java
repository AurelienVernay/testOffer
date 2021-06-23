package com.aureltest.testOffer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath:spring-context.xml" })
public class TestOfferApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestOfferApplication.class, args);
	}

}
