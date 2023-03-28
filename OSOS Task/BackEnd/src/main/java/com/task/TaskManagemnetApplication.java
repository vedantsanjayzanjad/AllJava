package com.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagemnetApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagemnetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Program Started");
	}

}
