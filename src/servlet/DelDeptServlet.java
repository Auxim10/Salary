package servlet;

import dao.DepartmentDao;
import dao.Impl.DepartmentDaoImpl;
import dao.Impl.SalarygradeDaoImpl;
import dao.Impl.WelfareDaoImpl;
import dao.SalarygradeDao;
import dao.WelfareDao;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/delDeptServlet")
public class DelDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String deptid = request.getParameter("deptid");
        String said = request.getParameter("said");
        String welid = request.getParameter("welid");

        //2.调用service删除
        DepartmentDao deptdao = new DepartmentDaoImpl();
        deptdao.delete(deptid);

        SalarygradeDao sadao = new SalarygradeDaoImpl();
        sadao.del(said);

        WelfareDao weldao = new WelfareDaoImpl();
        weldao.del(welid);
        //3.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/deptGradeWelfareServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

