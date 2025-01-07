package org.infosys.carmanagement.model;

<<<<<<< HEAD
=======



>>>>>>> aa2fda93519fc792205b3dc4c497657dd5b03570
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
import java.math.BigDecimal;
import java.math.RoundingMode;


@Component
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "Registration number cannot be empty.")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*\\d)[A-Z0-9]+$", 
        message = "Registration number must be a combination of capital letters and numbers, and cannot include special characters."
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
    @Digits(integer = 10, fraction = 2, message = "Mileage must be a valid decimal number.")
    @Positive(message = "Mileage must be a positive number.")
    private BigDecimal mileage;
    
    @Column(nullable = false)
    @NotEmpty(message = "Color cannot be empty.")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Color must contain only alphabets and spaces.")
    private String color;


    @Column(nullable = false)
    @Min(value = 1, message = "Seating capacity must be greater than 0.")
    private Integer seatingCapacity;

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



    @Digits(integer = 10, fraction = 2, message = "Rental rate must be a valid decimal number.")
    @Positive(message = "Rental rate must be a positive number.")
    private BigDecimal rentalRate;
    
    @NotEmpty(message = "Color cannot be empty.")
    private String color;
    
    @NotEmpty(message = "Color cannot be empty.")
    private String location;

    
    @OneToMany(mappedBy = "bookingId", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("bookingId")
    private List<Rental> bookings;

    @OneToMany(mappedBy = "maintenanceId", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("maintenanceId")
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

    public BigDecimal getMileage() {
        return mileage;
    }


    public void setMileage(BigDecimal mileage) {
        if (mileage != null) {
            this.mileage = mileage.setScale(2, RoundingMode.HALF_UP);
        } else {
            this.mileage = null;
        }
    }
    
    public String getColor() {
    	return color;
    }
    
    public void setColor(String color) {
    	this.color=color;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
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

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        if (rentalRate != null) {
            this.rentalRate = rentalRate.setScale(2, RoundingMode.HALF_UP); // Rounds to 2 decimal places
        } else {
            this.rentalRate = null;
        }
    }
    
    public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
    
    

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", registrationNumber=" + registrationNumber + ", model=" + model + ", company="
				+ company + ", mileage=" + mileage + ", seatingCapacity=" + seatingCapacity + ", fuelType=" + fuelType
				+ ", insuranceNumber=" + insuranceNumber + ", carCondition=" + carCondition + ", currentStatus="
				+ currentStatus + ", rentalRate=" + rentalRate + ", color=" + color + ", bookings=" + bookings
				+ ", maintenance=" + maintenance + "]";
	}
    

	
    
    

}
