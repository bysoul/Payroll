package main.java.com.payroll.transaction;

import main.java.com.Transaction;
import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.schedule.PaymentSchedule;

public class ChangeClassificationTransaction extends ChangeEmployeeTransaction {
    public ChangeClassificationTransaction(int empId){
        super(empId);
    }
    PaymentClassification getClassification(){
        return null;
    }
    PaymentSchedule getSchedule(){
        return null;
    }
    void change(Employee e){
        e.setPaymentClassification(getClassification());
        e.setPaymentSchedule(getSchedule());
    }
}
