package test.java.com.payroll.transaction;

import main.java.com.payroll.Date;
import main.java.com.payroll.SalesReceipt;
import main.java.com.payroll.TimeCard;
import main.java.com.payroll.classification.CommissionedClassifition;
import main.java.com.payroll.classification.HourlyClassification;
import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.schedule.BiweeklySchedule;
import main.java.com.payroll.schedule.WeeklySchedule;
import main.java.com.payroll.transaction.AddCommissionedEmployee;
import main.java.com.payroll.transaction.AddHourlyEmployee;
import main.java.com.payroll.transaction.SalesReceiptTransaction;

public class TestSalesReceiptTranscation {
    public static void main(String[] args) {
        int empId = 2;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Bill", "Home", 1000,0.1);
        t.execute();
        SalesReceiptTransaction srt=new SalesReceiptTransaction(new Date(2018,4,15),8.0,empId);
        srt.execute();
        Employee e= EmployeeDatabase.GpayrollDatebase.getEmployee(empId);
        assert e!=null;
        PaymentClassification pc=e.getClassification();
        CommissionedClassifition cc=(CommissionedClassifition) pc;
        assert cc!=null;
        SalesReceipt tc=cc.getSalesReceipt(new Date(2018,4,15));
        assert tc!=null;
        assert tc.getAmount()==8.0;
        System.out.println(tc.getAmount());
    }
}
