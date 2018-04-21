package main.java.com.payroll.classification;

import main.java.com.payroll.TimeCard;

import java.util.ArrayList;
import main.java.com.payroll.Date;
import main.java.com.payroll.pay.Paycheck;

import java.util.HashMap;
import java.util.Map;

public class HourlyClassification extends PaymentClassification {
    double itsHourlyRate;
    HashMap<Date,TimeCard> timeCards;
    public HourlyClassification(double hourlyRate){
        itsHourlyRate=hourlyRate;
    }
    public double getHourlyRate(){
        return itsHourlyRate;
    }

    public void addTimeCard(TimeCard tc){
        if(timeCards==null){
            synchronized (HourlyClassification.class){
                if(timeCards==null)
                    timeCards=new HashMap();
            }
        }
        timeCards.put(tc.getDate(),tc);
    }
    public TimeCard getTimeCard(Date d) {
        return timeCards.get(d);
    }
    public double calculatePay(Paycheck pc){
        double pay=0;
        Date payPeriodEndDate=pc.getPayDate();
        pc.setPayPeriodEndDate(payPeriodEndDate);
        if(timeCards!=null) {
            for (Map.Entry<Date, TimeCard> entry : timeCards.entrySet()) {
                //Not completed:pay in weekends should be double or else.
                if (isInPayPeriod(entry.getKey(),pc)){
                    double hours = entry.getValue().getHours();
                    pay += (hours > 8) ? (8 + (hours - 8) * 1.5) * itsHourlyRate : hours * itsHourlyRate;
                }
            }
            //Delete old timecards.
            //timeCards.clear();
        }
        return pay;

    }
}
