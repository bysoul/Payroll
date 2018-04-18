package main.java.com.payroll.pay;

import main.java.com.payroll.Date;

public class Paycheck {
    double itsGrossPay;
    double itsDeductions;
    double itsNetPay;
    Date itsDate;
    String itsDisposition;

    public Paycheck(Date date){
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
}
