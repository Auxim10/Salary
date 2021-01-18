package servlet;

import dao.DepartmentDao;
import dao.Impl.DepartmentDaoImpl;
import dao.Impl.SalarygradeDaoImpl;
import dao.Impl.WelfareDaoImpl;
import dao.SalarygradeDao;
import dao.WelfareDao;
import domain.Department;
import domain.Salarygrade;
import domain.Welfare;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findWelServlet")
public class FindWelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取id
        String wname = request.getParameter("wname");
        //2.调用Service查询

        WelfareDao weldao = new WelfareDaoImpl();
        System.out.println("查询："+wname);
        //3.将user存入request
        System.out.println(weldao.findById(wname));
        request.setAttribute("welfare",weldao.findById(wname));

        //4.转发到update.jsp
        request.getRequestDispatcher("/updatewelfare.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
