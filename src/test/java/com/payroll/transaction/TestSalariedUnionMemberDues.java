package test.java.com.payroll.transaction;

import main.java.com.payroll.Date;
import main.java.com.payroll.pay.Paycheck;
import main.java.com.payroll.transaction.AddSalariedEmployee;
import main.java.com.payroll.transaction.ChangeMemberTransaction;
import main.java.com.payroll.transaction.PaydayTransaction;

public class TestSalariedUnionMemberDues {
    public static void  main(String[] args){
        int empId=1;
        AddSalariedEmployee t= new AddSalariedEmployee(empId,"Bob","Home",1000);
        t.execute();
        int memberId=7734;
        ChangeMemberTransaction cmt=new ChangeMemberTransaction(empId,memberId,9.42);
        cmt.execute();
        Date payDate=new Date(2018,4,30);
        PaydayTransaction pt=new PaydayTransaction(payDate);
        pt.execute();
        ValidatePaycheck(pt,empId,payDate,1000-4*9.42);
    }
    static void ValidatePaycheck(PaydayTransaction pt,int empId,Date payDate,double pay){
        Paycheck pc=pt.getPaycheck(empId);
        assert pc!=null;
        assert pc.getPayPeriodEndDate().equals(payDate);
        assert 1000==pc.getGrossPay();
        assert "Hold".equals(pc.getField("Disposition"));
        assert 4*9.42==pc.getDeduction();
        assert pay==pc.getNetPay();

    }
}
