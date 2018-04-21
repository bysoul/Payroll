package main.java.com.payroll.classification;

import main.java.com.payroll.Date;
import main.java.com.payroll.SalesReceipt;
import main.java.com.payroll.TimeCard;
import main.java.com.payroll.pay.Paycheck;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CommissionedClassifition extends PaymentClassification{
    double itsSalary;
    double itsCommissionRate;
    HashMap<Date,SalesReceipt> salesReceipts;
    public CommissionedClassifition(double salary,double commissionRate){
        itsSalary=salary;
        itsCommissionRate=commissionRate;
    }
    public double getSalary(){
        return itsSalary;
    }
    public double getCommissionRate(){
        return itsCommissionRate;
    }

    public void addSalesReceipt(SalesReceipt s){
        if(salesReceipts==null){
            synchronized (CommissionedClassifition.class){
                if (salesReceipts==null)
                    salesReceipts=new HashMap<>();
            }
        }
        salesReceipts.put(s.getDate(),s);
    }
    public SalesReceipt getSalesReceipt(Date d){
        return salesReceipts.get(d);
    }

    @Override
    public double calculatePay(Paycheck pc) {
        double pay=0;
        Date payPeriodEndDate=pc.getPayDate();
        pc.setPayPeriodEndDate(payPeriodEndDate);
        if(salesReceipts!=null) {
            for (Map.Entry<Date, SalesReceipt> entry : salesReceipts.entrySet()) {
                //Not completed:pay in weekends should be double or else.
                if (isInPayPeriod(entry.getKey(),pc)){
                    double amount = entry.getValue().getAmount();
                    pay += amount*itsCommissionRate;
                }
            }
            //Delete old sales receipts
            //salesReceipts.clear();
        }
        return pay+itsSalary;
    }
    // not used
    boolean isInPayPeriod(Date payPeriodEndDate,Date d){
        Calendar cal1 = Calendar.getInstance();
        cal1.set(payPeriodEndDate.getItsYear(),payPeriodEndDate.getItsMonth()-1,   payPeriodEndDate.getItsDay());
        Calendar cal2 = Calendar.getInstance();
        cal2.set(d.getItsYear(),d.getItsMonth()-1,d.getItsDay());

        int i = cal1.get(Calendar.DAY_OF_WEEK) - cal1.getFirstDayOfWeek();
        cal1.add(Calendar.DATE,-i-7);
        if(cal1.compareTo(cal2)>0) return false;
        cal1.add(Calendar.DATE,6+7);
        if(cal1.compareTo(cal2)<0) return false;
        return true;
    }
}
