package com.jjbd.depot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class JJBDServiceApplication {

	/**
	 * Entry point for JJBD Service Application
	 *
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(JJBDServiceApplication.class, args);
	}
	
}
