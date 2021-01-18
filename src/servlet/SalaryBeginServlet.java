package servlet;

import dao.Impl.EmployeeDaoImpl;
import dao.Impl.SalaryDaoImpl;
import dao.SalaryDao;
import dao.dao;
import domain.Employee;
import domain.Salary;
import operate.SalaryBegin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/salaryBeginServlet")
public class SalaryBeginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用SalaryBegin完成初始化
        dao dao = new EmployeeDaoImpl();
        List<Employee> employees = dao.findALL();
        //2.将list存入request域
        request.setAttribute("employess",employees);
        System.out.println("正在初始化工资信息..");
        SalaryBegin begin = new SalaryBegin();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
