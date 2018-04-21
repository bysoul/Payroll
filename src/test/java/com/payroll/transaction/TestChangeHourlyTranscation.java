package test.java.com.payroll.transaction;

import main.java.com.payroll.classification.HourlyClassification;
import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.schedule.PaymentSchedule;
import main.java.com.payroll.schedule.WeeklySchedule;
import main.java.com.payroll.transaction.AddSalariedEmployee;
import main.java.com.payroll.transaction.ChangeHourlyTransaction;

public class TestChangeHourlyTranscation {
    public static void main(String[] args){
        int empId=3;
        AddSalariedEmployee t=new AddSalariedEmployee(empId,"Lance","Home",2500);
        t.execute();
        ChangeHourlyTransaction cht=new ChangeHourlyTransaction(empId,27.52);
        cht.execute();
        Employee e= EmployeeDatabase.GpayrollDatebase.getEmployee(empId);
        assert e!=null;
        PaymentClassification pc=e.getClassification();
        assert pc!=null;
        HourlyClassification hc=(HourlyClassification)pc;
        assert hc!=null;
        assert hc.getHourlyRate()==27.52;
        PaymentSchedule ps=e.getSchedule();
        WeeklySchedule ws=(WeeklySchedule)ps;
        assert ws!=null;
    }
}
