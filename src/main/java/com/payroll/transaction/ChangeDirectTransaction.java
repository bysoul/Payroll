package main.java.com.payroll.transaction;

import main.java.com.payroll.method.DirectMethod;
import main.java.com.payroll.method.PaymentMethod;

public class ChangeDirectTransaction extends ChangeMethodTransaction {
    String itsBank;
    String itsAccount;
    public ChangeDirectTransaction(int empId,String bank,String account){
        super(empId);
        itsAccount=account;
        itsBank=bank;
    }

    @Override
    PaymentMethod getMethod() {
        return new DirectMethod(itsBank,itsAccount);
    }
}
