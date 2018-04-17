package main.java.com.payroll;

public class Date {
    int itsYear;
    int itsMonth;
    int itsDay;
    public Date(int year,int month,int day){
        itsYear=year;
        itsMonth=month;
        itsDay=day;
    }
    public Date(long date){
        itsDay=(int)date%100;
        date/=100;
        itsMonth=(int)date%100;
        itsYear=(int)date/100;
    }
    @Override
    public int hashCode() {
        return itsDay*itsMonth*itsYear;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj==null) return false;
        if(!(obj instanceof Date)) return false;
        else{
            final Date t=(Date)obj;
            if(this.itsYear==t.itsYear&&this.itsMonth==t.itsMonth&&this.itsDay==t.itsDay) return true;
            else return false;
        }
    }
}
