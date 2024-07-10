package com.example.myjpa.Vehicle;


import com.example.myjpa.Vehicle.Type.IVehicleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleRequest implements IVehicle{
    @JsonIgnore
    private Long id;

    @NotBlank
    private String company;

    @NotBlank
    private String model;

    @NotBlank
    @Size(min = 0, max = 4)
    private int makeYear;

    @NotBlank
    private IVehicleType type;

    @NotBlank
    private String color;

    @NotBlank
    private int totalKm;

    @NotBlank
    private String factoryNumber;

    @NotBlank
    private String registNumber;

    @NotBlank
    private VehicleStatus status;
}
