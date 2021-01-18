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

@WebServlet("/addDeptServlet")
public class AddDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //判断是否重复
        String dname = request.getParameter("dname");
        System.out.println("dname"+dname);
        DepartmentDao dao = new DepartmentDaoImpl();
        if(dao.findById(dname)!=null){
            response.sendRedirect("/updateerror.jsp");
        }else {
            //2.获取参数
            Map<String, String[]> map = request.getParameterMap();
            //3.封装对象
            Department department = new Department();
            try {
                BeanUtils.populate(department, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            //4.调用Service保存
            dao.insert(department);

            //5.跳转到userListServlet
            response.sendRedirect(request.getContextPath() + "/deptGradeWelfareServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
