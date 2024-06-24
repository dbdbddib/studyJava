package com.studymavenspringboot.rentcar.models;

import java.util.List;

public class VehicleJSONRepository implements VehicleRepository{
    @Override
    public boolean save(List<Vehicle> save) {
        return false;
    }

    @Override
    public boolean load(List<Vehicle> load) {
        return false;
    }
}
