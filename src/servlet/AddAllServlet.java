package servlet;


import dao.DepartmentDao;
import dao.Impl.*;
import dao.SalaryDao;
import dao.SalarygradeDao;
import dao.WelfareDao;
import domain.*;
import org.apache.commons.beanutils.BeanUtils;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/addAllServlet")
public class AddAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //判断是否重复
        String eno = request.getParameter("eno");
        System.out.println("eno"+eno);
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        if(dao.findById(eno)!=null && eno ==null){
            response.sendRedirect("/updateerror.jsp");
        }else {
            //2.获取参数
            Map<String, String[]> map = request.getParameterMap();
            //3.封装对象
            Employee employee = new Employee();
            try {
                BeanUtils.populate(employee, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
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


            //5.跳转到userListServlet
            request.getRequestDispatcher("/add.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
