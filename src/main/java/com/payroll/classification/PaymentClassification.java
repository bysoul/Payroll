package main.java.com.payroll.classification;

import main.java.com.payroll.Date;
import main.java.com.payroll.pay.Paycheck;

/**
 * Created by lenovo on 2018/4/13.
 */
public class PaymentClassification {
    public double calculatePay(Paycheck pc){
        return 0;
    }
    boolean isInPayPeriod(Date date,Paycheck pc){
        Date payPeriodEndDate=pc.getPayPeriodEndDate();
        Date payPeriodStartDate=pc.getPayPeriodStartDate();
        return date.isBetween(payPeriodStartDate,payPeriodEndDate);
    }
}
