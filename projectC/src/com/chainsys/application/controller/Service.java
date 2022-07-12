package com.chainsys.application.controller;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.application.model.Employee;
import com.chainsys.application.model.EmployeeDao;

import org.springframework.web.bind.annotation.RequestParam;

@RestController

public class Service
{
    ////  @RequestMapping(value="/getEmployee",method=RequestMethod.GET)
   @RequestMapping("/getEmployee")
    public String getData(@RequestParam(name="id") String id)
    {
       int empId = Integer.parseInt(id);
        Employee emp = EmployeeDao.getEmployeeById(empId);
            return emp.getFirst_Name()+", " + emp.getLast_Name()+", " + emp.getJob_ID()+", " + emp.getSalary()+", "
                    + emp.getHire_Date()+", " + emp.getEmail() ;
       
       
    }
    //  @RequestMapping(value="/getAll",method=RequestMethod.GET) 
   @RequestMapping("/getAll")
   public String getAll() {

        List<Employee> allEmployees = EmployeeDao.getAllEmployee();
        Iterator<Employee> empIterator = allEmployees.iterator();
        String result="";
        while(empIterator.hasNext())
        {
            Employee emp = empIterator.next();
            result+="<div>"+emp.getE_Id()+" : "+emp.getFirst_Name()+" : "+emp.getLast_Name()+" : " 
                    + emp.getEmail() +" : " + emp.getHire_Date()+ " : " + emp.getJob_ID() +" : "+ emp.getSalary()+"</div>";
        }
            return     result;

   }
   @RequestMapping(value="/newemployee",method=RequestMethod.POST)
    public int addNewEmployee() {
        return 0;
    }
   @RequestMapping(value="/updateemployee",method=RequestMethod.PUT)
      public int modifyEmployee() {
          return 1;
      }
   @RequestMapping(value="/removeemployee",method=RequestMethod.DELETE)
      public int deleteEmployee() {
          return 2;
      }
}