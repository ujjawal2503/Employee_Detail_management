package com.employee.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Getter
@Setter
@Entity
public class EmployeeEntity {

    @Id
    private Integer empId;
    private String empName;
    private String empDepartment;
    private String mobileNo;
}
