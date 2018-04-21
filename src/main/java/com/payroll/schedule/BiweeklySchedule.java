package main.java.com.payroll.schedule;

import main.java.com.payroll.Date;

import java.util.Calendar;

public class BiweeklySchedule extends PaymentSchedule{
    @Override
    public boolean isPayDate(Date date) {
        return date.isFriday();
    }
    public Date getPayPeriodStartDate(Date payDate){
        Calendar calendar = Calendar.getInstance();
        calendar.set(payDate.getItsYear(),payDate.getItsMonth()-1,payDate.getItsDay());
        int i = calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek();
        calendar.add(Calendar.DATE,-i-7);
        return new Date(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DATE));
    }
}
