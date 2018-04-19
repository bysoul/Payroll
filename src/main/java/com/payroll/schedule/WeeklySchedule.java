package main.java.com.payroll.schedule;

import main.java.com.payroll.Date;

import java.util.Calendar;

public class WeeklySchedule extends PaymentSchedule {

    @Override
    public boolean isPayDate(Date date) {
        return date.isFriday();
    }
    public static void main(String[] args){
        WeeklySchedule w=new WeeklySchedule();
        System.out.println(w.isPayDate(new main.java.com.payroll.Date(2018,4,20)));
    }
}
