package test.java.com.payroll.transaction;

import main.java.com.payroll.classification.HourlyClassification;
import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.classification.SalariedClassification;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.method.HoldMethod;
import main.java.com.payroll.method.PaymentMethod;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.schedule.MonthlySchedule;
import main.java.com.payroll.schedule.PaymentSchedule;
import main.java.com.payroll.schedule.WeeklySchedule;
import main.java.com.payroll.transaction.AddHourlyEmployee;
import main.java.com.payroll.transaction.AddSalariedEmployee;
import main.java.com.payroll.transaction.DeleteEmployee;

public class TestDeleteEmployee {
    public static void main(String[] args){
        int empId=3;
        AddHourlyEmployee t=new AddHourlyEmployee(3,"Lance","Home",300);
        t.execute();
        Employee e=EmployeeDatabase.GpayrollDatebase.getEmployee(empId);
        assert e!=null;
        DeleteEmployee de=new DeleteEmployee(empId);
        de.execute();
        e=EmployeeDatabase.GpayrollDatebase.getEmployee(empId);
        assert e==null;
    }

}
