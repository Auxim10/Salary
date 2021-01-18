package servlet;


import dao.Impl.SalaryDaoImpl;
import dao.SalaryDao;
import domain.Employee;
import domain.Salary;
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

@WebServlet("/updateSalaryServlet")
public class UpdateSalaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取map
        String sno = request.getParameter("sno");
        Map<String, String[]> map = request.getParameterMap();
        System.out.println(map);
        SalaryDao dao = new SalaryDaoImpl();
        Salary salary = new Salary();
        //3.封装对象
        try {
            BeanUtils.populate(salary,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(salary);
        System.out.println(sno);
        if(dao.findById(salary.getSno()) !=null && !(dao.findById(salary.getSno()).getSno().equals(sno) )){
            response.sendRedirect("/updateerror.jsp");
        }else {
            //4.调用Service修改
            dao.update(salary);
            //5.跳转到查询所有Servlet
            response.sendRedirect(request.getContextPath()+"/salaryServlet");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
