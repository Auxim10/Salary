package dao.Impl;

import dao.DepartmentDao;
import domain.Department;
import domain.Employee;
import domain.Salary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Department> findALL() {
        String sql = "select * from department";
        List<Department> departments = template.query(sql, new BeanPropertyRowMapper<>(Department.class));
        return departments;
    }

    @Override
    public void update(Department department,String oldDname) {
        //1.定义sql
        String sql = "update department set dname = ?,vocationsalary = ? where dname = ?";
        //2.执行sql
        template.update(sql,department.getDname(),department.getVocationsalary(),oldDname);
    }

    @Override
    public void insert(Department department) {
        String sql = "insert into department values(?,?)";
        //2.执行sql
        template.update(sql,department.getDname(),department.getVocationsalary());
    }

    @Override
    public void delete(String name) {
        //1.定义sql
        String sql = "delete from department where dname = ?";
        //2.执行sql
        template.update(sql,name);
    }

    public void sql(String sql){
        template.update(sql);
    }

    @Override
    public Department findById(String dname) {
        try {
            String sql = "select * from department where dname = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<Department>(Department.class), dname);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
