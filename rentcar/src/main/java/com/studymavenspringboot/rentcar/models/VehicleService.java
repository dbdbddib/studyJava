package com.studymavenspringboot.rentcar.models;

import java.util.List;

public interface VehicleService {
public Vehicle addVehicle(Vehicle v);
public boolean removeVehicle(Long l);
public Vehicle updateVehicle(Vehicle v);
public Vehicle findVehicleById(Long l);
public List<Vehicle> getAllVehicle();
public List<Vehicle> findVehicleForStatus(VehicleStatus v);

}
