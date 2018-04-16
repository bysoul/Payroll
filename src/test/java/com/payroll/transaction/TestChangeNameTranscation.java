package test.java.com.payroll.transaction;

import main.java.com.payroll.database.EmployeeDatabase;
import main.java.com.payroll.model.Employee;
import main.java.com.payroll.transaction.AddEmployeeTransaction;
import main.java.com.payroll.transaction.AddHourlyEmployee;
import main.java.com.payroll.transaction.ChangeNameTranscation;


public class TestChangeNameTranscation {
    public static void main(String[] args){
        int empId=2;
        AddHourlyEmployee t=new AddHourlyEmployee(empId,"Bill","Home",15.25);
        t.execute();
        ChangeNameTranscation cnt=new ChangeNameTranscation(empId,"Bob");
        cnt.execute();
        Employee e= EmployeeDatabase.GpayrollDatebase.getEmployee(empId);
        assert e!=null;
        assert ("Bob".equals(e.getName()));
    }

}
