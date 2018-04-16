package main.java.com.payroll.classification;

import main.java.com.payroll.Date;
import main.java.com.payroll.SalesReceipt;
import main.java.com.payroll.TimeCard;

import java.util.HashMap;

public class CommissionedClassifition extends PaymentClassification{
    double itsSalary;
    double itsCommissionRate;
    HashMap<Date,SalesReceipt> salesReceipts;
    public CommissionedClassifition(double salary,double commissionRate){
        itsSalary=salary;
        itsCommissionRate=commissionRate;
    }
    public double getSalary(){
        return itsSalary;
    }
    public double getCommissionRate(){
        return itsCommissionRate;
    }

    public void addSalesReceipt(SalesReceipt s){
        if(salesReceipts==null){
            synchronized (CommissionedClassifition.class){
                if (salesReceipts==null)
                    salesReceipts=new HashMap<>();
            }
        }
        salesReceipts.put(s.getDate(),s);
    }
    public SalesReceipt getSalesReceipt(Date d){
        return salesReceipts.get(d);
    }
}
