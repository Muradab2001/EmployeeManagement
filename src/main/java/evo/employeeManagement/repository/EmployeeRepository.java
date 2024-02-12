package evo.employeeManagement.repository;

import evo.employeeManagement.repository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByIsDeleted(boolean isDeleted);

    Optional<Employee> findByIdAndIsDeleted(Long id, boolean isDeleted);
}
