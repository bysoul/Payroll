package test.java.com.payroll.transaction;

import main.java.com.payroll.affilition.Affiliation;
import main.java.com.payroll.affilition.UnionAffilition;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.transaction.AddHourlyEmployee;
import main.java.com.payroll.transaction.ChangeMemberTransaction;

public class TestChangeMembeerTranscation {
    public static void main(String[] args){
        int empId=2;
        int memberId=7734;
        AddHourlyEmployee t=new AddHourlyEmployee(empId,"Bill","Home",15.25);
        t.execute();
        ChangeMemberTransaction cmt=new ChangeMemberTransaction(empId,memberId,99.42);
        cmt.execute();
        Employee e= EmployeeDatabase.GpayrollDatebase.getEmployee(empId);
        assert e!=null;
        Affiliation af=e.getAffiliation();
        assert af!=null;
        UnionAffilition uf=(UnionAffilition)af;
        assert uf!=null;
        assert uf.getDue()==99.42;
        Employee member=EmployeeDatabase.GpayrollDatebase.getUnionMember(memberId);
        assert member!=null;
        assert e==member;
    }
}
