package main.java.com.payroll.transaction;

import main.java.com.payroll.affilition.Affiliation;
import main.java.com.payroll.affilition.NoAffilition;
import main.java.com.payroll.affilition.UnionAffilition;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.model.Employee;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {
    public ChangeUnaffiliatedTransaction(int empId){
        super(empId);
    }

    @Override
    Affiliation getAffiliation() {
        return new NoAffilition();
    }

    @Override
    void recordMembership(Employee e) {
        Affiliation af=e.getAffiliation();
        UnionAffilition uf=null;
        try{
            uf=(UnionAffilition)af;
        }
        catch (Exception ex){
            System.out.println(e.getEmployeeId()+"is not an unionAffiliation.");
        }
        int memberId=uf.getMemberId();
        EmployeeDatabase.GpayrollDatebase.removeUnionMember(memberId);
    }
}
