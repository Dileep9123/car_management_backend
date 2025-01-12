package org.infosys.carmanagement.model;

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

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String name;
    private Long phoneNumber;
    private String address;
    private String email;
    private String password;
    private int loyaltyPoints = 0;
    private boolean blacklistStatus = false;
    private LocalDate dob; // Date of Birth
    private String drivingLicense; // Driving License
    
    @OneToMany(mappedBy = "bookingId", cascade =CascadeType.ALL)
    @JsonIgnoreProperties("bookingId")
    private List<Rental> bookings;

    

   
}