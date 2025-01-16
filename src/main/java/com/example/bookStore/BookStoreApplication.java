package com.example.bookStore;

import com.example.bookStore.Configuration.DynamoDbConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.amazon.awssdk.regions.servicemetadata.DynamodbServiceMetadata;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);


	}

}
