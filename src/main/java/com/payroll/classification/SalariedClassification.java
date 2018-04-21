package main.java.com.payroll.classification;

import main.java.com.payroll.Date;
import main.java.com.payroll.pay.Paycheck;

/**
 * Created by lenovo on 2018/4/13.
 */
public class SalariedClassification extends PaymentClassification {
    double itsSalary;
    public SalariedClassification(double salary){
        itsSalary=salary;
    }
    public double getSalary(){
        return itsSalary;
    }
    public double calculatePay(Paycheck pc){
        Date payPeriodEndDate=pc.getPayDate();
        pc.setPayPeriodEndDate(payPeriodEndDate);
        return itsSalary;
    }
}
