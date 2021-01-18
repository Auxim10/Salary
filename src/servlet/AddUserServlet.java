package servlet;


import dao.DepartmentDao;
import dao.Impl.DepartmentDaoImpl;
import dao.Impl.EmployeeDaoImpl;
import domain.Department;
import domain.Employee;
import org.apache.commons.beanutils.BeanUtils;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //判断是否重复
        String eno = request.getParameter("eno");
        System.out.println("eno"+eno);
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        if(dao.findById(eno)!=null && eno ==null){
            response.sendRedirect("/updateerror.jsp");
        }else {
            //2.获取参数
            Map<String, String[]> map = request.getParameterMap();
            //3.封装对象
            Employee employee = new Employee();
            try {
                BeanUtils.populate(employee, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //查询部门
            DepartmentDao deptdao = new DepartmentDaoImpl();
            Department department = new Department();
            List<Department> departments = deptdao.findALL();


            //4.调用Service保存
            Service service = new ServiceImpl();
            service.addUser(employee);
            System.out.println("进行插入数据！");
            //
            employee.setId(employee.getEno());
            service.updateUser(employee);
            System.out.println("进行更新！");

            //5.跳转到userListServlet
            response.sendRedirect(request.getContextPath() + "/findUserByPageServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
