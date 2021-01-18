package dao.Impl;

import dao.EveryDao;
import domain.Employee;
import domain.Salary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class EveryDaoImpl implements EveryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Employee> findALL() {
        return null;
    }

    @Override
    public Employee findById(String eno) {
        String sql = "select * from employee where eno = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), eno);
    }

}
