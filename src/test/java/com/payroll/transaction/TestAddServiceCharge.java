package test.java.com.payroll.transaction;

import main.java.com.payroll.ServiceCharge;
import main.java.com.payroll.affilition.UnionAffilition;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.transaction.AddHourlyEmployee;
import main.java.com.payroll.transaction.ServiceChargeTransaction;

public class TestAddServiceCharge {
    public static void main(String[] args){
        int empId=2;
        AddHourlyEmployee t=new AddHourlyEmployee(empId,"Bill","Home",15.25);
        t.execute();
        Employee e= EmployeeDatabase.GpayrollDatebase.getEmployee(empId);
        assert e!=null;
        int memberId=86;
        UnionAffilition af=new UnionAffilition(memberId,12.5);
        e.setAffiliation(af);
        EmployeeDatabase.GpayrollDatebase.addUnionMember(memberId,e);
        ServiceChargeTransaction sct=new ServiceChargeTransaction(memberId,20180416,12.95);
        sct.execute();
        ServiceCharge sc=af.getServiceCharge(20180416);
        assert sc!=null;
        assert sc.getCharge()==12.95;

    }
}
