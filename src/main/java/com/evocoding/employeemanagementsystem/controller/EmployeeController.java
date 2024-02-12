package com.evocoding.employeemanagementsystem.controller;

import com.evocoding.employeemanagementsystem.service.EmployeeService;
import com.evocoding.employeemanagementsystem.service.dto.CreateEmployeeDTO;
import com.evocoding.employeemanagementsystem.service.dto.EmployeDTO;
import com.evocoding.employeemanagementsystem.service.dto.UpdateEmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateEmployeeDTO employeeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(employeeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UpdateEmployeeDTO updateEmployeeDTO) {
        service.update(id, updateEmployeeDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
