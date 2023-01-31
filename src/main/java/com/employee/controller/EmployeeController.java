package com.employee.controller;

import com.employee.model.Employee;
import com.employee.model.entity.EmployeeEntity;
import com.employee.service.EmployeeServiceRestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceRestImpl employeeService;

    @GetMapping("/allEmp")
    public Iterable<EmployeeEntity> getAllEmployee(){
        return employeeService.getAllEmp();
    }
    @GetMapping("/{empId}")
    public EmployeeEntity getEmpDetailsById(@PathVariable("empId") Integer empId){
        return employeeService.getEmployeeById(empId);
    }
    @PostMapping("/addEmp")
    public String addEmp(@RequestBody Employee emp) {
        return employeeService.addEmp(emp);
    }
    @PutMapping("/update")
    public String updateEmp(@RequestBody Employee emp){
        return employeeService.updateDetail(emp);
    }
    @DeleteMapping("/delete/{empID}")
    public String deleteEmp(@PathVariable("empId") Integer empId){
        return employeeService.deleteEmpById(empId);
    }
}
