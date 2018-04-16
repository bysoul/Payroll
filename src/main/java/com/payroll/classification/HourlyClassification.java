package main.java.com.payroll.classification;

import main.java.com.payroll.TimeCard;

import java.util.ArrayList;
import main.java.com.payroll.Date;
import java.util.HashMap;

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
}
