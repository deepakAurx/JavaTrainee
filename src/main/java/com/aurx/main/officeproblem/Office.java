package com.aurx.main.officeproblem;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<Employee> employeeList = new ArrayList<>();
    static int employeeCount=0;
   static int idCountIntern=0;
    static int idCountEmployee=0;
    public void addEmployee(Employee employee) {
        if (employee == null || employee.getEmployeeType() == null || employee.getEmployeeType().isEmpty()) {
            return; 
        }
        if(employee.getEmployeeType().equalsIgnoreCase("intern")) {
            String prefixId="INT--00";
            idCountIntern++;
            employee.setId(prefixId + idCountIntern);
        }
       else if(employee.getEmployeeType().equalsIgnoreCase("employee")) {
            String prefixId="EMP--00";
            idCountEmployee++;
            employee.setId(prefixId + idCountEmployee);
        }
       else{
           return;
        }
        employeeList.add(employee);
        employeeCount++;
    }

    public List<Employee> getEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(String id) {
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        return null;
    }

    public List<Employee> getEmployeesByName(String name) {
List<Employee> getByName=new ArrayList<>();
for (Employee emp:employeeList){
    if(emp.getName().equalsIgnoreCase(name)){
        getByName.add(emp);
    }
}
        return getByName;
    }

    public int getEmployeeCount(){

        return employeeCount;
    }

    public boolean removeEmployee(String id) {
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                employeeList.remove(emp);
                employeeCount--;
                return true;
            }
        }
        return false;
    }
}
