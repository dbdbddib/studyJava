package com.example.myjpa.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    IVehicle findById(Long id);
    List<IVehicle> getAllList();
    IVehicle insert(IVehicle vehicle) throws Exception;
    boolean remove(Long id) throws Exception;
    IVehicle update(Long id, IVehicle vehicle) throws Exception;
    List<VehicleEntity> findAllByCompany(String company);
    List<VehicleEntity> findAllByModel(String model);
    List<VehicleEntity> findAllByColor(String color);
    Optional<VehicleEntity> findByFactoryNumber(String factoryNumber);
    Optional<VehicleEntity> findByRegistNumber(String registNumbery);
    List<VehicleEntity> findAllByMakeYear(int makeYear);
    List<VehicleEntity> findAllByType(IVehicle type);
    List<VehicleEntity> findAllByTotalKm(int totalKm);
    List<VehicleEntity> findAllByStatus(VehicleStatus status);
}
