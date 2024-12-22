package org.infosys.carmanagement.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Component
@Entity
public class Car {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String registrationNumber;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private int maileage;

    @Column(nullable = false)
    private int seatingCapacity;

    @Column(nullable = false)
    private String fuelType;

    @Column(nullable = false)
    private String insuranceNumber;

    @Column(nullable = false)
    private String carCondition;

    @Column(nullable = false)
    private String currentStatus;

    @Column(nullable = false)
    private double rentalRate;

    @Column(nullable = false)
    private Date previousServiceDate;

    @Column(nullable = false)
    private Date nextServiceDate;

    @Column(nullable = false)
    private String maintenanceStatus;
	 
	 public Car() {
		 
	 }
	 
	public Car(int id, String registrationNumber, String model, String company, int maileage, int seatingCapacity,
			String fuelType, String insuranceNumber, String carCondition, String currentStatus, double rentalRate,
			Date previousServiceDate, Date nextServiceDate, String maintenanceStatus) {
		super();
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.model = model;
		this.company = company;
		this.maileage = maileage;
		this.seatingCapacity = seatingCapacity;
		this.fuelType = fuelType;
		this.insuranceNumber = insuranceNumber;
		this.carCondition = carCondition;
		this.currentStatus = currentStatus;
		this.rentalRate = rentalRate;
		this.previousServiceDate = previousServiceDate;
		this.nextServiceDate = nextServiceDate;
		this.maintenanceStatus = maintenanceStatus;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getMaileage() {
		return maileage;
	}
	public void setMaileage(int maileage) {
		this.maileage = maileage;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getInsuranceNumber() {
		return insuranceNumber;
	}
	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}
	public String getCarCondition() {
		return carCondition;
	}
	public void setCondition(String carCondition) {
		this.carCondition = carCondition;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public Date getPreviousServiceDate() {
		return previousServiceDate;
	}
	public void setPreviousServiceDate(Date previousServiceDate) {
		this.previousServiceDate = previousServiceDate;
	}
	public Date getNextServiceDate() {
		return nextServiceDate;
	}
	public void setNextServiceDate(Date nextServiceDate) {
		this.nextServiceDate = nextServiceDate;
	}
	public String getMaintenanceStatus() {
		return maintenanceStatus;
	}
	public void setMaintenanceStatus(String maintenanceStatus) {
		this.maintenanceStatus = maintenanceStatus;
	}	 
}
