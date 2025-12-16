package demo.fleet_manager.dtos.vehicle;

import java.util.UUID;

import jakarta.annotation.Nonnull;

public record VehicleDTO (@Nonnull String brand, @Nonnull String model, UUID curr_employee){
    public String getBrand(){
        return brand;
    };

    public String getModel(){
        return model;
    };

    public UUID getCurr_employee(){
        return curr_employee;
    };
}

