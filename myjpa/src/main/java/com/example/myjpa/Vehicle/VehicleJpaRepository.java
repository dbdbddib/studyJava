package com.example.myjpa.Vehicle;

import com.example.myjpa.Vehicle.Type.IVehicleType;
import com.example.myjpa.Vehicle.Type.VehicleTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleJpaRepository extends JpaRepository<VehicleEntity, Long> {
    List<VehicleEntity> findAllByCompany(String company);
    List<VehicleEntity> findAllByModel(String model);
    List<VehicleEntity> findAllByColor(String color);
    Optional<VehicleEntity> findByFactoryNumber(String factoryNumber);
    Optional<VehicleEntity> findByRegistNumber(String registNumbery);
    List<VehicleEntity> findAllByMakeYear(int makeYear);
    List<VehicleEntity> findAllByType(VehicleTypeEntity type);
    List<VehicleEntity> findAllByTotalKm(int totalKm);
    List<VehicleEntity> findAllByStatus(VehicleStatus status);
}
