package org.infosys.carmanagement.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	@GetMapping("/filter")
	public ResponseEntity<?> filter(String company, BigDecimal mileage, BigDecimal rentalRate, String color, String location){
	    System.out.println(company.isEmpty() + " " + mileage +  " " + rentalRate + " " + color.isEmpty() + " " + location.isEmpty());
	    
	    try {
	        // Fetch all available cars
	        List<Car> cars = service.filtering();

	        // Start streaming the cars for further filtering
	        Stream<Car> carStream = cars.stream();
	        
	        // Apply filtering based on mileage (greater than or equal to the provided mileage)
	        if (mileage != null) {
	            carStream = carStream.filter(car -> car.getMileage().compareTo(mileage) >= 0);
	        }
	        
	        // Apply filtering based on rental rate (less than or equal to the provided rental rate)
	        if (rentalRate != null) {
	            carStream = carStream.filter(car -> car.getRentalRate().compareTo(rentalRate) <= 0);
	        }

	        // Apply filtering based on company if the company is provided
	        if (company != null && !company.isEmpty()) {
	            carStream = carStream.filter(car -> company.equals(car.getCompany()));
	        }

	        // Apply filtering based on color if the color is provided
	        if (color != null && !color.isEmpty()) {
	            carStream = carStream.filter(car -> color.equals(car.getColor()));
	        }

	        // Apply filtering based on location if the location is provided
	        if (location != null && !location.isEmpty()) {
	            carStream = carStream.filter(car -> location.equals(car.getLocation()));
	        }

	        // Collect the filtered cars into a list
	        List<Car> filteredCars = carStream.collect(Collectors.toList());
	        
	        // If no cars match the filters, throw an exception
	        if (filteredCars.isEmpty()) {
	            throw new InvalidEntityException("No cars available.");
	        }
	        
	        // Return the filtered cars in the response
	        return ResponseEntity.ok(filteredCars);
	    } catch (InvalidEntityException ex) {
	        // If no cars are found, return a 404 response with an appropriate message
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No cars available.");
	    }
	}

}
