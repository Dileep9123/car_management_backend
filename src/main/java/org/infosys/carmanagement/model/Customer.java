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
    @Builder.Default
    private int loyaltyPoints = 0;
    @Builder.Default
    private boolean blacklistStatus = false;
    private LocalDate dob; // Date of Birth
    private String drivingLicense; // Driving License
    
    @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("customerId")
    private List<Rental> bookings;


    

   
}

