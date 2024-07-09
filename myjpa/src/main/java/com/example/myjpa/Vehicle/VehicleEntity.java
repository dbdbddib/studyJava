package com.example.myjpa.Vehicle;


import com.example.myjpa.Vehicle.Type.IVehicleType;
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
    @Column(length = 20, unique = true)
    private String company;

    @NotNull
    @Column(length = 20, unique = true)
    private String model;

    @NotNull
    @Column(length = 20, unique = true)
    private int makeYear;

    @NotNull
    @Column(length = 20, unique = true)
    private IVehicleType type;

    @NotNull
    @Column(length = 20, unique = true)
    private String color;

    @NotNull
    @Column(length = 7, unique = true)
    private int totalKm;

    @NotNull
    @Column(length = 20, unique = true)
    private String factoryNumber;

    @NotNull
    @Column(length = 20, unique = true)
    private String registNumber;

    @NotNull
    @Column(length = 20, unique = true)
    private VehicleStatus status;

    @Override
    public int getTotalKM() {
        return 0;
    }
}
