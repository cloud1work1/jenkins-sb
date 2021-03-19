package com.tomgregory.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tomgregory.model.ThemeParkRide;
import com.tomgregory.repository.ThemeParkRideRepository;

@RestController
@RequestMapping("/ride")
public class ThemeParkRideController {

	@Autowired
	private ThemeParkRideRepository themeParkRideRepository;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<ThemeParkRide> findAll() {
		return themeParkRideRepository.findAll();
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ThemeParkRide findById(@PathVariable("id") Long id) {
		return themeParkRideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ride with id : "+id +" not present"));
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide themeParkRide) {
		return themeParkRideRepository.save(themeParkRide);
	}
}
