package org.infosys.carmanagement.controller;

import java.util.List;


import org.infosys.carmanagement.model.Car;

import org.infosys.carmanagement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
	
	@Autowired
	private CarService service;
	
	@GetMapping("getCar/id/{id}")
	Car getCar(@PathVariable int id) {
		return service.getCar(id);
	}
	
	@GetMapping("getCar/registrationnumber/{registrationNumber}")
	ResponseEntity<Car> getCarByRegistrationNumber(@PathVariable String registrationNumber) {
		return new ResponseEntity<Car>(service.getCarByRegistrationNumber(registrationNumber), HttpStatus.OK);
	}
	
	
	
	
    @PostMapping("/addCar")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
    	  return new ResponseEntity<Car>(service.addCar(car), HttpStatus.CREATED);
    }
    
    @PutMapping("/updateCar")
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
    	return new ResponseEntity<Car>(service.updateCar(car), HttpStatus.OK);
    }
    
    @GetMapping("/getAllCars")
    public ResponseEntity<List<Car>> getAllCars(){
    	
    	return new ResponseEntity<List<Car>>(service.getAllCars(), HttpStatus.OK);
    }
    
}
