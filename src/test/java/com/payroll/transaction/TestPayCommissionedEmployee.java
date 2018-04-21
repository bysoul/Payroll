package test.java.com.payroll.transaction;

import main.java.com.payroll.Date;
import main.java.com.payroll.SalesReceipt;
import main.java.com.payroll.pay.Paycheck;
import main.java.com.payroll.transaction.AddCommissionedEmployee;
import main.java.com.payroll.transaction.AddHourlyEmployee;
import main.java.com.payroll.transaction.PaydayTransaction;
import main.java.com.payroll.transaction.SalesReceiptTransaction;

public class TestPayCommissionedEmployee {
    public static void main(String[] args){
        int empId=2;
        AddCommissionedEmployee t=new AddCommissionedEmployee(empId,"Bill","Home",1000,0.1);
        t.execute();
        Date payDate=new Date(2018,4,20);
        SalesReceiptTransaction st1=new SalesReceiptTransaction(payDate,100,empId);
        st1.execute();
        SalesReceiptTransaction st2=new SalesReceiptTransaction(new Date(2018,4,19),100,empId);
        st2.execute();
        PaydayTransaction pt=new PaydayTransaction(payDate);
        pt.execute();
        Paycheck pc=pt.getPaycheck(empId);
        ValidatePaycheck(pt,empId,payDate,1020);
    }
    static void ValidatePaycheck(PaydayTransaction pt,int empId,Date payDate,double pay){
        Paycheck pc=pt.getPaycheck(empId);
        assert pc!=null;
        assert pc.getPayPeriodEndDate().equals(payDate);
        assert pay==pc.getGrossPay();
        assert "Hold".equals(pc.getField("Disposition"));
        assert 0==pc.getDeduction();
        assert pay==pc.getNetPay();

    }
}
