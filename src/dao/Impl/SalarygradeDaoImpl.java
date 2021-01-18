package dao.Impl;

import dao.SalarygradeDao;
import domain.Department;
import domain.Salary;
import domain.Salarygrade;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class SalarygradeDaoImpl implements SalarygradeDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Salarygrade> findALL() {
        String sql = "select * from salarygrade";
        List<Salarygrade> salarygrades = template.query(sql, new BeanPropertyRowMapper<>(Salarygrade.class));
        return salarygrades;
    }

    @Override
    public void update(Salarygrade salarygrade,String oldGrade) {
        //1.定义sql
        String sql = "update salarygrade set grade= ?, gradesalary = ? where grade = ?";
        //2.执行sql
        template.update(sql,salarygrade.getGrade(),salarygrade.getGradesalary(),oldGrade);
    }

    @Override
    public void del(String grade) {
        //1.定义sql
        String sql = "delete from salarygrade where grade = ?";
        //2.执行sql
        template.update(sql,grade);
    }

    @Override
    public void insert(Salarygrade salarygrade) {
        String sql = "insert into salarygrade values(?,?)";
        //2.执行sql
        template.update(sql,salarygrade.getGrade(),salarygrade.getGradesalary());
    }

    @Override
    public Salarygrade findById(String grade) {
        try {
            String sql = "select * from salarygrade where grade = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<Salarygrade>(Salarygrade.class), grade);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
