package com.example.myjpa.Vehicle;

import com.example.myjpa.Vehicle.Type.IVehicleType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto implements IVehicle {
    private Long id;
    private String company;
    private String model;
    private int makeYear;
    private IVehicleType type;
    private String color;
    private int totalKm;
    private String factoryNumber;
    private String registNumber;
    private VehicleStatus status;

    @Override
    public String toString() {
        return String.format("ID:%6d, company:%s, model:%s, makeYear:%20d, type:%s, " +
                        "color:%s, totalKm:%20d, factoryNumber:%s, registNumber:%s, status:%s"
                , this.id, this.company
                , this.model, this.makeYear, this.type
                , this.color, this.totalKm, this.factoryNumber
                , this.registNumber, this.status);
    }
}
