package main.java.com.payroll.transaction;

import main.java.com.Transaction;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.model.Employee;

public class ChangeEmployeeTranscation implements Transaction{
    int itsEmpId;
    public ChangeEmployeeTranscation(int empId){
        itsEmpId=empId;
    }
    void change(Employee e){

    }

    @Override
    public void execute() {
        Employee e= EmployeeDatabase.GpayrollDatebase.getEmployee(itsEmpId);
        if(e!=null)
            change(e);
    }

    @Override
    public void validate() {

    }
}
