package demo.fleet_manager.entity.user;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseUser {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    protected String name;

    @Column(nullable = false)
    private String role;

    @PrePersist
    protected void prePersist() {
        if (role == null) {
            role = getDefaultRole();
        }
    }

    protected abstract String getDefaultRole();
}