package main.java.com.payroll.transaction;

import main.java.com.payroll.classification.HourlyClassification;
import main.java.com.payroll.classification.PaymentClassification;
import main.java.com.payroll.schedule.PaymentSchedule;
import main.java.com.payroll.schedule.WeeklySchedule;

public class ChangeHourlyTranscation extends ChangeClassificationTranscation {
    double itsHourlyRate;
    public ChangeHourlyTranscation(int empid,double hourlyRate){
        super(empid);
        itsHourlyRate=hourlyRate;
    }

    @Override
    PaymentClassification getClassification() {
        return new HourlyClassification(itsHourlyRate);
    }

    @Override
    PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}
