package main.java.com.payroll;

public class SalesReceipt {
    Date itsDate;
    double itsAmount;
    public SalesReceipt(Date date,double amount){
        itsDate=date;
        itsAmount=amount;
    }
    public double getAmount(){
        return itsAmount;
    }
    public Date getDate(){
        return itsDate;
    }
}
