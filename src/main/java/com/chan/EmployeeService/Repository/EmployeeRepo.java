package com.chan.EmployeeService.Repository;

import com.chan.EmployeeService.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
