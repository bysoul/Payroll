package main.java.com.payroll.method;

import main.java.com.payroll.pay.Paycheck;

/**
 * Created by lenovo on 2018/4/13.
 */
public class HoldMethod extends PaymentMethod {
    public void pay(Paycheck pc){
        pc.setDisposition("Hold");
    }
}
