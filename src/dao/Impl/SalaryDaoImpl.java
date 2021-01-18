package dao.Impl;

import dao.SalaryDao;
import domain.Employee;
import domain.Salary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class SalaryDaoImpl implements SalaryDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Salary> findALL() {
        String sql = "select * from salary";
        List<Salary> salaries = template.query(sql, new BeanPropertyRowMapper<>(Salary.class));
        return salaries;
    }

    @Override
    public void select(Salary salary) {
       return;
    }

    @Override
    public void del(String sno) {
        //1.定义sql
        String sql = "delete from salary where sno = ?";
        //2.执行sql
        template.update(sql,sno);
    }

    @Override
    public void update(Salary salary) {
        //1.定义sql
        String sql = "update salary set basicsalary = ? ,vocationsalary = ?,agesalary = ?,welfare = ?,allsalary = ? where sno = ?";
        //2.执行sql
        template.update(sql,salary.getBasicsalary(),salary.getVocationsalary(),salary.getAgesalary(),salary.getWelfare(),salary.getAllsalary(),salary.getSno());
    }

    @Override
    public Salary findById(String sno) {
        String sql = "select * from salary where sno = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Salary>(Salary.class),sno);
    }
}
