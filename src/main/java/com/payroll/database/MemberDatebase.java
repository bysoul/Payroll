package main.java.com.payroll.database;

import main.java.com.payroll.model.Employee;

import java.util.HashMap;

public class MemberDatebase {
    public static MemberDatebase GmemberDatebase=new MemberDatebase();
    HashMap<Integer,Integer> hm=new HashMap<>();
    public Integer getEmployeeId(int memId){
        return hm.get(memId);
    }
    public void addMember(int memId,int empId){
        hm.put(memId,empId);
    }
    public void removeMember(int memId){
        hm.remove(memId);
    }
}
