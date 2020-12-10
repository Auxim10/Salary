package login;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletLogintrue")
public class ServletLogintrue extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取共享域
        request.setCharacterEncoding("utf-8");
        User user = (User) request.getAttribute("user");

        if(user!= null)
        //提示
        response.getWriter().write("Successful！");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
