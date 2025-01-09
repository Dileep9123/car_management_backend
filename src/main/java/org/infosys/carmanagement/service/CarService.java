package org.infosys.carmanagement.service;

import java.math.BigDecimal;
import java.util.List;

import org.infosys.carmanagement.exception.InvalidEntityException;
import org.infosys.carmanagement.model.Car;

public interface CarService {
	
	public Car addCar(Car car);

	public Car updateCar(Car car) throws InvalidEntityException;

	public Car getCar(int carId) throws InvalidEntityException;

	public List<Car> getAllCars() throws InvalidEntityException;

	public Car getCarByRegistrationNumber(String registrationNumber)  throws InvalidEntityException;
	
	public List<Car> filtering() throws InvalidEntityException;

}