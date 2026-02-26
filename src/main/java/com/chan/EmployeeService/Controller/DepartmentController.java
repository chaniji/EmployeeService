package com.chan.EmployeeService.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.chan.EmployeeService.Service.DepartmentService;

import jakarta.validation.Valid;

import com.chan.EmployeeService.DataTransferObject.DepartmentRequest;
import com.chan.EmployeeService.DataTransferObject.DepartmentResponse;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
  private final DepartmentService DService;

  @PostMapping("/create")
  public ResponseEntity<DepartmentResponse> postMethodName(@RequestBody @Valid DepartmentRequest DRequest) {
    DepartmentResponse rs = DService.createDepartment(DRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(rs);
  }

}
