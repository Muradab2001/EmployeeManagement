package evo.employeeManagement.mapper;


import evo.employeeManagement.repository.entity.Employee;
import evo.employeeManagement.service.dto.CreateEmployeeDTO;
import evo.employeeManagement.service.dto.EmployeDTO;
import evo.employeeManagement.service.dto.UpdateEmployeeDTO;
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