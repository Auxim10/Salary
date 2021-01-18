package servlet;

import dao.Impl.SalaryDaoImpl;
import dao.SalaryDao;
import domain.Salary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/everySalaryServlet")
public class EverySalaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用SalaryBegin完成初始化
        String eno = request.getParameter("eno");
        SalaryDao dao = new SalaryDaoImpl();
        Salary salaries = dao.findById(eno);
        //2.将list存入request域
        request.setAttribute("salaries",salaries);
        System.out.println("员工"+eno+"正在访问工资信息...");
        System.out.println("salarier信息："+salaries);
        //3.转发到list.jsp
        request.getRequestDispatcher("/everysalary.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
