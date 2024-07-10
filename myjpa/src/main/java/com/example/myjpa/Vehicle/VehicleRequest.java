package com.example.myjpa.Vehicle;


import com.example.myjpa.Vehicle.Type.IVehicleType;
import com.example.myjpa.Vehicle.Type.VehicleTypeDto;
import com.example.myjpa.Vehicle.Type.VehicleTypeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VehicleRequest implements IVehicle{
    @JsonIgnore
    private Long id;

    @NotBlank
    private String company;

    @NotBlank
    private String model;

    @Positive
    @Min(1900)
    private int makeYear;

    @NotBlank
    private VehicleTypeDto type;

    @NotBlank
    private String color;

    @Positive
    @Min(0)
    private int totalKm;

    @NotBlank
    private String factoryNumber;

    @NotBlank
    private String registNumber;

    @NotBlank
    private VehicleStatus status;

    @Override
    public void setType(IVehicleType vehicleType){
        if(vehicleType == null){
            return;
        }
        VehicleTypeDto entity = new VehicleTypeDto();
        entity.copyFields(vehicleType);
        this.type= entity;
    }
}
