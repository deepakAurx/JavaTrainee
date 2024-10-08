package com.aurx.main.officeproblem;

public class OfficeMain {
    public static void main(String[] args) {
        Office office = new Office();
        office.addEmployee(new Employee("deepak", "intern",new Department("HR")));
        office.addEmployee(new Employee("aakash", "employee",new Department("QA")));
        office.addEmployee(new Employee("Dev", "intern",new Department("QA")));
        office.addEmployee(new Employee("shivam", "employee",new Department("HR")));
        office.addEmployee(new Employee("shivam", "employee",new Department("Developer")));
//        System.out.println(office.getEmployees());
//        System.out.println("Getting single Employee: "+office.getEmployeeById("EMP--003"));
        System.out.println("Getting Employees By name: "+office.getEmployeesByName("shivam"));
//        System.out.println("Total Employees in office are: "+office.getEmployeeCount());
//        System.out.println("Employee Deleted: "+office.removeEmployee("EMP--003"));
//        System.out.println("Total Employees in office are: "+office.getEmployeeCount());

    }
}
