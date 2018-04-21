package main.java.com.payroll;

import java.util.Calendar;

//import java.util.Date;
public class Date implements Comparable{
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

    public int getItsDay() {
        return itsDay;
    }

    public int getItsMonth() {
        return itsMonth;
    }

    public int getItsYear() {
        return itsYear;
    }
    public boolean isLastDayOfMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,this.getItsYear());
        calendar.set(Calendar.MONTH, this.getItsMonth()-1);
        return this.getItsDay()== calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    public boolean isFriday(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.getItsYear(),this.getItsMonth()-1,this.getItsDay());
        return calendar.get(Calendar.DAY_OF_WEEK)== 6;
    }
    //If two dates are in the same week,it means they are from Sunday to Saturday in one week.
    public boolean isInSameWeek(Date date){
        Calendar cal1 = Calendar.getInstance();
        cal1.set(this.getItsYear(),this.getItsMonth()-1,this.getItsDay());
        Calendar cal2 = Calendar.getInstance();
        cal2.set(date.getItsYear(),date.getItsMonth()-1,date.getItsDay());

        int i = cal1.get(Calendar.DAY_OF_WEEK) - cal1.getFirstDayOfWeek();
        cal1.add(Calendar.DATE,-i);
        if(cal1.compareTo(cal2)>0) return false;
        cal1.add(Calendar.DATE,6);
        if(cal1.compareTo(cal2)<0) return false;
        return true;
    }
    public void add(int i){
        Calendar cal1 = Calendar.getInstance();
        cal1.set(this.getItsYear(),this.getItsMonth()-1,this.getItsDay());
        cal1.add(Calendar.DATE,i);
        this.itsYear=cal1.get(Calendar.YEAR);
        this.itsMonth=cal1.get(Calendar.MONTH)+1;
        this.itsDay=cal1.get(Calendar.DATE);
    }
    public boolean isBetween(Date start,Date end){
        return start.compareTo(this)<=0&&end.compareTo(this)>=0;
    }

    @Override
    public int compareTo(Object o) {
        if(this.equals(o)) return 0;
        else {
            Date t=(Date)o;
            if(this.itsYear<t.itsYear)
                return -1;
            else if(this.itsYear>t.itsYear)
                return 1;
            if(this.itsMonth<t.itsMonth)
                return -1;
            else  if(this.itsMonth>t.itsMonth)
                return 1;
            if(this.itsDay<t.itsDay)
                return -1;
            else  if(this.itsDay>t.itsDay)
                return 1;
        }
        return 0;
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
    public static void main(String[] args){
        Date d1=new Date(2018,4,22);
        System.out.println(d1.isInSameWeek(new Date(2018,4,20)));
    }
}
