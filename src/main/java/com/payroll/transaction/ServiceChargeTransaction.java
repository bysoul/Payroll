package main.java.com.payroll.transaction;

import main.java.com.Transaction;
import main.java.com.payroll.Date;
import main.java.com.payroll.affilition.Affiliation;
import main.java.com.payroll.affilition.UnionAffilition;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.model.Employee;

public class ServiceChargeTransaction implements Transaction {
    int itsMemberId;
    Date itsDate;
    double itsCharge;
    public ServiceChargeTransaction(int memberId,long date,double charge){
        itsMemberId=memberId;
        itsDate=new Date(date);
        itsCharge=charge;
    }
    public ServiceChargeTransaction(int memberId,Date date,double charge){
        itsMemberId=memberId;
        itsDate=date;
        itsCharge=charge;
    }

    @Override
    public void execute() {
        Employee e= EmployeeDatabase.GpayrollDatebase.getUnionMember(itsMemberId);
        Affiliation af=e.getAffiliation();
        UnionAffilition uaf=null;
        try{
            uaf=(UnionAffilition)af;
        }
        catch (Exception ex){
            System.out.println(e.getEmployeeId()+"is not a unionaffiliation");
        }
        uaf.addServiceCharge(itsDate,itsCharge);
    }

    @Override
    public void validate() {

    }
}
