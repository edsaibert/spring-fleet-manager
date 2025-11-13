package demo.fleet_manager.repository.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.fleet_manager.entity.user.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
