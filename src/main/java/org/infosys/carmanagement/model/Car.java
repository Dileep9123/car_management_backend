package org.infosys.carmanagement.model;

import java.time.LocalDate;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;

@Component
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "Registration number cannot be empty.")
    @Pattern(
        regexp = "^[A-Z]{1,2}\\d{2}[A-Z]{1,2}\\d{1,4}$",
        message = "Registration number must be in the format: {state code}{2 digits}{1-2 alphabets}{1-4 digits}."
    )
    private String registrationNumber;

    @Column(nullable = false)
    @NotEmpty(message = "Model cannot be empty.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Model must contain only alphanumeric characters and spaces.")
    private String model;

    @Column(nullable = false)
    @NotEmpty(message = "Company name cannot be empty.")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Company name must contain only alphabets and spaces.")
    private String company;

    @Column(nullable = false)
    @Min(value = 1, message = "Mileage must be greater than 0.")
    private double mileage;

    @Column(nullable = false)
    @Min(value = 1, message = "Seating capacity must be greater than 0.")
    private int seatingCapacity;

    @Column(nullable = false)
    @NotEmpty(message = "Fuel type cannot be empty.")
    private String fuelType;

    @Column(nullable = false)
    @NotEmpty(message = "Insurance number cannot be empty.")
    @Pattern(
        regexp = "^INS\\d{10}$",
        message = "Insurance number must be in the format: INS followed by 10 digits."
    )
    private String insuranceNumber;

    @Column(nullable = false)
    @NotEmpty(message = "Car condition cannot be empty.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Car condition must not contain special characters except spaces.")
    private String carCondition;

    @Column(nullable = false)
    @NotEmpty(message = "Current status cannot be empty.")
    private String currentStatus;

    @Column(nullable = false)
    @Min(value = 1, message = "Rental rate must be greater than Basic Prize 250.")
    private double rentalRate;

    @Column(nullable = false)
    @PastOrPresent(message = "Previous service date must be in the past or today.")
    private LocalDate previousServiceDate;

    @Column(nullable = false)
    @Future(message = "Next service date must be in the future.")
    private LocalDate nextServiceDate;

    @Column(nullable = false)
    @NotEmpty(message = "Maintenance status cannot be empty.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Maintenance status must not contain special characters except spaces.")
    private String maintenanceStatus;



    @OneToMany(mappedBy = "bookingId", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("bookingId")
    private List<Rental> bookings;

    @OneToMany(mappedBy = "maintenanceId", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("bookingId")
    private List<Maintenance> maintenance;

    public Car() {}

    // Getters and setters

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
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

    public double getMaileage() {
        return mileage;
    }

    public void setMaileage(double mileage) {
        this.mileage = mileage;
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

    public void setCarCondition(String carCondition) {
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

    public LocalDate getPreviousServiceDate() {
        return previousServiceDate;
    }

    public void setPreviousServiceDate(LocalDate previousServiceDate) {
        this.previousServiceDate = previousServiceDate;
    }

    public LocalDate getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(LocalDate nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    public List<Rental> getBookings() {
        return bookings;
    }

    public void setBookings(List<Rental> bookings) {
        this.bookings = bookings;
    }

    public List<Maintenance> getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(List<Maintenance> maintenance) {
        this.maintenance = maintenance;
    }

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", registrationNumber=" + registrationNumber + ", model=" + model + ", company="
				+ company + ", maileage=" + mileage + ", seatingCapacity=" + seatingCapacity + ", fuelType=" + fuelType
				+ ", insuranceNumber=" + insuranceNumber + ", carCondition=" + carCondition + ", currentStatus="
				+ currentStatus + ", rentalRate=" + rentalRate + ", previousServiceDate=" + previousServiceDate
				+ ", nextServiceDate=" + nextServiceDate + ", maintenanceStatus=" + maintenanceStatus + ", bookings="
				+ bookings + ", maintenance=" + maintenance + "]";
	}
    
    

}
