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
