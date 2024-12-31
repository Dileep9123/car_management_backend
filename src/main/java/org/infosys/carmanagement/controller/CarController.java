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
	
	@GetMapping("getCar/id/{carId}")
	Car getCar(@PathVariable int carId) throws InvalidEntityException {
		return service.getCar(carId);
	}
	
	@GetMapping("getCar/registrationnumber/{registrationNumber}")
	ResponseEntity<Car> getCarByRegistrationNumber(@PathVariable String registrationNumber) throws InvalidEntityException {
		return new ResponseEntity<Car>(service.getCarByRegistrationNumber(registrationNumber), HttpStatus.OK);
	}
	
	
	
	

    @PostMapping("/addCar")
    public ResponseEntity<Car> addCar(@Validated @RequestBody Car car) {
    	  return new ResponseEntity<Car>(service.addCar(car), HttpStatus.OK);
    }

    
    @PutMapping("/updateCar")
    public ResponseEntity<Car> updateCar(@Validated @RequestBody Car car){
    	return new ResponseEntity<Car>(service.updateCar(car), HttpStatus.OK);
    }
    
    @GetMapping("/getAllCars")
    public ResponseEntity<List<Car>> getAllCars()throws InvalidEntityException {
    	
    	return new ResponseEntity<List<Car>>(service.getAllCars(), HttpStatus.OK);
    }
    
}
