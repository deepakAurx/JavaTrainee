package com.aurx.main.officeproblem;

public class Department {
    private String deptName;

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }
public Department(){
}
public Department(String deptName){
        this.deptName=deptName;
}
    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + deptName + '\'' +
                '}';
    }
}
