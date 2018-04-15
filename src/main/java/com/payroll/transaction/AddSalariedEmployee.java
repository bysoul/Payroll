package main.java.com.payroll.transaction;

import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.classification.SalariedClassification;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.method.HoldMethod;
import main.java.com.payroll.method.PaymentMethod;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.schedule.MonthlySchedule;
import main.java.com.payroll.schedule.PaymentSchedule;

public class AddSalariedEmployee extends AddEmployeeTransaction {
    double itsSalary;
    public AddSalariedEmployee( int id, String name, String home, double salary){
        super(id,name,home);
        itsSalary=salary;
     }
    public PaymentClassification getPaymentClassification(){
        paymentClassification=new SalariedClassification(itsSalary);
        return paymentClassification;
    }
    public PaymentSchedule getPaymentSchedule(){
        return new MonthlySchedule();
    }


    @Override
    public void validate() {

    }
}
