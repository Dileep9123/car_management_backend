package org.infosys.carmanagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Rental {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;

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
    @JoinColumn(name="registrationNumber")
	@JsonIgnoreProperties("bookings")
    private Car registrationNumber;
    
    @ManyToOne
    @JoinColumn(name="customerId")
	@JsonIgnoreProperties("bookings")
    private Customer customerId;


    public Rental(){
    }
    
    
   


	// Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }


    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Float getFare() {
        return fare;
    }

    public void setFare(Float fare) {
        this.fare = fare;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }


	public Employee getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}


	public Car getRegistrationNumber() {
		return registrationNumber;
	}


	public void setRegistrationNumber(Car registrationNumber) {
		this.registrationNumber = registrationNumber;
	}


	public Customer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

    
}