package main.java.com.payroll.schedule;

import main.java.com.payroll.Date;
import java.util.Calendar;

/**
 * Created by lenovo on 2018/4/13.
 */
public class MonthlySchedule extends PaymentSchedule {
    boolean isLastDayOfMonth(main.java.com.payroll.Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,date.getItsYear());
        calendar.set(Calendar.MONTH, date.getItsMonth()-1);
        return date.getItsDay()== calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    public boolean isPayDate(main.java.com.payroll.Date date){
        return isLastDayOfMonth(date);
    }
    public static void main(String[] args){
        MonthlySchedule m=new MonthlySchedule();
        System.out.println(m.isPayDate(new main.java.com.payroll.Date(2018,4,30)));
    }
}
