package main.java.com.payroll.transaction;

import main.java.com.payroll.method.HoldMethod;
import main.java.com.payroll.method.PaymentMethod;

public class ChangeHoldTranscation extends ChangeMethodTranscation {
    public ChangeHoldTranscation(int empId){
        super(empId);
    }

    @Override
    PaymentMethod getMethod() {
        return new HoldMethod();
    }
}
