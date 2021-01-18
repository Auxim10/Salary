package dao;

import domain.Employee;

import java.util.List;

public interface EveryDao {
    List<Employee> findALL();
    Employee findById(String eno);
}
