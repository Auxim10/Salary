package dao.Impl;

import dao.WelfareDao;
import domain.Department;
import domain.Salarygrade;
import domain.Welfare;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class WelfareDaoImpl implements WelfareDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Welfare> findALL() {
        String sql = "select * from welfare";
        List<Welfare> welfares = template.query(sql, new BeanPropertyRowMapper<>(Welfare.class));
        return welfares;
    }

    @Override
    public void update(Welfare welfare,String oldWname) {
        //1.定义sql
        String sql = "update welfare set wname = ?,wsalary = ? where wname = ?";
        //2.执行sql
        template.update(sql,welfare.getWname(), welfare.getWsalary(),oldWname);
    }

    @Override
    public void del(String name) {
        //1.定义sql
        String sql = "delete from welfare where wname = ?";
        //2.执行sql
        template.update(sql,name);
    }

    @Override
    public void insert(Welfare welfare) {
        String sql = "insert into welfare values(?,?)";
        //2.执行sql
        template.update(sql,welfare.getWname(),welfare.getWsalary());
    }

    @Override
    public Welfare findById(String name) {
        try {
            String sql = "select * from welfare where wname = ? ";
            return template.queryForObject(sql, new BeanPropertyRowMapper<Welfare>(Welfare.class),name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
