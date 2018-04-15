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

public class TestAddHourlyEmployee {
    public static void main(String[] args) {
        int empId = 1;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bob", "home", 5);
        t.execute();

        Employee e = EmployeeDatabase.GpayrollDatebase.getEmployee(empId);
        System.out.println(e.getName());

        PaymentClassification pc = e.getClassification();
        HourlyClassification sc = (HourlyClassification) pc;
        System.out.println(sc.getHourlyRate());

        PaymentSchedule ps = e.getSchedule();
        WeeklySchedule ms = (WeeklySchedule) ps;
        System.out.println(ms!=null);

        PaymentMethod pm = e.getMethod();
        HoldMethod hm = (HoldMethod) pm;
        System.out.println(hm!=null);

    }
}
