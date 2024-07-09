package com.example.myjpa.Vehicle.Type;

import java.util.List;

public interface IVehicleTypeService {
    IVehicleType findById(Long id);
    IVehicleType findByName(String name);
    List<IVehicleType> getAllList();
    IVehicleType insert(IVehicleType category) throws Exception;
    boolean remove(Long id) throws Exception;
    IVehicleType update(Long id, IVehicleType category) throws Exception;
}
