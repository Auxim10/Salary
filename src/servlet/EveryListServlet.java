package servlet;

import dao.EveryDao;
import dao.Impl.EveryDaoImpl;
import domain.Employee;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/everyListServlet")
public class EveryListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service
        String id = request.getParameter("eno");
        System.out.println("id:"+id);
        EveryDao dao = new EveryDaoImpl();
        Employee employees = dao.findById(id);
        System.out.println(id);
        System.out.println("员工"+id+"正在访问信息..");
        //存入数据到域中
        request.setAttribute("employees",employees);
        //转发
        request.getRequestDispatcher("/everylist.jsp").forward(request,response);
        System.out.println("转发成功..");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request, response);
    }
}
