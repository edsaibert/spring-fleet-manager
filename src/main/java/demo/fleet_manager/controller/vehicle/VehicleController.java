package demo.fleet_manager.controller.vehicle;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import demo.fleet_manager.dtos.vehicle.VehicleDTO;
import demo.fleet_manager.entity.vehicle.Vehicle;
import demo.fleet_manager.repository.vehicle.VehicleRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleRepository repository;

    public VehicleController(VehicleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> all() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Vehicle> create(@RequestBody VehicleDTO newVehicleDTO) {
        var vehicleModel = new Vehicle();
        BeanUtils.copyProperties(newVehicleDTO, vehicleModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(vehicleModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> one(@PathVariable UUID id) {
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        return ResponseEntity.status(HttpStatus.OK).body(vehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        repository.deleteById(id);  
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
