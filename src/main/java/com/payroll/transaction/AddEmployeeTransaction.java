package main.java.com.payroll.transaction;

import main.java.com.Transaction;
import main.java.com.payroll.affilition.NoAffilition;
import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.classification.SalariedClassification;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.method.HoldMethod;
import main.java.com.payroll.method.PaymentMethod;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.schedule.MonthlySchedule;
import main.java.com.payroll.schedule.PaymentSchedule;

public class AddEmployeeTransaction implements Transaction {
    int empId;
    String itsAddress;
    String itsName;
    Employee e;
    PaymentClassification paymentClassification;
    PaymentSchedule paymentSchedule;
    PaymentMethod paymentMethod;

    public AddEmployeeTransaction(int id, String name,  String address){
        itsAddress=address;
        itsName=name;
        empId=id;
    }
    int getEmployeeId(){
        return empId;
    }
    String getName(){
        return itsName;
    }
    String getAddress(){
        return itsAddress;
    }

    PaymentClassification getPaymentClassification(){
        return paymentClassification;
    }
    PaymentSchedule getPaymentSchedule(){
        return paymentSchedule;
    }



    @Override
    public void execute() {
        Employee e = new Employee(this.getEmployeeId(), this.getName(), this.getAddress());
        e.setPaymentClassification(getPaymentClassification());
        e.setPaymentSchedule(getPaymentSchedule());
        e.setPaymentMethod(new HoldMethod());
        e.setAffiliation(new NoAffilition());
        EmployeeDatabase.GpayrollDatebase.addEmployee(this.getEmployeeId(),e);

    }

    @Override
    public void validate() {

    }
}
