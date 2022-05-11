package com.bridgelabz.addressbook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

 @SpringBootApplication
 @Slf4j
public class AddressBookAppApplication {
	public static void main(String[] args) {
		System.out.println("Welcome to AddressBook Application");
		ApplicationContext context = SpringApplication.run(AddressBookAppApplication.class, args);
		log.info("AddressBook App Started in {} Environment",
				context.getEnvironment().getProperty("environment"));
		log.info("AddressBook DB User is {} ",
				context.getEnvironment().getProperty("spring.datasource.username"));

	}
 }

