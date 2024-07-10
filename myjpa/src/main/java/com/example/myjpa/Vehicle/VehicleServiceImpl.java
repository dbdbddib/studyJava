package com.example.myjpa.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements IVehicleService{
    @Autowired
    private VehicleJpaRepository vehicleJpaRepository;

    private boolean isValidInsert(IVehicle dto) {
        if (dto == null) {
            return false;
        } else if (dto.getCompany() == null || dto.getCompany().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public IVehicle findById(Long id) {
        if( id == null || id <= 0){
            return null;
        }
        Optional<VehicleEntity> find = this.vehicleJpaRepository.findById(id);
        return find.orElse(null);
    }

    @Override
    public List<IVehicle> getAllList() {
        return this.getICategoryList(this.vehicleJpaRepository.findAll());
    }
    private List<IVehicle> getICategoryList(List<VehicleEntity> list) {
        if(list == null || list.size() <= 0){
            return new ArrayList<>();
        }
        return list.stream()
                .map(entity -> (IVehicle)entity)
                .toList();
    }

    @Override
    public IVehicle insert(IVehicle vehicle) throws Exception {
        if(!this.isValidInsert(vehicle)) {
            return null;
        }
        VehicleEntity entity = new VehicleEntity();
        entity.copyFields(vehicle);
        return this.vehicleJpaRepository.saveAndFlush(entity);
    }

    @Override
    public boolean remove(Long id) throws Exception {
        IVehicle find = this.findById(id);
        if (find == null) {
            return false;
        }
        this.vehicleJpaRepository.deleteById(id);
        return true;
    }

    @Override
    public IVehicle update(Long id, IVehicle vehicle) throws Exception {
        IVehicle find = this.findById(id);
        if (find == null) {
            return null;
        }
        find.copyFields(vehicle);
        return this.vehicleJpaRepository.saveAndFlush((VehicleEntity) find);
    }

    @Override
    public List<VehicleEntity> findAllByCompany(String company) {
        return List.of();
    }

    @Override
    public List<VehicleEntity> findAllByModel(String model) {
        return List.of();
    }

    @Override
    public List<VehicleEntity> findAllByColor(String color) {
        return List.of();
    }

    @Override
    public Optional<VehicleEntity> findByFactoryNumber(String factoryNumber) {
        return Optional.empty();
    }

    @Override
    public Optional<VehicleEntity> findByRegistNumber(String registNumbery) {
        return Optional.empty();
    }

    @Override
    public List<VehicleEntity> findAllByMakeYear(int makeYear) {
        return List.of();
    }

    @Override
    public List<VehicleEntity> findAllByType(IVehicle type) {
        return List.of();
    }

    @Override
    public List<VehicleEntity> findAllByTotalKm(int totalKm) {
        return List.of();
    }

    @Override
    public List<VehicleEntity> findAllByStatus(VehicleStatus status) {
        return List.of();
    }
}
