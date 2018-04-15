package test.java.com.payroll.transaction;
import main.java.com.payroll.classification.*;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.method.*;
import main.java.com.payroll.model.*;
import main.java.com.payroll.schedule.*;
import main.java.com.payroll.transaction.*;


public class TestAddSalariedEmployee {
    public static void main(String[] args) {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "home", 1000.00);
        t.execute();

        Employee e = EmployeeDatabase.GpayrollDatebase.getEmployee(empId);
        System.out.println(e.getName());

        PaymentClassification pc = e.getClassification();
        SalariedClassification sc = (SalariedClassification) pc;
        System.out.println(sc.getSalary());

        PaymentSchedule ps = e.getSchedule();
        MonthlySchedule ms = (MonthlySchedule) ps;
        System.out.println(ms!=null);

        PaymentMethod pm = e.getMethod();
        HoldMethod hm = (HoldMethod) pm;
        System.out.println(hm!=null);

    }
}
