package com.bean;

import java.io.Serializable;

public class EmployeeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String empName;
    private int empId;

    public EmployeeBean() {}

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
}