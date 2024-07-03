package com.studymavenspringboot.rentcar.models;

public class MotorCycle implements Vehicle{

private Long id;
private String company;
private String model;
private int makeYear;
private VehicleType type;
private String color;
private int totalKm;
private String factoryNumber;
private String registNumber;
private VehicleStatus status;

    @Override
    public Long getId() {
        return 0L;
    }

    @Override
    public String getCompany() {
        return "";
    }

    @Override
    public String getModel() {
        return "";
    }

    @Override
    public int getMakeYear() {
        return 0;
    }

    @Override
    public VehicleType getType() {
        return null;
    }

    @Override
    public String getColor() {
        return "";
    }

    @Override
    public int getTotalKM() {
        return 0;
    }

    @Override
    public String getFactoryNumber() {
        return "";
    }

    @Override
    public String getRegistNumber() {
        return "";
    }

    @Override
    public VehicleStatus getStatus() {
        return null;
    }

    @Override
    public Long setId() {
        return 0L;
    }

    @Override
    public String setCompany() {
        return "";
    }

    @Override
    public String setModel() {
        return "";
    }

    @Override
    public int setMakeYear() {
        return 0;
    }

    @Override
    public VehicleType setType() {
        return null;
    }

    @Override
    public String setColor() {
        return "";
    }

    @Override
    public int setTotalKm() {
        return 0;
    }

    @Override
    public String setFactoryNumber() {
        return "";
    }

    @Override
    public String setRegistNumber() {
        return "";
    }

    @Override
    public VehicleStatus setStatus() {
        return null;
    }
}
