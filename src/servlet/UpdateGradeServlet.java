package servlet;


import dao.Impl.SalarygradeDaoImpl;
import dao.SalarygradeDao;
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

@WebServlet("/updateGradeServlet")
public class UpdateGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //判断是否重复
        String oldGrade = request.getParameter("oldGrade");
        SalarygradeDao dao = new SalarygradeDaoImpl();


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

            if(dao.findById(salarygrade.getGrade()) !=null && !(dao.findById(salarygrade.getGrade()).getGrade().equals(request.getParameter(oldGrade)) )){
                response.sendRedirect("/updateerror.jsp");
            }else {
                //5.跳转到userListServlet
                dao.update(salarygrade,oldGrade);
                response.sendRedirect(request.getContextPath() + "/deptGradeWelfareServlet");
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
