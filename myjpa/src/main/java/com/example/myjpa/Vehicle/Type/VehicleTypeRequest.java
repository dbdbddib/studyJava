package com.example.myjpa.Vehicle.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleTypeRequest implements IVehicleType{
    @JsonIgnore
    private Long id;

    @NotNull
    @Size(min=2, max = 12)
    private String name;
}
