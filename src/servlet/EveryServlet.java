package servlet;

import dao.EveryDao;
import dao.Impl.EveryDaoImpl;
import dao.Impl.SalaryDaoImpl;
import dao.SalaryDao;
import domain.Employee;
import domain.Salary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/everyServlet")
public class EveryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service
        String id = request.getParameter("eno");
        System.out.println("id:"+id);
        EveryDao dao = new EveryDaoImpl();
        Employee employees = dao.findById(id);
        System.out.println(id);
        System.out.println("员工"+id+"正在访问信息..");
        //存入数据到域中
        request.setAttribute("employees",employees);
        //转发
        request.getRequestDispatcher("/everylist.jsp").forward(request,response);
        System.out.println("转发成功..");

        //1.调用SalaryBegin完成初始化
        String eno = request.getParameter("eno");
        SalaryDao daodao = new SalaryDaoImpl();
        Salary salaries = daodao.findById(id);
        //2.将list存入request域
        request.setAttribute("salaries",salaries);
        System.out.println("员工"+eno+"正在访问工资信息...");
        System.out.println(salaries);
        //3.转发到list.jsp
        request.getRequestDispatcher("/every.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request, response);
    }
}
