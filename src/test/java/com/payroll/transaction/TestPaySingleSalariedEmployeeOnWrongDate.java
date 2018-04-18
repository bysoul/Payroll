package test.java.com.payroll.transaction;

import main.java.com.payroll.Date;
import main.java.com.payroll.pay.Paycheck;
import main.java.com.payroll.transaction.AddSalariedEmployee;
import main.java.com.payroll.transaction.PaydayTranscation;

public class TestPaySingleSalariedEmployeeOnWrongDate {
    public static void main(String[] args){
        int empId=1;
        AddSalariedEmployee t=new AddSalariedEmployee(empId,"Bob","Home",1000.00);
        t.execute();
        Date payDate=new Date(2018,4,18);
        PaydayTranscation pt=new PaydayTranscation(payDate);
        pt.execute();
        Paycheck pc=pt.getPaycheck(empId);
        assert pc==null;
    }
}
