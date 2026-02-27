package com.chan.EmployeeService.Service;

import org.springframework.stereotype.Service;

import com.chan.EmployeeService.DataTransferObject.DepartmentRequest;
import com.chan.EmployeeService.DataTransferObject.DepartmentResponse;
import com.chan.EmployeeService.Entity.Department;
import com.chan.EmployeeService.Repository.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import com.chan.EmployeeService.Exceptions.ResourcenotfoundException;

@Service
@RequiredArgsConstructor
public class DepartmentService {

  private final DepartmentRepo DRepo;

  public DepartmentResponse createDepartment(DepartmentRequest DRequest) {
    Department d1 = new Department();
    d1.setName(DRequest.getName());
    d1.setDescription(DRequest.getDescription());
    Department saved = DRepo.save(d1);
    return maptoResponse(saved);
  }

  private DepartmentResponse maptoResponse(Department d) {
    return new DepartmentResponse(d.getId(), d.getName(), d.getDescription());
  }




  public DepartmentResponse getDepartmentById(Long id) {
    Department department = DRepo.findById(id).orElseThrow(() -> new ResourcenotfoundException("Department Id Not Found"+id));
    return maptoResponse(department);
  }
}
