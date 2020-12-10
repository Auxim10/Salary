package login;

import dao.Userdao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = null;
        String password = null;
        username = request.getParameter("username");
        password = request.getParameter("password");

        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);

        Userdao logindao = new Userdao();
        User user =logindao.login(loginuser);

        if(user == null){
            request.getRequestDispatcher("/ServletLoginfalse").forward(request,response);
        }else{
            request.setAttribute("user",user);
            request.getRequestDispatcher("/ServletLogintrue").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
