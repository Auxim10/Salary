package servlet;

import dao.DepartmentDao;
import dao.Impl.DepartmentDaoImpl;
import dao.Impl.SalaryDaoImpl;
import dao.Impl.SalarygradeDaoImpl;
import dao.Impl.WelfareDaoImpl;
import dao.SalaryDao;
import dao.SalarygradeDao;
import dao.WelfareDao;
import domain.Department;
import domain.Salary;
import domain.Salarygrade;
import domain.Welfare;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deptGradeWelfareServlet")
public class DeptGradeWelfareServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.完成初始化
        DepartmentDao daode = new DepartmentDaoImpl();
        List<Department> departments = daode.findALL();

        SalarygradeDao daosa = new SalarygradeDaoImpl();
        List<Salarygrade> salarygrades = daosa.findALL();

        WelfareDao daowel = new WelfareDaoImpl();
        List<Welfare> welfares = daowel.findALL();
        //2.将list存入request域
        request.setAttribute("departments",departments);
        request.setAttribute("salarygrades",salarygrades);
        System.out.println(salarygrades);
        System.out.println(welfares);
        request.setAttribute("welfares",welfares);
        System.out.println("正在访问工资信息...");
        //3.转发到list.jsp
        request.getRequestDispatcher("/dgwlist.jsp").forward(request,response);
        //request.getRequestDispatcher("/dgwinfolist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
