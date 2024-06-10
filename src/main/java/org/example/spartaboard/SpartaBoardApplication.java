package org.example.spartaboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class SpartaBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpartaBoardApplication.class, args);
	}

}
