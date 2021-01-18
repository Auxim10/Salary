package test;

import dao.Impl.EveryDaoImpl;
import dao.Impl.SalaryDaoImpl;
import dao.dao;
import dao.Impl.EmployeeDaoImpl;
import domain.Employee;
import operate.Repeat;
import org.junit.Test;

public class selectTest {

    dao dao = new EmployeeDaoImpl();
    @Test
    public void delete(){
        dao.delete("1");
    }

    @Test
    public void prin(){
        Employee employee = new Employee();
        System.out.println(employee);
    }

    @Test
    public void insert(){
        Employee employee = new Employee();
        employee = dao.findById("3");
        System.out.println(employee);
        System.out.println(employee.getEsex());
        System.out.println("sex to girl.");
        employee.setEno("3444");
        employee.setEsex("女");
        System.out.println(employee);
        dao.update(employee);
        System.out.println("successful!");
    }

    @Test
    public void every(){
        EveryDaoImpl everyDao = new EveryDaoImpl();
        everyDao.findById("2");
        System.out.println(everyDao.findById("2"));
    }

    @Test
    public void everysalary(){
        SalaryDaoImpl dao = new SalaryDaoImpl();
        dao.findById("2");
        System.out.println(dao.findById("2"));
    }

    @Test
    public void repeat(){
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        String eno = "3";
        if(dao.findById(eno)!=null){
            System.out.println(dao.findById(eno));
            System.out.println("重复！");
        }else{
            System.out.println("NO repeat!");
        }

    }
}

