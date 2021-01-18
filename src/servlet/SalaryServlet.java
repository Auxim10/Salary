package servlet;

import dao.Impl.SalaryDaoImpl;
import dao.SalaryDao;
import domain.Employee;
import domain.Salary;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/salaryServlet")
public class SalaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用SalaryBegin完成初始化
        SalaryDao dao = new SalaryDaoImpl();
        List<Salary> salaries = dao.findALL();
        //2.将list存入request域
        request.setAttribute("salaries",salaries);
        System.out.println("正在访问工资信息...");
        //3.转发到list.jsp
        request.getRequestDispatcher("/salary.jsp").forward(request,response);
        request.getRequestDispatcher("/salaryBeginServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
