package com.evocoding.employeemanagementsystem.mapper;


import com.evocoding.employeemanagementsystem.service.dto.CreateEmployeeDTO;
import com.evocoding.employeemanagementsystem.service.dto.EmployeDTO;
import com.evocoding.employeemanagementsystem.service.dto.UpdateEmployeeDTO;
import com.evocoding.employeemanagementsystem.repository.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeDTO toEmployeeDTO(Employee employee);
    Employee toEmployee(CreateEmployeeDTO createEmployeeDTO);
    void toEmployee(UpdateEmployeeDTO updateEmployeeDTO, @MappingTarget Employee employee);

    List<EmployeDTO> toEmployeeList(List<Employee> employeeList);
}