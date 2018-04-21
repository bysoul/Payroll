package main.java.com.payroll.affilition;

import main.java.com.payroll.pay.Paycheck;

public class NoAffilition extends Affiliation {
    public double calculateDeductions(Paycheck pc){
        return 0;
    }
}
