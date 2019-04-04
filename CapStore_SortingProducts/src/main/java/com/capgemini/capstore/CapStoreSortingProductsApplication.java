package com.capgemini.capstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = { "com.capgemini.capstore" })
@EntityScan(basePackages = "com.capgemini.capstore.beans")
public class CapStoreSortingProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapStoreSortingProductsApplication.class, args);
	}

}
