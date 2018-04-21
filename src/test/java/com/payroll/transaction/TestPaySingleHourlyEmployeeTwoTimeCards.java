package test.java.com.payroll.transaction;

import main.java.com.payroll.Date;
import main.java.com.payroll.pay.Paycheck;
import main.java.com.payroll.transaction.AddHourlyEmployee;
import main.java.com.payroll.transaction.PaydayTransaction;
import main.java.com.payroll.transaction.TimeCardTransaction;

public class TestPaySingleHourlyEmployeeTwoTimeCards {
    public static void main(String[] args){
        int empId=2;
        AddHourlyEmployee t=new AddHourlyEmployee(empId,"Bill","Home",15.25);
        t.execute();
        Date payDate=new Date(2018,4,20);
        TimeCardTransaction tc1=new TimeCardTransaction(payDate,9,empId);
        tc1.execute();
        TimeCardTransaction tc2=new TimeCardTransaction(new Date(2018,4,19),1,empId);
        tc2.execute();
        PaydayTransaction pt=new PaydayTransaction(payDate);
        pt.execute();
        ValidatePaycheck(pt,empId,payDate,(8+1.5)*15.25+15.25);
    }
    static void ValidatePaycheck(PaydayTransaction pt,int empId,Date payDate,double pay){
        Paycheck pc=pt.getPaycheck(empId);
        assert pc!=null;
        assert pc.getPayPeriodEndDate()==payDate;
        System.out.println(pc.getGrossPay());
        System.out.println((8+1.5)*15.25+15.25);
        assert pay==pc.getGrossPay();
        assert "Hold".equals(pc.getField("Disposition"));
        assert 0==pc.getDeduction();
        assert pay==pc.getNetPay();

    }
}
