package test.java.com.payroll.transaction;

import main.java.com.payroll.TimeCard;
import main.java.com.payroll.classification.HourlyClassification;
import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.transaction.AddHourlyEmployee;
import main.java.com.payroll.transaction.TimeCardTransaction;
import main.java.com.payroll.Date;

public class TestTimeCardTranscation {
    public static void main(String[] args) {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 12.25);
        t.execute();
        TimeCardTransaction tct=new TimeCardTransaction(new Date(2018,4,15),8.0,empId);
        tct.execute();
        Employee e= EmployeeDatabase.GpayrollDatebase.getEmployee(empId);
        assert e!=null;
        PaymentClassification pc=e.getClassification();
        HourlyClassification hc=(HourlyClassification) pc;
        assert hc!=null;
        TimeCard tc=hc.getTimeCard(new Date(2018,4,15));
        assert tc!=null;
        assert tc.getHours()==8.0;
    }
}
