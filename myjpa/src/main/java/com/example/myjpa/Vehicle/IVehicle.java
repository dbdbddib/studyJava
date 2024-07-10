package com.example.myjpa.Vehicle;

import com.example.myjpa.Vehicle.Type.IVehicleType;

public interface IVehicle {
    Long getId();
    void setId(Long id);

    String getCompany();
    void setCompany(String company);

    String getModel();
    void setModel(String model);

    int getMakeYear();
    void setMakeYear(int makeYear);

    IVehicleType getType();
    void setType(IVehicleType type);

    String getColor();
    void setColor(String color);

    int getTotalKm();
    void setTotalKm(int totalKm);

    String getFactoryNumber();
    void setFactoryNumber(String factoryNumber);

    String getRegistNumber();
    void setRegistNumber(String registNumber);

    VehicleStatus getStatus();
    void setStatus(VehicleStatus status);


    default void copyFields(IVehicle from) {
        if (from == null) {
            return;
        }
        if (from.getId() != null) {
            this.setId(from.getId());
        }
        if (from.getCompany() != null && !from.getCompany().isEmpty()) {
            this.setCompany(from.getCompany());
        }
        if (from.getModel() != null && !from.getModel().isEmpty()) {
            this.setModel(from.getModel());
        }
        if (from.getMakeYear() < 0) {
            this.setMakeYear(from.getMakeYear());
        }
        if (from.getType() != null) {
            this.setType(from.getType());
        }
        if (from.getColor() != null && !from.getColor().isEmpty()) {
            this.setColor(from.getColor());
        }
        if (from.getTotalKm() < 0) {
            this.setTotalKm(from.getTotalKm());
        }
        if (from.getFactoryNumber() != null && !from.getFactoryNumber().isEmpty()) {
            this.setFactoryNumber(from.getFactoryNumber());
        }
        if (from.getRegistNumber() != null && !from.getRegistNumber().isEmpty()) {
            this.setRegistNumber(from.getRegistNumber());
        }
        if (from.getStatus() != null) {
            this.setStatus(from.getStatus());
        }
    }
}
