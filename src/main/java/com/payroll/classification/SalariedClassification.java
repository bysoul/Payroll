package main.java.com.payroll.classification;

/**
 * Created by lenovo on 2018/4/13.
 */
public class SalariedClassification extends PaymentClassification {
    double itsSalary;
    public SalariedClassification(double salary){
        itsSalary=salary;
    }
    public double getSalary(){
        return itsSalary;
    }
}
