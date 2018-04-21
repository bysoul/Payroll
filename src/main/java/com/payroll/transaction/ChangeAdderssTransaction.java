package main.java.com.payroll.transaction;

import main.java.com.payroll.model.Employee;

public class ChangeAdderssTransaction extends ChangeEmployeeTransaction{
    String itsAddress;
    public ChangeAdderssTransaction(int empId,String address){
        super(empId);
        itsAddress=address;
    }
    void change(Employee e){
        e.setAddress(itsAddress);
    }
}
