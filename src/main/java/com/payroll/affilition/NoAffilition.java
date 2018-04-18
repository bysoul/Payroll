package main.java.com.payroll.affilition;

import main.java.com.payroll.pay.Paycheck;

public class NoAffilition extends Affiliation {
    public double calculatedeductions(Paycheck pc){
        return 0;
    }
}
