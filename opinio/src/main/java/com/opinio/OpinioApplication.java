package com.opinio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.opinio")
public class OpinioApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpinioApplication.class, args);
	}
}
