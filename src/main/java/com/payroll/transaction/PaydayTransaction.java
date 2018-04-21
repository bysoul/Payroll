package main.java.com.payroll.transaction;

import main.java.com.Transaction;
import main.java.com.payroll.Date;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.pay.Paycheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaydayTransaction implements Transaction{
    Date itsPayDate;
    HashMap<Integer,Paycheck> itsPaychecks=new HashMap<>();
    public PaydayTransaction(Date payDate){
        itsPayDate=payDate;
    }
    @Override
    public void execute() {
        List<Integer> empIds=EmployeeDatabase.GpayrollDatebase.getAllEmployeeIds();
        for(int i:empIds){
            int empId=i;
            Employee e=EmployeeDatabase.GpayrollDatebase.getEmployee(empId);
            if(e!=null){
                if(e.isPayDate(itsPayDate)){
                    Paycheck pc=new Paycheck(e.getPayPeriodStartDate(itsPayDate),itsPayDate);
                    itsPaychecks.put(empId,pc);
                    e.payDay(pc);
                }
            }
        }
    }

    @Override
    public void validate() {

    }
    public Paycheck getPaycheck(int empId){
        return itsPaychecks.get(empId);
    }
}
