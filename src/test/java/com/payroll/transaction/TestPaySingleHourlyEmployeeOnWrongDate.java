package test.java.com.payroll.transaction;

import main.java.com.payroll.Date;
import main.java.com.payroll.pay.Paycheck;
import main.java.com.payroll.transaction.AddHourlyEmployee;
import main.java.com.payroll.transaction.PaydayTranscation;
import main.java.com.payroll.transaction.TimeCardTranscation;

public class TestPaySingleHourlyEmployeeOnWrongDate {
    public static void main(String[] args){
        int empId=2;
        AddHourlyEmployee t=new AddHourlyEmployee(empId,"Bill","Home",15.25);
        t.execute();
        Date payDate=new Date(2018,4,19);
        TimeCardTranscation tc=new TimeCardTranscation(payDate,9,empId);
        tc.execute();
        PaydayTranscation pt=new PaydayTranscation(payDate);
        pt.execute();
        Paycheck pc=pt.getPaycheck(empId);
        assert pc==null;
    }
}
