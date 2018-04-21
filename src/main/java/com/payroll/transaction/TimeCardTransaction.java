package main.java.com.payroll.transaction;

import main.java.com.Transaction;
import main.java.com.payroll.TimeCard;
import main.java.com.payroll.classification.HourlyClassification;
import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.Date;

public class TimeCardTransaction implements Transaction{
    Date date;
    double hours;
    int empId;
    public TimeCardTransaction(Date date,double hours,int empId){
        this.date=date;
        this.hours=hours;
        this.empId=empId;
    }

    @Override
    public void execute() {
        Employee e= EmployeeDatabase.GpayrollDatebase.getEmployee(empId);
        if(e!=null){
            HourlyClassification hc=null;
            try{
                PaymentClassification pc=e.getClassification();
                hc=(HourlyClassification)pc;
            }
            catch (Exception ex){
                System.out.println("Employee is non-hourly payed.");
            }
            hc.addTimeCard(new TimeCard(date,hours));
        }
        else{
            System.out.println("No such employee");
        }

    }

    @Override
    public void validate() {

    }
}
