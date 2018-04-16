package main.java.com.payroll.transaction;

import main.java.com.payroll.model.Employee;

public class ChangeNameTranscation extends ChangeEmployeeTranscation {
    String itsName;
    public ChangeNameTranscation(int empId,String name){
        super(empId);
        itsName=name;
    }
    void change(Employee e){
        e.setName(itsName);
    }
}
