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

@WebServlet("/findGradeServlet")
public class FindGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id

        String grade = request.getParameter("grade");

        //2.调用Service查询


        SalarygradeDao sadao = new SalarygradeDaoImpl();
        Salarygrade salarygrade = sadao.findById(grade);
        System.out.println("查询："+grade);
        //3.将user存入request

        request.setAttribute("salarygrade",salarygrade);
        //4.转发到update.jsp
        request.getRequestDispatcher("/updategrade.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
