package main.java.com.payroll.model;

import main.java.com.payroll.Date;
import main.java.com.payroll.affilition.Affiliation;
import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.method.PaymentMethod;
import main.java.com.payroll.pay.Paycheck;
import main.java.com.payroll.schedule.PaymentSchedule;

public class Employee {
    int empId;
    String itsAddress;
    String itsName;
    PaymentClassification paymentClassification;
    PaymentSchedule paymentSchedule;
    PaymentMethod paymentMethod;
    Affiliation affiliation;
    public Employee(int employeeId, String name, String address){
        empId=employeeId;
        itsAddress=address;
        itsName=name;
    }
    public int getEmployeeId(){
        return empId;
    }
    public String getName(){
        return itsName;
    }
    public String getAddress(){
        return itsAddress;
    }
    public void setName(String name){
        itsName=name;
    }
    public void setAddress(String address){
        itsAddress=address;
    }

    public PaymentClassification getClassification() {
        return paymentClassification;
    }
    public PaymentSchedule getSchedule(){
        return paymentSchedule;
    }
    public PaymentMethod getMethod() {
        return paymentMethod;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public void setPaymentClassification(PaymentClassification p){
        paymentClassification=p;
    }
    public void setPaymentSchedule(PaymentSchedule p){
        paymentSchedule=p;
    }
    public void setPaymentMethod(PaymentMethod p){
        paymentMethod=p;
    }
    public void setAffiliation(Affiliation a){affiliation=a;}

    public void payDay(Paycheck pc){
        double grossPay=paymentClassification.calculatePay(pc);
        double deductions=affiliation.calculateDeductions(pc);
        double netPay=grossPay-deductions;
        pc.setGrossPay(grossPay);
        pc.setDeductions(deductions);
        pc.setNetPay(netPay);
        paymentMethod.pay(pc);
    }
    public boolean isPayDate(Date date){
        return paymentSchedule.isPayDate(date);
    }
    public Date getPayPeriodStartDate(Date payDate){
        return paymentSchedule.getPayPeriodStartDate(payDate);
    }

}
