package servlet;


import dao.DepartmentDao;
import dao.Impl.DepartmentDaoImpl;
import dao.Impl.SalarygradeDaoImpl;
import dao.SalarygradeDao;
import domain.Department;
import domain.Salary;
import domain.Salarygrade;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addGradeServlet")
public class AddGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //判断是否重复
        String grade = request.getParameter("grade");
        System.out.println("grade"+grade);
        SalarygradeDao dao = new SalarygradeDaoImpl();
        if(dao.findById(grade)!=null){
            response.sendRedirect("/updateerror.jsp");
        }else {
            //2.获取参数
            Map<String, String[]> map = request.getParameterMap();
            //3.封装对象
            Salarygrade salarygrade = new Salarygrade();
            try {
                BeanUtils.populate(salarygrade, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            //4.调用Service保存
            dao.insert(salarygrade);

            //5.跳转到userListServlet
            response.sendRedirect(request.getContextPath() + "/deptGradeWelfareServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
