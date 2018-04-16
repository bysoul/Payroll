package main.java.com.payroll.method;


public class DirectMethod extends PaymentMethod{
    String itsBank;
    String itsAccount;
    public DirectMethod(String bank,String account){
        itsBank=bank;
        itsAccount=account;
    }
}
