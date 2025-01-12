package org.infosys.carmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "maintenance")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maintenanceId;
    
    @ManyToOne
    @JoinColumn(name="carId")
	@JsonIgnoreProperties("maintenance")
    private Car carId;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "cost")
    private Double cost;

    @Setter
    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;
    
    
    
    


    
}


