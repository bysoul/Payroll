package test.java.com.payroll.transaction;

import main.java.com.payroll.Date;
import main.java.com.payroll.pay.Paycheck;
import main.java.com.payroll.transaction.AddSalariedEmployee;
import main.java.com.payroll.transaction.PaydayTransaction;

public class TestPaySingleSalariedEmployee {
    public static void main(String[] args){
        int empId=1;
        AddSalariedEmployee t=new AddSalariedEmployee(empId,"Bob","Home",1000.00);
        t.execute();
        Date payDate=new Date(2018,4,30);
        PaydayTransaction pt=new PaydayTransaction(payDate);
        pt.execute();
        Paycheck pc=pt.getPaycheck(empId);
        assert pc!=null;
        assert pc.getPayDate()==payDate;
        assert 1000.00==pc.getGrossPay();
        assert "Hold".equals(pc.getField("Disposition"));
        assert 0==pc.getDeduction();
        assert 1000==pc.getNetPay();
    }
}
