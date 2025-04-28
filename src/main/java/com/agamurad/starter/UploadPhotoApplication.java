package com.agamurad.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.agamurad"})
@EnableMongoRepositories(basePackages = "com.agamurad.repository")
public class UploadPhotoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadPhotoApplication.class, args);
	}

}
