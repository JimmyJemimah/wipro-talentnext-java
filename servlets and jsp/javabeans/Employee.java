public class Employee {
    
}
package com.bean;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String designation;

    public Employee() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
}