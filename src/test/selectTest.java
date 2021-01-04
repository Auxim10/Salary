package test;

import dao.dao;
import dao.Impl.EmployeeDaoImpl;

public class selectTest {
    public static void main(String[] args) {

        dao dao = new EmployeeDaoImpl();
        dao.findALL();
        System.out.println(dao.findALL());

    }
}
