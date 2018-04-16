package test.java.com.payroll.transaction;

import main.java.com.payroll.classification.CommissionedClassifition;
import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.classification.SalariedClassification;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.method.HoldMethod;
import main.java.com.payroll.method.PaymentMethod;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.schedule.BiweeklySchedule;
import main.java.com.payroll.schedule.MonthlySchedule;
import main.java.com.payroll.schedule.PaymentSchedule;
import main.java.com.payroll.transaction.AddCommissionedEmployee;
import main.java.com.payroll.transaction.AddSalariedEmployee;

public class TestAddCommissionedEmployee {
    public static void main(String[] args) {
        int empId = 1;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Bob", "home", 1000.00,0.1);
        t.execute();

        Employee e = EmployeeDatabase.GpayrollDatebase.getEmployee(empId);
        System.out.println(e.getName());

        PaymentClassification pc = e.getClassification();
        CommissionedClassifition sc = (CommissionedClassifition) pc;
        System.out.println(sc.getCommissionRate());

        PaymentSchedule ps = e.getSchedule();
        BiweeklySchedule ms = (BiweeklySchedule) ps;
        System.out.println(ms!=null);

        PaymentMethod pm = e.getMethod();
        HoldMethod hm = (HoldMethod) pm;
        System.out.println(hm!=null);

    }
}
