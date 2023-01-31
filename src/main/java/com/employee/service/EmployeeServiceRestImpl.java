package com.employee.service;

import com.employee.dao.EmployeeService;
import com.employee.model.Employee;
import com.employee.model.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceRestImpl  {

    private final EmployeeService employeeService;

    public EmployeeServiceRestImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public Iterable<EmployeeEntity> getAllEmp(){
        return employeeService.findAll();
    }
    public String addEmp(Employee emp) {
      boolean flag = employeeService.existsById(emp.getEmpId());
      if(!flag){
          EmployeeEntity employeeEntity =new EmployeeEntity();
          employeeEntity.setEmpId(emp.getEmpId());
          employeeEntity.setEmpDepartment(emp.getEmpDepartment());
          employeeEntity.setEmpName(emp.getEmpName());
          employeeEntity.setMobileNo(emp.getMobileNo());
          employeeService.save(employeeEntity);
          return "Successfully added the details";
        } else {
          return "Employee Id Already exist";
      }
    }
    public String updateDetail(Employee emp) {
        if(employeeService.existsById(emp.getEmpId()))  {
            EmployeeEntity employeeEntity =new EmployeeEntity();
            employeeEntity.setEmpId(emp.getEmpId());
            employeeEntity.setEmpDepartment(emp.getEmpDepartment());
            employeeEntity.setEmpName(emp.getEmpName());
            employeeEntity.setMobileNo(emp.getMobileNo());
            employeeService.save(employeeEntity);
            return "Update done";
        } else {
            return "Update cannot be done as emp id is missing";
        }
    }

    public EmployeeEntity getEmployeeById(Integer empId){
        return employeeService.findById(empId).get();
    }

    public String deleteEmpById(Integer empId){
        boolean flag = employeeService.existsById(empId);
        if(flag){
            EmployeeEntity employeeEntity = employeeService.findById(empId).get();
            employeeService.delete(employeeEntity);
            return "Deletion done Successfully";
        }
        else {
            return "Employee id doesn't exist";
        }
    }
}
