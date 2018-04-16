package main.java.com.payroll.transaction;

import main.java.com.payroll.classification.CommissionedClassifition;
import main.java.com.payroll.classification.HourlyClassification;
import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.schedule.BiweeklySchedule;
import main.java.com.payroll.schedule.PaymentSchedule;
import main.java.com.payroll.schedule.WeeklySchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
    double itsSalary;
    double itsCommissionRate;
    public AddCommissionedEmployee(int id, String name, String home, double salary,double commissionRate){
        super(id,name,home);
        itsSalary=salary;
        itsCommissionRate=commissionRate;
    }
    public PaymentClassification getPaymentClassification(){
        paymentClassification=new CommissionedClassifition(itsSalary,itsCommissionRate);
        return paymentClassification;
    }
    public PaymentSchedule getPaymentSchedule(){
        return new BiweeklySchedule();
    }
}
