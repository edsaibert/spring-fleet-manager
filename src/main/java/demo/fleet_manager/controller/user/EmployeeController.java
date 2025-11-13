package demo.fleet_manager.controller.user;

import demo.fleet_manager.dtos.user.EmployeeDTO;
import demo.fleet_manager.entity.user.Employee;
import demo.fleet_manager.repository.user.EmployeeRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> all() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody EmployeeDTO newEmployeeDTO) {
        var employeeModel = new Employee();
        BeanUtils.copyProperties(newEmployeeDTO, employeeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(employeeModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> one(@PathVariable UUID id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
