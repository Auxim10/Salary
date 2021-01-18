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

@WebServlet("/findSalaryServlet")
public class FindSalaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("sno");
        //2.调用Service查询
        SalaryDao dao = new SalaryDaoImpl();
        Salary salary = dao.findById(id);
        //3.将user存入request
        request.setAttribute("salary",salary);
        //4.转发到update.jsp
        request.getRequestDispatcher("/salaryupdate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
