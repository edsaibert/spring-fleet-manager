package demo.fleet_manager.dtos.vehicle;

import java.util.UUID;

import jakarta.annotation.Nonnull;

public record VehicleDTO (@Nonnull String brand, @Nonnull String model, UUID curr_employee){
}
