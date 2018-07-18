package main.java.com.payroll;

public class ServiceCharge {
    Date itsDate;
    double itsCharge;
    public ServiceCharge(Date date,double charge){
        itsDate=date;
        itsCharge=charge;
    }
    public double getCharge(){
        return itsCharge;
    }
}
