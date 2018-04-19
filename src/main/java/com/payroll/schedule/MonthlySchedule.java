package main.java.com.payroll.schedule;

import main.java.com.payroll.Date;
import java.util.Calendar;

public class MonthlySchedule extends PaymentSchedule {
    public boolean isPayDate(main.java.com.payroll.Date date){
        return date.isLastDayOfMonth();
    }
    public static void main(String[] args){
        MonthlySchedule m=new MonthlySchedule();
        System.out.println(m.isPayDate(new main.java.com.payroll.Date(2018,4,30)));
    }
}
