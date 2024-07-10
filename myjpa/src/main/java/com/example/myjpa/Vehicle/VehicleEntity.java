package com.example.myjpa.Vehicle;


import com.example.myjpa.Vehicle.Type.IVehicleType;
import com.example.myjpa.Vehicle.Type.VehicleTypeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="vehicle_tbl")
public class VehicleEntity  implements IVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 20)
    private String company;

    @NotNull
    @Column(length = 20)
    private String model;

    @NotNull
    private int makeYear;

    @ManyToOne  // 하나의 차량 유형은 여러 차량에 적용될 수 있기 때문
    @JoinColumn(name="vehicleType_tbl")
    private VehicleTypeEntity type;

    @NotNull
    @Column(length = 20)
    private String color;

    @NotNull
    private int totalKm;

    @NotNull
    @Column(length = 20, unique = true)
    private String factoryNumber;

    @NotNull
    @Column(length = 20, unique = true)
    private String registNumber;

    @NotNull
    @Column(length = 20)
    private VehicleStatus status;

    @Override
    public void setType(IVehicleType vehicleType) {
        if(vehicleType == null){
            return;
        }
        VehicleTypeEntity entity = new VehicleTypeEntity();
        entity.copyFields(vehicleType);
        this.type = entity;
    }
}
