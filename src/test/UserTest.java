package test;

import domain.User;
import dao.Userdao;
import org.junit.Test;

public class UserTest {
    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("cy");
        loginUser.setPassword("123456");

        Userdao dao = new Userdao();
        User user = dao.login(loginUser);
        System.out.println(user);

    }

}
