package main.java.com.payroll.transaction;

import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.classification.SalariedClassification;
import main.java.com.payroll.schedule.MonthlySchedule;
import main.java.com.payroll.schedule.PaymentSchedule;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction {
    double itsSalary;
    public ChangeSalariedTransaction(int empId,double salary){
        super(empId);
        itsSalary=salary;
    }

    @Override
    PaymentClassification getClassification() {
        return new SalariedClassification(itsSalary);
    }

    @Override
    PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }
}
