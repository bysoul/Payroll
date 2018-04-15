package main.java.com.payroll;

import main.java.com.payroll.Date;

public class TimeCard {
    Date itsDate;
    double itsHours;
    public TimeCard(Date date,double hours){
        itsDate=date;
        itsHours=hours;
    }
    public double getHours(){
        return itsHours;
    }
    public Date getDate(){
        return itsDate;
    }
}
