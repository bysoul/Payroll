package main.java.com.payroll.affilition;

import main.java.com.payroll.Date;
import main.java.com.payroll.ServiceCharge;

import java.util.HashMap;

public class UnionAffilition extends Affiliation{
    double itsDue;
    int itsMemberId;
    HashMap<Date,ServiceCharge> charges;
    public UnionAffilition(int memberId,double due){
        itsMemberId=memberId;
        itsDue=due;
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
