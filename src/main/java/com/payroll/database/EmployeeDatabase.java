package main.java.com.payroll.database;

import main.java.com.payroll.model.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDatabase {
    public static EmployeeDatabase GpayrollDatebase=new EmployeeDatabase();
    HashMap<Integer,Employee> ehm=new HashMap<>();
    HashMap<Integer,Integer> mhm=new HashMap<>();
    public Employee getEmployee(int empId){
        return ehm.get(empId);
    }
    public void addEmployee(int empId,Employee e){
        ehm.put(empId,e);
    }
    public void removeEmployee(int empId){
        ehm.remove(empId);
    }
    public void addUnionMember(int memberId,Employee e){
        mhm.put(memberId,e.getEmployeeId());
    }
    public Employee getUnionMember(int itsMemberId){
        return ehm.get(mhm.get(itsMemberId));
    }
    public void removeUnionMember(int memberId){
        mhm.remove(memberId);
    }
    public List<Integer>getAllEmployeeIds(){
        List<Integer> list=new LinkedList<>();
        for(int i:ehm.keySet()){
            list.add(i);
        }
        return list;
    }


}
