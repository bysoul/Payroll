package main.java.com.payroll.payrollapp;

import main.java.com.Transaction;
import main.java.com.payroll.source.TextParserTransactionSource;
import main.java.com.payroll.source.TransactionSource;

public class PayrollApplication {
    static TransactionSource ts=new TextParserTransactionSource();

    public static void main(String[] args){
        while(true){
            Transaction t=ts.getTransaction();
            t.execute();
        }
    }
}
