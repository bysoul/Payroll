package main.java.com.payroll.database;

import main.java.com.payroll.model.Employee;

import java.util.HashMap;

public class EmployeeDatabase {
    public static EmployeeDatabase GpayrollDatebase=new EmployeeDatabase();
    HashMap<Integer,Employee> hm=new HashMap<>();
    public Employee getEmployee(int empId){
        return hm.get(empId);
    }
    public void addEmployee(int empId,Employee e){
        hm.put(empId,e);
    }
    public void removeEmployee(int empId){
        hm.remove(empId);
    }

}
