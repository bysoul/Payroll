package main.java.com.payroll.transaction;

import main.java.com.payroll.method.Mailmethod;
import main.java.com.payroll.method.PaymentMethod;

public class ChangeMailTranscation extends ChangeMethodTranscation {
    String itsAddress;
    public ChangeMailTranscation(int empId,String address){
        super(empId);
        itsAddress=address;
    }

    @Override
    PaymentMethod getMethod() {
        return new Mailmethod(itsAddress);
    }
}
