package com.example.myjpa.Vehicle.Type;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vt")

public class VehicleTypeControllor {
    private static Logger logger = LoggerFactory.getLogger(VehicleTypeControllor.class);

    @Autowired
    private IVehicleTypeService vehicleTypeService;

    @PostMapping
    public ResponseEntity<IVehicleType> insertC(@RequestBody VehicleTypeRequest dto) {
        try {
            if (dto == null) {
                return ResponseEntity.badRequest().build();
            }
            IVehicleType result = this.vehicleTypeService.insert(dto);
            if (result == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<IVehicleType>> getAll() {
        try {
            List<IVehicleType> result = this.vehicleTypeService.getAllList();
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        try {
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }
            boolean result = this.vehicleTypeService.remove(id);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<IVehicleType> update(@PathVariable Long id, @RequestBody VehicleTypeRequest dto) {
        try {
            if (id == null || dto == null) {
                return ResponseEntity.badRequest().build();
            }
            IVehicleType result = this.vehicleTypeService.update(id, dto);
            if (result == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }
}
