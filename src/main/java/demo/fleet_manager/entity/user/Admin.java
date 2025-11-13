package demo.fleet_manager.entity.user;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Admin extends BaseUser {
    @Override
    protected String getDefaultRole() {
        return "ADMIN";
    }
}