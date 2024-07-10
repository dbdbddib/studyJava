package com.example.myjpa.Vehicle;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vc")
public class VehicleControllor {

    private static Logger logger = LoggerFactory.getLogger(VehicleControllor.class);

    @Autowired
    private IVehicleService vehicleService;

    @PostMapping
    public ResponseEntity<IVehicle> insertC(@RequestBody VehicleRequest dto) {
        try {
            if (dto == null) {
                return ResponseEntity.badRequest().build();
            }
            IVehicle result = this.vehicleService.insert(dto);
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
    public ResponseEntity<List<IVehicle>> getAll() {
        try {
            List<IVehicle> result = this.vehicleService.getAllList();
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
            boolean result = this.vehicleService.remove(id);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<IVehicle> update(@PathVariable Long id, @RequestBody VehicleRequest dto) {
        try {
            if (id == null || dto == null) {
                return ResponseEntity.badRequest().build();
            }
            IVehicle result = this.vehicleService.update(id, dto);
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
