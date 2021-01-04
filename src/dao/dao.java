package dao;

import domain.Employee;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import util.JDBCUtils;

import java.util.List;
import java.util.Map;

public interface dao {
    public List<Employee> findALL();

    void add(Employee employee);

    void delete(int id);

    Employee findById(int i);

    void update(Employee employee);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<Employee> findByPage(int start, int rows, Map<String, String[]> condition);
}
