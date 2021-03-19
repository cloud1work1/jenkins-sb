package com.tomgregory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tomgregory.model.ThemeParkRide;
import com.tomgregory.repository.ThemeParkRideRepository;

@SpringBootApplication
public class JenkinsSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsSbApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner sampleData(ThemeParkRideRepository themeParkRideRepository) {
		return (args)-> {
			themeParkRideRepository.save(new ThemeParkRide("RollerCoaster Ride", "Train Ride", 5, 3));
			themeParkRideRepository.save(new ThemeParkRide("Long Flume", "Boat Ride", 3, 2));
			themeParkRideRepository.save(new ThemeParkRide("TeaCups", "Spinning Ride", 2, 4));
		};
	}

}
