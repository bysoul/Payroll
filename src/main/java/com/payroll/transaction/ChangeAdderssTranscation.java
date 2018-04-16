package main.java.com.payroll.transaction;

import main.java.com.payroll.model.Employee;

public class ChangeAdderssTranscation extends ChangeEmployeeTranscation{
    String itsAddress;
    public ChangeAdderssTranscation(int empId,String address){
        super(empId);
        itsAddress=address;
    }
    void change(Employee e){
        e.setAddress(itsAddress);
    }
}
