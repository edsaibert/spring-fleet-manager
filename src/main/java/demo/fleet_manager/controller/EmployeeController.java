package demo.fleet_manager.controller;

import demo.fleet_manager.entity.Employee;
import demo.fleet_manager.dtos.EmployeeDTO;
import demo.fleet_manager.repository.EmployeeRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Employee> all() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody EmployeeDTO newEmployeeDTO) {
        var employeeModel = new Employee();
        BeanUtils.copyProperties(newEmployeeDTO, employeeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(employeeModel));
    }

    @GetMapping("/{id}")
    public Employee one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
