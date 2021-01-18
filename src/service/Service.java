package service;

import domain.Employee;
import domain.Salary;
import domain.User;
import operate.PageBean;

import java.util.List;
import java.util.Map;

/**
 * 员工信息接口
 */
public interface Service {
    public List<Employee> findAll();

    /**
     * 登录方法
     * @param user
     * @return
     */
     User login(User user);

    /**
     * 保存User
     * @param employee
     */

    boolean repeat(Employee employee);

    void addUser(Employee employee);

    /**
     * 根据id删除User
     * @param eno
     */
    void deleteUser(String eno);

    /**
     * 根据id查询
     * @param eno
     * @return
     */
    Employee findUserById(String eno);

    /**
     * 修改用户信息
     * @param employee
     */
    void updateUser(Employee employee);

    /**
     * 批量删除用户
     * @param enos
     */
    void delSelectedUser(String[] enos);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Employee> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);

}

