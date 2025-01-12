package org.infosys.carmanagement.model;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private String location;

    
    @OneToMany(mappedBy = "bookingId", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("bookingId")
    private List<Rental> bookings;

    @OneToMany(mappedBy = "maintenanceId", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("maintenanceId")
    private List<Maintenance> maintenance;
    
    

   

}
