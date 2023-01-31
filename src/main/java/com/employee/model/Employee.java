package com.employee.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
public class Employee {

    private Integer empId;
    private String empName;
    private String empDepartment;
    private String mobileNo;

    public Employee(Integer empId, String empName, String empDepartment, String mobileNo) {
        this.empId = empId;
        this.empName = empName;
        this.empDepartment = empDepartment;
        this.mobileNo = mobileNo;
    }
}
