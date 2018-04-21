package main.java.com.payroll.transaction;

import main.java.com.payroll.affilition.Affiliation;
import main.java.com.payroll.model.Employee;

public class ChangeAffiliationTransaction extends ChangeEmployeeTransaction{
    public ChangeAffiliationTransaction(int empId){
        super(empId);
    }
    Affiliation getAffiliation(){
        return  null;
    }
    void recordMembership(Employee e){}
    void change(Employee e){
        recordMembership(e);
        e.setAffiliation(getAffiliation());
    }
}
