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
import java.util.List;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("eno");
        //2.调用Service查询
        Service service = new ServiceImpl();
        Employee employee = service.findUserById(id);
        //3.将user存入request
        request.setAttribute("employee",employee);
        //4.转发到update.jsp

        //查询部门
        DepartmentDao deptdao = new DepartmentDaoImpl();
        List<Department> departments = deptdao.findALL();
        System.out.println(departments);

        //查询职位
        SalarygradeDao sadao = new SalarygradeDaoImpl();
        List<Salarygrade> salarygrades = sadao.findALL();

        //查询福利
        WelfareDao weldao = new WelfareDaoImpl();
        List<Welfare> welfares = weldao.findALL();
        request.setAttribute("departments",departments);
        request.setAttribute("salarygrades",salarygrades);
        request.setAttribute("welfares",welfares);

        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
