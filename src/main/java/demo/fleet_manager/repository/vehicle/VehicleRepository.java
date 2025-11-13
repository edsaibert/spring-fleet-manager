package demo.fleet_manager.repository.vehicle;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.fleet_manager.entity.vehicle.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID>{
}
