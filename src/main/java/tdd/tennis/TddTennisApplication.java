package tdd.tennis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import tdd.tennis.configurations.ServiceConfig;

@SpringBootApplication
public class TddTennisApplication {

	public static void main(String[] args) {
		SpringApplication.run(TddTennisApplication.class, args);
	}
	
}

