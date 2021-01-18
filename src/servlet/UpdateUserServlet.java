package servlet;


import dao.Impl.EmployeeDaoImpl;
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
import java.util.Map;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //判断是否重复
        String eno = request.getParameter("id");
        System.out.println("eno"+eno);
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        //3.封装对象
        Employee employee = new Employee();
        Map<String, String[]> map = request.getParameterMap();

        try {
            BeanUtils.populate(employee, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        if(dao.findById(employee.getEno()) !=null && !(dao.findById(employee.getEno()).getEno().equals(eno) )){
            response.sendRedirect("/updateerror.jsp");
        }else {
            //2.获取map

            //4.调用Service修改
            Service service = new ServiceImpl();
            service.updateUser(employee);

            //5.跳转到查询所有Servlet
            response.sendRedirect(request.getContextPath() + "/findUserByPageServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
