package test.java.com.payroll.transaction;

import main.java.com.payroll.Date;
import main.java.com.payroll.pay.Paycheck;
import main.java.com.payroll.transaction.AddHourlyEmployee;
import main.java.com.payroll.transaction.PaydayTranscation;
import main.java.com.payroll.transaction.TimeCardTranscation;

public class TestPaySingleHourlyEmployeeOneTimeCard {
    public static void main(String[] args){
        int empId=2;
        AddHourlyEmployee t=new AddHourlyEmployee(empId,"Bill","Home",15.25);
        t.execute();
        Date payDate=new Date(2018,4,20);
        TimeCardTranscation tc=new TimeCardTranscation(payDate,2.0,empId);
        tc.execute();
        PaydayTranscation pt=new PaydayTranscation(payDate);
        pt.execute();
        ValidatePaycheck(pt,empId,payDate,30.5);
    }
    static void ValidatePaycheck(PaydayTranscation pt,int empId,Date payDate,double pay){
        Paycheck pc=pt.getPaycheck(empId);
        assert pc!=null;
        assert pc.getPayPeriodEndDate()==payDate;
        assert pay==pc.getGrossPay();
        assert "Hold".equals(pc.getField("Disposition"));
        assert 0==pc.getDeduction();
        assert pay==pc.getNetPay();

    }
}
