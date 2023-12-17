package com.jacekg.teamfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@PropertySource("classpath:application-docker.properties")
@PropertySource("classpath:secrets.properties")
@PropertySource("classpath:secrets-docker.properties")
public class TeamFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamFinderApplication.class, args);
	}
}
