package test.java.com.payroll.transaction;

import main.java.com.payroll.Date;
import main.java.com.payroll.pay.Paycheck;
import main.java.com.payroll.transaction.AddHourlyEmployee;
import main.java.com.payroll.transaction.PaydayTransaction;
import main.java.com.payroll.transaction.TimeCardTransaction;

public class TestPaySingleHourlyEmployeeOnWrongDate {
    public static void main(String[] args){
        int empId=2;
        AddHourlyEmployee t=new AddHourlyEmployee(empId,"Bill","Home",15.25);
        t.execute();
        Date payDate=new Date(2018,4,19);
        TimeCardTransaction tc=new TimeCardTransaction(payDate,9,empId);
        tc.execute();
        PaydayTransaction pt=new PaydayTransaction(payDate);
        pt.execute();
        Paycheck pc=pt.getPaycheck(empId);
        assert pc==null;
    }
}
