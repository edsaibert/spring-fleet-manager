package demo.fleet_manager.controller.user;

import demo.fleet_manager.dtos.user.AdminDTO;
import demo.fleet_manager.entity.user.Admin;
import demo.fleet_manager.repository.user.AdminRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminRepository repository;

    public AdminController(AdminRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Admin>> all() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    // Retirar depois -- o admin deve ser criado diretamente pelo banco, com algum script
    @PostMapping
    public ResponseEntity<Admin> create(@RequestBody AdminDTO newAdminDTO) {
        var adminModel = new Admin();
        BeanUtils.copyProperties(newAdminDTO, adminModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(adminModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> one(@PathVariable UUID id) {
        Admin admin = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        return ResponseEntity.status(HttpStatus.OK).body(admin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}