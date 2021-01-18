package servlet;


import dao.DepartmentDao;
import dao.Impl.DepartmentDaoImpl;
import dao.Impl.SalaryDaoImpl;
import dao.SalaryDao;
import domain.Department;
import domain.Salary;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateDeptServlet")
public class UpdateDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取map
        String oldDname = request.getParameter("oldDname");
        Map<String, String[]> map = request.getParameterMap();
        Department department = new Department();
        System.out.println(department);
        DepartmentDao dao = new DepartmentDaoImpl();
        //3.封装对象
        try {
            BeanUtils.populate(department, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(department);
        //4.调用Service修改

        if(dao.findById(department.getDname()) !=null && !(dao.findById(department.getDname()).getDname().equals(request.getParameter(oldDname)) )){
            System.out.println("部门重复！");
            response.sendRedirect("/updateerror.jsp");
        }else {
            //5.跳转到查询所有Servlet
            dao.update(department,oldDname);
            response.sendRedirect(request.getContextPath() + "/deptGradeWelfareServlet");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
