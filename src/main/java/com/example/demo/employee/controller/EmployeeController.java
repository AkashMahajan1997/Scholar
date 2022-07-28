package com.example.demo.employee.controller;


import com.example.demo.employee.ResouceNotFoundException;
import com.example.demo.employee.model.Employee;
import com.example.demo.employee.repository.EmployeeRepository;
import com.example.demo.student.Student;
import com.example.demo.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private StudentService studentService;

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        return employeeRepository.save(employee);
    }


    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("employees/{id}")
    @Cacheable(value = "student",key ="#id")
    public Student findEmployeeById(@PathVariable(value = "id") Integer id) {
        System.out.println("Student fetching from database:: "+id);
        return studentService.getStudent(id);

    }


    @PutMapping("employees/{employeeId}")
    @CachePut(value = "employees",key = "#employeeId")
    public Employee updateEmployee(@PathVariable(value = "employeeId") Integer employeeId,
                                                   @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResouceNotFoundException("Employee not found for this id :: " + employeeId));
        employee.setName(employeeDetails.getName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;

    }


    @DeleteMapping("employees/{id}")
    @CacheEvict(value = "employees", allEntries = true)
    public void deleteEmployee(@PathVariable(value = "id") Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResouceNotFoundException("Employee not found" + employeeId));
        employeeRepository.delete(employee);
    }
}
