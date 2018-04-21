package test.java.com.payroll.transaction;

import main.java.com.payroll.Date;
import main.java.com.payroll.pay.Paycheck;
import main.java.com.payroll.transaction.*;

public class TestServiceChargesSpanningMultiplePayPeriods {
    public static void main(String[] args){
        int empId=1;
        AddHourlyEmployee t= new AddHourlyEmployee(empId,"Bill","Home",15.24);
        t.execute();
        int memberId=7734;
        ChangeMemberTransaction cmt=new ChangeMemberTransaction(empId,memberId,9.42);
        cmt.execute();
        Date earlyDate=new Date(2001,11,2);
        Date payDate=new Date(2001,11,9);
        Date lateDate=new Date(2001,11,16);
        ServiceChargeTransaction sct=new ServiceChargeTransaction(memberId,earlyDate,100);
        sct.execute();
        ServiceChargeTransaction sct2=new ServiceChargeTransaction(memberId,payDate,19.42);
        sct2.execute();
        ServiceChargeTransaction sct3=new ServiceChargeTransaction(memberId,lateDate,200);
        sct3.execute();
        TimeCardTransaction tct=new TimeCardTransaction(payDate,8.0,empId);
        tct.execute();
        PaydayTransaction pt=new PaydayTransaction(payDate);
        pt.execute();
        Paycheck pc=pt.getPaycheck(empId);
        assert pc!=null;
        assert pc.getPayPeriodEndDate().equals(payDate);
        assert 8*15.24==pc.getGrossPay();
        assert "Hold".equals(pc.getField("Disposition"));
        assert 9.42+19.42==pc.getDeduction();
        assert 8*15.24-(9.42+19.42)==pc.getNetPay();

    }
}
