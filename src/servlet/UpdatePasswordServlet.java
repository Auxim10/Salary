package servlet;


import dao.Impl.EmployeeDaoImpl;
import dao.Userdao;
import domain.Employee;
import domain.Salarygrade;
import domain.User;
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

@WebServlet("/updatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //2.获取
        String username = request.getParameter("eno");
        String password = request.getParameter("password");
        //3.封装对象
        User user = new User();
        Userdao dao = new Userdao();
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        user.setId(Integer.getInteger(username));
        user.setPassword(password);
        dao.update(user,username);

            //5.跳转到查询所有Servlet
            response.sendRedirect(request.getContextPath() + "updatepassword.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
