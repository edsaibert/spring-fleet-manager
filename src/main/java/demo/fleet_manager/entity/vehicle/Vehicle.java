package demo.fleet_manager.entity.vehicle;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;
import demo.fleet_manager.dtos.vehicle.VehicleDTO;

@Entity
@Data
public class Vehicle {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   @Column(name = "id", updatable = false, nullable = false) 
   private UUID id;

   protected String brand;
   protected String model;
   protected UUID curr_employee;

   public Vehicle() {}

   public Vehicle(VehicleDTO data) {
       this.brand = data.getBrand();
       this.model = data.getModel();
       this.curr_employee = data.getCurr_employee();
   }
}