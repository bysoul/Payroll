package main.java.com.payroll.transaction;

import main.java.com.payroll.model.Employee;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {
    String itsName;
    public ChangeNameTransaction(int empId,String name){
        super(empId);
        itsName=name;
    }
    void change(Employee e){
        e.setName(itsName);
    }
}
