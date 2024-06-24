package com.studymavenspringboot.rentcar.models;

public interface Vehicle {
    public Long getId();
    public String getCompany();
    public String getModel();
    public int getMakeYear();
    public VehicleType getType();
    public String getColor();
    public int getTotalKM();
    public String getFactoryNumber();
    public String getRegistNumber();
    public VehicleStatus getStatus();
    public Long setId();
    public String setCompany();
    public String setModel();
    public int setMakeYear();
    public VehicleType setType();
    public String setColor();
    public int setTotalKm();
    public String setFactoryNumber();
    public String setRegistNumber();
    public VehicleStatus setStatus();
}
