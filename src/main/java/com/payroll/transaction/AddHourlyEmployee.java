package main.java.com.payroll.transaction;

import main.java.com.payroll.classification.HourlyClassification;
import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.classification.SalariedClassification;
import main.java.com.payroll.schedule.MonthlySchedule;
import main.java.com.payroll.schedule.PaymentSchedule;
import main.java.com.payroll.schedule.WeeklySchedule;

public class AddHourlyEmployee extends AddEmployeeTransaction{
    double itsHourlyRate;
    public AddHourlyEmployee(int id, String name, String home, double hourlyRate){
        super(id,name,home);
        itsHourlyRate=hourlyRate;
    }
    public PaymentClassification getPaymentClassification(){
        paymentClassification=new HourlyClassification(itsHourlyRate);
        return paymentClassification;
    }
    public PaymentSchedule getPaymentSchedule(){
        return new WeeklySchedule();
    }

}
