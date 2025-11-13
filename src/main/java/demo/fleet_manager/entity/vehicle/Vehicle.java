package demo.fleet_manager.entity.vehicle;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vehicle {
   @Id
   @GeneratedValue(generator = "UUID")
   @Column(name = "id", updatable = false, nullable = false) 
   private UUID id;

   protected String brand;
   protected String model;
   protected UUID curr_employee;
}
