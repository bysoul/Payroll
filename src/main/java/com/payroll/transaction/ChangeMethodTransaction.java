package main.java.com.payroll.transaction;

import main.java.com.payroll.method.PaymentMethod;
import main.java.com.payroll.model.Employee;

public class ChangeMethodTransaction extends ChangeEmployeeTransaction {
    public ChangeMethodTransaction(int empId){
        super(empId);
    }

    PaymentMethod getMethod(){
        return null;
    }

    @Override
    void change(Employee e) {
        e.setPaymentMethod(getMethod());
    }
}
