package com.studymavenspringboot.rentcar.models;

import java.util.List;

public class VehicleServiceImpl implements VehicleService{
    @Override
    public Vehicle addVehicle(Vehicle v) {
        return null;
    }

    @Override
    public boolean removeVehicle(Long l) {
        return false;
    }

    @Override
    public Vehicle updateVehicle(Vehicle v) {
        return null;
    }

    @Override
    public Vehicle findVehicleById(Long l) {
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return List.of();
    }

    @Override
    public List<Vehicle> findVehicleForStatus(VehicleStatus v) {
        return List.of();
    }
}
