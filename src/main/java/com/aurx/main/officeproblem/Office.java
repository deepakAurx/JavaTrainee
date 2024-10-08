package com.aurx.main.officeproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Office {
    private Map<String, Employee> employeeMap = new HashMap<>();
    private Map<String, List<Employee>> employeeNameMap = new HashMap<>();
    static int idCountIntern = 0;
    static int idCountEmployee = 0;

    public void addEmployee(Employee employee) {
        if (employee == null || employee.getEmployeeType() == null || employee.getEmployeeType().isEmpty()) {
            return;
        }
        String id;
        if (employee.getEmployeeType().equalsIgnoreCase("intern")) {
            id = "INT--00" + ++idCountIntern;
        } else if (employee.getEmployeeType().equalsIgnoreCase("employee")) {
            id = "EMP--00" + ++idCountEmployee;
        } else {
            return;
        }
        employee.setId(id);
        employeeMap.put(id, employee);
        List<Employee> employeeNameList = new ArrayList<>();
        if(employeeNameMap.containsKey(employee.getName())) {
            employeeNameList = employeeNameMap.get(employee.getName());
        } else {
            employeeNameMap.put(employee.getName(), employeeNameList);
        }
        employeeNameList.add(employee);

    }

    public Map<String, Employee> getEmployees() {
        return employeeMap;
    }

    public Employee getEmployeeById(String id) {
        if (id != null && !id.isEmpty()) {
            if (employeeMap.containsKey(id)) {
                return employeeMap.get(id);
            }
        }
        return null;
    }

    public List<Employee> getEmployeesByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            if (employeeNameMap.containsKey(name)) {
                 employeeList=employeeNameMap.get(name);
            }
        }
        return employeeList;
    }

    public int getEmployeeCount() {
        return employeeMap.size();
    }

    public boolean removeEmployee(String id) {
        if (id != null && !id.isEmpty()) {
            Employee employee = employeeMap.remove(id);
            if (employee != null) {
                List<Employee> employeeList = employeeNameMap.get(employee.getName());
                if (employeeList != null) {
                    employeeList.remove(employee);
                    if (employeeList.isEmpty()) {
                        employeeNameMap.remove(employee.getName());
                    }
                }
                return true;
            }
        }
        return false;
    }
}
