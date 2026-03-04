package com.chan.EmployeeService.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chan.EmployeeService.Service.EmployeeService;
import org.springframework.web.bind.annotation.RequestBody;
import com.chan.EmployeeService.DataTransferObject.MessageResponse;
import jakarta.validation.Valid;

import com.chan.EmployeeService.DataTransferObject.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import com.chan.EmployeeService.DataTransferObject.EmployeeRequest;
import com.chan.EmployeeService.DataTransferObject.MessageResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
  private final EmployeeService EService;

  @PostMapping
  public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeRequest ERequest) {
    EmployeeResponse RS = EService.createEmployee(ERequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(RS);
  }

  @GetMapping("/{id}")
  public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable long id) {
    return ResponseEntity.status(HttpStatus.OK).body(EService.getEmployeeById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<MessageResponse> deleteEmployeeById(@PathVariable long id) {
    return ResponseEntity.status(HttpStatus.OK).body(EService.deleteEmployeeById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<EmployeeResponse> updateEmployeeById(@RequestBody EmployeeRequest ERequest,
      @PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(EService.updateEmployeeById(ERequest, id));
  }

  @GetMapping
  public ResponseEntity<List<EmployeeResponse>> getAllEmployee() {
    return ResponseEntity.status(HttpStatus.OK).body(EService.getAllEmployee());
  }

}
