package main.java.com.payroll.transaction;

import main.java.com.Transaction;
import main.java.com.payroll.database.EmployeeDatabase;

public class DeleteEmployee implements Transaction{
    int itsEmpId;
    public DeleteEmployee(int empId){
        itsEmpId=empId;
    }
    public void validate(){

    }
    public void execute(){
        EmployeeDatabase.GpayrollDatebase.removeEmployee(itsEmpId);

    }
}
