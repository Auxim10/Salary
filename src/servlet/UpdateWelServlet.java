package servlet;


import dao.Impl.SalarygradeDaoImpl;
import dao.Impl.WelfareDaoImpl;
import dao.SalarygradeDao;
import dao.WelfareDao;
import domain.Salarygrade;
import domain.Welfare;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateWelServlet")
public class UpdateWelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //判断是否重复
        String oldWname = request.getParameter("oldWname");
        WelfareDao dao = new WelfareDaoImpl();
            //2.获取参数
            Map<String, String[]> map = request.getParameterMap();
            //3.封装对象
            Welfare welfare = new Welfare();
            try {
                BeanUtils.populate(welfare, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(welfare.getWname());
            if(dao.findById(welfare.getWname()) !=null && !(dao.findById(welfare.getWname()).getWname().equals(request.getParameter(oldWname)) )){
                response.sendRedirect("/updateerror.jsp");
            }else {
                //4.调用Service保存
                dao.update(welfare,oldWname);

                //5.跳转到userListServlet
                response.sendRedirect(request.getContextPath() + "/deptGradeWelfareServlet");
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
