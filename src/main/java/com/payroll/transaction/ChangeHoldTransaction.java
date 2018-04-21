package main.java.com.payroll.transaction;

import main.java.com.payroll.method.HoldMethod;
import main.java.com.payroll.method.PaymentMethod;

public class ChangeHoldTransaction extends ChangeMethodTransaction {
    public ChangeHoldTransaction(int empId){
        super(empId);
    }

    @Override
    PaymentMethod getMethod() {
        return new HoldMethod();
    }
}
