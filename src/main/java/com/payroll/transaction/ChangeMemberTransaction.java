package main.java.com.payroll.transaction;

import main.java.com.payroll.affilition.Affiliation;
import main.java.com.payroll.affilition.UnionAffilition;
import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.model.Employee;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {
    int itsMemberId;
    double itsDue;
    public ChangeMemberTransaction(int empId,int memberId,double due){
        super(empId);
        itsMemberId=memberId;
        itsDue=due;
    }

    @Override
    Affiliation getAffiliation() {
        return new UnionAffilition(itsMemberId,itsDue);
    }

    @Override
    void recordMembership(Employee e) {
        EmployeeDatabase.GpayrollDatebase.addUnionMember(itsMemberId,e);
    }
}
