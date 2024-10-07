package com.aurx.main.officeproblem;

public class Employee {
    private String id;
    private String name;
    private String employeeType;
    private Department department;

    public Employee(String name, String employeeType, Department department) {
        this.name = name;
        this.employeeType = employeeType;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeeType='" + employeeType + '\'' +
               ", department=" + department +
                '}';
    }
}
