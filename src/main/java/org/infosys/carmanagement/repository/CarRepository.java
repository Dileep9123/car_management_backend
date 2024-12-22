package org.infosys.carmanagement.repository;

import java.util.List;

import org.infosys.carmanagement.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CarRepository extends JpaRepository<Car, Integer> {

	
	Car findByRegistrationNumber(String registrationNumber);
     
	 
}
