package com.example.myjpa.Vehicle.Type;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleTypeJpaRepository extends JpaRepository<VehicleTypeEntity, Long> {
    Optional<VehicleTypeEntity> findByName(String name);
}
