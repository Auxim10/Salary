package test;

import dao.dao;
import dao.Impl.EmployeeDaoImpl;
import domain.Employee;
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
        String eno;
        String edept;
        String ename;
        String esex;
        String egrade;
        String erank;
        int eage;
        String ewalfare;
        Employee employee = new Employee();
        //dao.add();
        System.out.println("successful!");
    }
}

