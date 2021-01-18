package dao;

import domain.Salary;

import java.util.List;

public interface SalaryDao {
    List<Salary> findALL();
    void select(Salary salary);
    void del(String sno);
    void update(Salary salary);
    Salary findById(String sno);
}
