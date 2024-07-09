package com.example.myjpa.Vehicle;

import com.example.myjpa.Vehicle.Type.IVehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleJpaRepository extends JpaRepository<VehicleEntity, Long> {
    Optional<VehicleEntity> findByCompany(String company);
    Optional<VehicleEntity> findByModel(String model);
    Optional<VehicleEntity> findByColor(String color);
    Optional<VehicleEntity> findByFactoryNumber(String factoryNumber);
    Optional<VehicleEntity> findByRegistNumber(String registNumbery);
    Optional<VehicleEntity> findByMakeYear(int makeYear);
    Optional<VehicleEntity> findByType(IVehicleType type);
    Optional<VehicleEntity> findByTotalKM(int totalKM);
    Optional<VehicleEntity> findByStatus(VehicleStatus status);
}
