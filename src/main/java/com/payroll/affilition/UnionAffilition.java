package main.java.com.payroll.affilition;

import main.java.com.payroll.Date;
import main.java.com.payroll.ServiceCharge;
import main.java.com.payroll.pay.Paycheck;

import java.util.HashMap;
import java.util.Map;

public class UnionAffilition extends Affiliation{
    double itsDue;
    int itsMemberId;
    HashMap<Date,ServiceCharge> charges;
    public UnionAffilition(int memberId,double due){
        itsMemberId=memberId;
        itsDue=due;
    }
    public double calculateDeductions(Paycheck pc){
        double ch=0;
        if(charges!=null) {
            for (Map.Entry<Date, ServiceCharge> entry : charges.entrySet()) {
                if (entry.getKey().isBetween(pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate()))
                    ch += entry.getValue().getCharge();
            }
        }
        double dues;
        int fridays=numberOfFridayInPayPeriod(pc.getPayPeriodStartDate(),pc.getPayPeriodEndDate());
        dues=itsDue*fridays;
        return dues+ch;
    }
    public int numberOfFridayInPayPeriod(Date payPeriodStart,Date payPeriodEnd){
        int fridays=0;
        for(Date day=payPeriodStart;day.compareTo(payPeriodEnd)<=0;day.add(1)){
            if(day.isFriday())
                fridays++;
        }
        return fridays;
    }

    public int getMemberId() {
        return itsMemberId;
    }

    public double getDue() {
        return itsDue;
    }

    public void addServiceCharge(Date date, double charge){
        if(charges==null){
            synchronized (UnionAffilition.class){
                if(charges==null)
                    charges=new HashMap<>();
            }
        }
        charges.put(date,new ServiceCharge(date, charge));

    }
    public ServiceCharge getServiceCharge(long date){
        return charges.get(new Date(date));
    }
}
