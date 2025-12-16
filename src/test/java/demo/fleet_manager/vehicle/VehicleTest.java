package demo.fleet_manager.vehicle;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;

import demo.fleet_manager.dtos.vehicle.VehicleDTO;
import demo.fleet_manager.entity.vehicle.Vehicle;
import demo.fleet_manager.repository.vehicle.VehicleRepository;
import jakarta.persistence.EntityManager;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class VehicleTest {
    
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    EntityManager entityManager;
    
    @Test
    @DisplayName("Deve buscar todos os veículos cadastrados")
    public void findAllSuccess(){
        VehicleDTO vehicleData1 = new VehicleDTO("Toyota", "Corolla", UUID.randomUUID());
        VehicleDTO vehicleData2 = new VehicleDTO("Honda", "Civic", UUID.randomUUID());
        
        creatVehicle(vehicleData1);
        creatVehicle(vehicleData2);

        List<Vehicle> vehicles = vehicleRepository.findAll();
        
        assertEquals(2, vehicles.size());
    } 

    private Vehicle creatVehicle(VehicleDTO data){
        Vehicle vehicle = new Vehicle(data);
        entityManager.persist(vehicle);
        entityManager.flush();
        return vehicle;
    }

}
