package servlet;

import dao.DepartmentDao;
import dao.Impl.DepartmentDaoImpl;
import dao.Impl.SalarygradeDaoImpl;
import dao.Impl.WelfareDaoImpl;
import dao.SalarygradeDao;
import dao.WelfareDao;
import domain.Department;
import domain.Employee;
import domain.Salarygrade;
import domain.Welfare;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findDeptServlet")
public class FindDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String dname = request.getParameter("dname");
        //2.调用Service查询
        DepartmentDao deptdao = new DepartmentDaoImpl();
        Department department = deptdao.findById(dname);
        System.out.println("更新的部门："+dname);
        //3.将user存入request
        request.setAttribute("department",department);
        //4.转发到update.jsp
        request.getRequestDispatcher("/updatedept.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
