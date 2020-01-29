package com.bridgelabz.fundoonotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"your.company.domain.package"})
public class FundoonoteApplication {

	public static void main(String[] args) {
		//System.setProperty("server.port", "8081");
		SpringApplication.run(FundoonoteApplication.class, args);
	}

}

/*
 * import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		System.setProperty("server.port", "8081");
		// or use
		// System.getProperties().put("server.port", 8081);

		SpringApplication.run(Main.class, args);
	}
}
 * */


