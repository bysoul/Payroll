package main.java.com.payroll.pay;

import main.java.com.payroll.Date;

public class Paycheck {
    double itsGrossPay;
    double itsDeductions;
    double itsNetPay;
    Date itsDate;
    String itsDisposition;
    Date itsPayPeriodStartDate;
    Date itsPayPeriodEndDate;

    public Paycheck(Date date){
        itsDate=date;
    }
    public Paycheck(Date payPeriodStartDate,Date date){
        itsPayPeriodStartDate=payPeriodStartDate;
        itsDate=date;
    }
    public void setGrossPay(double grossPay){
        itsGrossPay=grossPay;
    }
    public void setDeductions(double deductions){
        itsDeductions=deductions;
    }
    public void setNetPay(double netPay){
        itsNetPay=netPay;
    }
    public void setDisposition(String s){
        itsDisposition=s;
    }
    public void setPayPeriodEndDate(Date payPeriodEndDate){
        itsPayPeriodEndDate=payPeriodEndDate;
    }

    public Date getPayDate() {
        return itsDate;
    }

    public double getDeduction() {
        return itsDeductions;
    }

    public double getGrossPay() {
        return itsGrossPay;
    }

    public double getNetPay() {
        return itsNetPay;
    }
    public String getField(String s){
        if(s.equals("Disposition"))
            return itsDisposition;
        return "Unknown.";
    }
    public Date getPayPeriodEndDate(){
        return itsPayPeriodEndDate;
    }
    public Date getPayPeriodStartDate(){
        return itsPayPeriodStartDate;
    }
}
