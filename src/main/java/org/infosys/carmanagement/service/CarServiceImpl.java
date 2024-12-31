package org.infosys.carmanagement.service;

import java.util.List;

import org.infosys.carmanagement.exception.InvalidEntityException;
import org.infosys.carmanagement.model.Car;
import org.infosys.carmanagement.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarRepository repo;

	public Car addCar(Car car) {
		return repo.save(car);
		
	}

	public Car updateCar(Car car) {
		return repo.save(car);
		
		
	}
 
	public Car getCar(int carId) throws InvalidEntityException {
		return repo.findByCarId(carId)
				.orElseThrow(() -> new InvalidEntityException("Car with car Id " + carId + " not found."));
	}

	public List<Car> getAllCars() throws InvalidEntityException {
	    List<Car> cars = repo.findAll();
	    if (cars.isEmpty()) {
	        throw new InvalidEntityException("No cars available");
	    }
	    return cars;
	}


	public Car getCarByRegistrationNumber(String registrationNumber) throws InvalidEntityException {

		return repo.findByRegistrationNumber(registrationNumber)
				.orElseThrow(() -> new InvalidEntityException("Car with Registration Number " + registrationNumber + " not found."));
	}
	
	

}
