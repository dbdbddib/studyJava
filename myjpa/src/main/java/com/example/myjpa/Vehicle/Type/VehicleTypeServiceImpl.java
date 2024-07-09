package com.example.myjpa.Vehicle.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeServiceImpl implements IVehicleTypeService {
    @Autowired
    private VehicleTypeJpaRepository vehicleTypeJpaRepository;

    private boolean isValidInsert(IVehicleType dto) {
        if (dto == null) {
            return false;
        } else if (dto.getName() == null || dto.getName().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public IVehicleType findById(Long id) {
            if( id == null || id <= 0){
                return null;
            }
            Optional<VehicleTypeEntity> find = this.vehicleTypeJpaRepository.findById(id);
            return (IVehicleType) find.orElse(null);   // find의 값이 없으면 null로 리턴..
    }

    @Override
    public IVehicleType findByName(String name) {
            Optional<VehicleTypeEntity> byName = this.vehicleTypeJpaRepository.findByName(name);
            return (IVehicleType) byName.orElse(null);
    }

    @Override
    public List<IVehicleType> getAllList() {
        return this.getICategoryList(this.vehicleTypeJpaRepository.findAll());
    }
    private List<IVehicleType> getICategoryList(List<VehicleTypeEntity> list) {
        if(list == null || list.size() <= 0){
            return new ArrayList<>();
        }
        return list.stream()
                .map(entity -> (IVehicleType)entity)
                .toList();
    }

    @Override
    public IVehicleType insert(IVehicleType vehicleType) throws Exception {
        if(!this.isValidInsert(vehicleType)) {
            return null;
        }
        VehicleTypeEntity entity = new VehicleTypeEntity();
        entity.copyFields(vehicleType);
        return this.vehicleTypeJpaRepository.saveAndFlush(entity);
    }

    @Override
    public boolean remove(Long id) throws Exception {
        IVehicleType find = this.findById(id);
        if (find == null) {
            return false;
        }
        this.vehicleTypeJpaRepository.deleteById(id);
        return true;
    }

    @Override
    public IVehicleType update(Long id, IVehicleType vehicleType) throws Exception {
        IVehicleType find = this.findById(id);
        if (find == null) {
            return null;
        }
        find.copyFields(vehicleType);
        return this.vehicleTypeJpaRepository.saveAndFlush((VehicleTypeEntity) find);
    }


}
