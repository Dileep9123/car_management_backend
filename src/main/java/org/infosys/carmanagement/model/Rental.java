package org.infosys.carmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Rental {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private String pickupLocation;
    private String dropLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private Float fare;
    private Float discount;
    private String bookingStatus;

 

    @ManyToOne
    @JoinColumn(name="employeeId")
	@JsonIgnoreProperties("bookings")
    private Employee employeeId;
    
    @ManyToOne
    @JoinColumn(name="carId")
	@JsonIgnoreProperties("bookings")
    private Car carId;
    
    @ManyToOne
    @JoinColumn(name="customerId")
	@JsonIgnoreProperties("bookings")
    private Customer customerId;
 
}