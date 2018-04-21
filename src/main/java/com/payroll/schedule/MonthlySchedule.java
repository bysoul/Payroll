package main.java.com.payroll.schedule;

import main.java.com.payroll.Date;
import java.util.Calendar;

public class MonthlySchedule extends PaymentSchedule {
    public boolean isPayDate(main.java.com.payroll.Date date){
        return date.isLastDayOfMonth();
    }
    public Date getPayPeriodStartDate(Date payDate){
        /*Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,payDate.getItsYear());
        calendar.set(Calendar.MONTH, payDate.getItsMonth()-1);
        return new Date(payDate.getItsYear(),payDate.getItsMonth(),calendar.getActualMinimum(Calendar.DAY_OF_MONTH));*/
        return new Date(payDate.getItsYear(),payDate.getItsMonth(),1);
    }
    public static void main(String[] args){
        MonthlySchedule m=new MonthlySchedule();
        System.out.println(m.getPayPeriodStartDate(new Date(20180430)));
    }
}
