package com.saikumar.ManyToMany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.saikumar.ManyToMany")
@SpringBootApplication
public class ManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

}
