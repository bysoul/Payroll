package main.java.com.payroll.schedule;

import main.java.com.payroll.Date;

import java.util.Calendar;

public class WeeklySchedule extends PaymentSchedule {

    @Override
    public boolean isPayDate(Date date) {
        return date.isFriday();
    }
    public Date getPayPeriodStartDate(Date payDate){
        Calendar calendar = Calendar.getInstance();
        calendar.set(payDate.getItsYear(),payDate.getItsMonth()-1,payDate.getItsDay());
        int i = calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek();
        calendar.add(Calendar.DATE,-i);
        return new Date(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DATE));
    }
    public static void main(String[] args){
        WeeklySchedule w=new WeeklySchedule();
        System.out.println(w.isPayDate(new main.java.com.payroll.Date(2018,4,20)));
    }
}
