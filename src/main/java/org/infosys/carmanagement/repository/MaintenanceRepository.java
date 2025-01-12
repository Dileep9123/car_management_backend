package org.infosys.carmanagement.repository;

import org.infosys.carmanagement.model.Car;
import org.infosys.carmanagement.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
    Optional<Maintenance> findTopByCarIdOrderByDateDesc(Car car);
}
