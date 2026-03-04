package com.chan.EmployeeService.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chan.EmployeeService.Service.EmployeeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

import com.chan.EmployeeService.DataTransferObject.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import com.chan.EmployeeService.DataTransferObject.EmployeeRequest;
import com.chan.EmployeeService.DataTransferObject.MessageResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class EmployeeController {
  private final EmployeeService EService;

  @PostMapping
  public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeRequest ERequest) {
    EmployeeResponse RS = EService.createEmployee(ERequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(RS);
  }

}
