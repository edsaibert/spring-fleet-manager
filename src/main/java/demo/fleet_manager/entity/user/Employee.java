package demo.fleet_manager.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Employee extends BaseUser {
   @Override
   protected String getDefaultRole() {
    return "EMPLOYEE";
   } 
}
