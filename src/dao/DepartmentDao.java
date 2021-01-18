package dao;

import domain.Department;
import domain.Salary;
import domain.Salarygrade;

import java.util.List;

public interface DepartmentDao {
    List<Department> findALL();
    void update(Department department,String oldDname);
    void insert(Department department);
    void delete(String name);
    void sql(String sql);
    Department findById(String dname);
}
