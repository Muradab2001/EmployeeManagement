package evo.employeeManagement.service;

import evo.employeeManagement.exception.EmployeeNotFoundException;
import evo.employeeManagement.mapper.EmployeeMapper;
import evo.employeeManagement.repository.EmployeeRepository;
import evo.employeeManagement.repository.entity.Employee;
import evo.employeeManagement.service.dto.CreateEmployeeDTO;
import evo.employeeManagement.service.dto.EmployeDTO;
import evo.employeeManagement.service.dto.UpdateEmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final  EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public List<EmployeDTO> findAll() {
        var employees = employeeRepository.findAllByIsDeleted(false);
        return employeeMapper.toEmployeeList(employees);
    }


    public EmployeDTO findById(Long id) {
        return employeeMapper.toEmployeeDTO(getEmployee(id));
    }

    public Employee create(CreateEmployeeDTO createEmployeeDTO) {
        Employee employee = employeeMapper.toEmployee(createEmployeeDTO);
        return employeeRepository.save(employee);
    }

    public void update(Long id, UpdateEmployeeDTO updateEmployeeDTO) {
        Employee employee = getEmployee(id);
        employeeMapper.toEmployee(updateEmployeeDTO, employee);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    private Employee getEmployee(Long id) {
        return employeeRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id:" + id));
    }
}
