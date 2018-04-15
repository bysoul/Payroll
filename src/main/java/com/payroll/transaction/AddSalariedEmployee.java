package main.java.com.payroll.transaction;

import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.classification.SalariedClassification;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.method.HoldMethod;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.schedule.MonthlySchedule;

public class AddSalariedEmployee extends AddEmployeeTransaction {
    double itsSalary;
    public AddSalariedEmployee( int id, String name, String home, double salary){
        super(id,name,home);
        itsSalary=salary;
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

    @Override
    public void execute() {
        Employee e = new Employee(this.getEmployeeId(), this.getName(), this.getAddress());
        paymentClassification= new SalariedClassification(itsSalary);
        paymentSchedule=new MonthlySchedule();
        paymentMethod=new HoldMethod();
        e.setPaymentClassification(getPaymentClassification());
        e.setPaymentSchedule(getPaymentSchedule());
        e.setPaymentMethod(getPaymentMethod());
        EmployeeDatabase.GpayrollDatebase.addEmployee(this.getEmployeeId(),e);
    }

    @Override
    public void validate() {

    }
}
