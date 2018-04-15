package main.java.com.payroll.transaction;

import main.java.com.Transaction;
import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.method.PaymentMethod;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.schedule.PaymentSchedule;

public class AddEmployeeTransaction implements Transaction {
    int empId;
    String itsAddress;
    String itsName;
    Employee e;
    PaymentClassification paymentClassification;
    PaymentSchedule paymentSchedule;
    PaymentMethod paymentMethod;

    //HoldMethod;
    public AddEmployeeTransaction(int id, String name,  String address){
        itsAddress=address;
        itsName=name;
        empId=id;
    }
    public PaymentClassification getPaymentClassification(){
        return paymentClassification;
    }
    public PaymentSchedule getPaymentSchedule(){
        return paymentSchedule;
    }
    public PaymentMethod getPaymentMethod(){
        return paymentMethod;
    }


    @Override
    public void execute() {

    }

    @Override
    public void validate() {

    }
}
