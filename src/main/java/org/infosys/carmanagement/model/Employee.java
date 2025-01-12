package org.infosys.carmanagement.model;


import java.time.LocalDate;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    private String fullName;
    private String contactNumber;
    private LocalDate dob;
    private String accountType;
    private String emailId;
    private String password;
    private LocalDate expiryDate; 
    private boolean firstLogin = true;
    
    @OneToMany(mappedBy = "bookingId", cascade =CascadeType.ALL)
    @JsonIgnoreProperties("bookingId")
    private List<Rental> bookings;

    
   

  
}