package dao;

import domain.Salary;
import domain.Salarygrade;

import java.util.List;

public interface SalarygradeDao {
    List<Salarygrade> findALL();
    void update(Salarygrade salarygrade,String oldGrade);
    void del(String grade);
    void insert(Salarygrade salarygrade);
    Salarygrade findById(String grade);
}
