package org.infosys.carmanagement.service;

import java.util.List;

import org.infosys.carmanagement.model.Car;
import org.infosys.carmanagement.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repo;

	public Car addCar(Car car) {
		return repo.save(car);
		
	}

	public Car updateCar(Car car) {
		return repo.save(car);
		
		
	}

	public Car getCar(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<Car> getAllCars() {
		return repo.findAll();
	}

	public Car getCarByRegistrationNumber(String registrationNumber) {

		return repo.findByRegistrationNumber(registrationNumber);
	}
	
	

}
