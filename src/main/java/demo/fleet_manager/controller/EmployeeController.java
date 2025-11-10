package demo.fleet_manager.controller;

import demo.fleet_manager.entity.Employee;
import demo.fleet_manager.repository.EmployeeRepository;

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
    public Employee create(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
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
