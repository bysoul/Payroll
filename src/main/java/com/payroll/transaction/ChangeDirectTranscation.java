package main.java.com.payroll.transaction;

import main.java.com.payroll.method.DirectMethod;
import main.java.com.payroll.method.PaymentMethod;

public class ChangeDirectTranscation extends ChangeMethodTranscation {
    String itsBank;
    String itsAccount;
    public ChangeDirectTranscation(int empId,String bank,String account){
        super(empId);
        itsAccount=account;
        itsBank=bank;
    }

    @Override
    PaymentMethod getMethod() {
        return new DirectMethod(itsBank,itsAccount);
    }
}
