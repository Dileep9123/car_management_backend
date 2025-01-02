package org.infosys.carmanagement.controller;

import java.util.List;

import org.infosys.carmanagement.exception.InvalidEntityException;
import org.infosys.carmanagement.model.Car;

import org.infosys.carmanagement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class CarController {
	
	@Autowired
	private CarService service;

	// Fetch car by ID
	@GetMapping("getCar/id/{carId}")
	public ResponseEntity<?> getCar(@PathVariable int carId) {
		try {
			Car car = service.getCar(carId);
			return ResponseEntity.ok(car);
		} catch (InvalidEntityException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found with ID: " + carId);
		}
	}

	// Fetch car by registration number
	@GetMapping("getCar/registrationnumber/{registrationNumber}")
	public ResponseEntity<?> getCarByRegistrationNumber(@PathVariable String registrationNumber) {
		try {
			Car car = service.getCarByRegistrationNumber(registrationNumber);
			return ResponseEntity.ok(car);
		} catch (InvalidEntityException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter a valid registration number");
		}
	}

	// Add a new car
	@PostMapping("/addCar")
	public ResponseEntity<Car> addCar(@Validated @RequestBody Car car) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addCar(car));
	}

	// Update existing car details
	@PutMapping("/updateCar")
	public ResponseEntity<?> updateCar(@Validated @RequestBody Car car) {
		try {
			Car updatedCar = service.updateCar(car);
			return ResponseEntity.ok(updatedCar);
		} catch (InvalidEntityException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to update car. Car not found.");
		}
	}

	// Fetch all cars
	@GetMapping("/getAllCars")
	public ResponseEntity<?> getAllCars() {
		try {
			List<Car> cars = service.getAllCars();
			return ResponseEntity.ok(cars);
		} catch (InvalidEntityException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No cars available.");
		}
	}
}
