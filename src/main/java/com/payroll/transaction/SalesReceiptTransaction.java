package main.java.com.payroll.transaction;

import main.java.com.Transaction;
import main.java.com.payroll.Date;
import main.java.com.payroll.SalesReceipt;
import main.java.com.payroll.TimeCard;
import main.java.com.payroll.classification.CommissionedClassifition;
import main.java.com.payroll.classification.HourlyClassification;
import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.model.Employee;

public class SalesReceiptTransaction implements Transaction {
    Date date;
    double amount;
    int empId;
    public SalesReceiptTransaction(Date date,double amount,int empId){
        this.date=date;
        this.amount=amount;
        this.empId=empId;
    }

    @Override
    public void execute() {
        Employee e= EmployeeDatabase.GpayrollDatebase.getEmployee(empId);
        if(e!=null){
            CommissionedClassifition cc=null;
            try{
                PaymentClassification pc=e.getClassification();
                cc=(CommissionedClassifition) pc;
            }
            catch (Exception ex){
                System.out.println("Employee is non-commissioned payed.");
            }
            cc.addSalesReceipt(new SalesReceipt(date,amount));
        }
        else{
            System.out.println("No such employee");
        }
    }

    @Override
    public void validate() {

    }
}
