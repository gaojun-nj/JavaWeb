package top.soft.bookonline.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.bookonline.dao.UserDao;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.service.UserService;
import top.soft.bookonline.service.impl.UserServicelmpl;
import top.soft.bookonline.dao.impl.UserDaolmpl;

import java.io.IOException;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServicelmpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("register-account");
        String password = req.getParameter("register-password");
        String re_password= req.getParameter("register-confirm-password");

        User user = userService.signIn(account, password);
        UserDao userDao = new UserDaolmpl();

        if(!password.equals(re_password)){
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("<script>alert('两次密码不一致');location.href='/login-page'</script>");
            return;
        }else {
            if (user != null) {
                resp.setContentType("text/html;charset=UTF-8");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write("<script>alert('账号已存在');location.href='/login-page'</script>");
            } else {
                userDao.insertUser(User.builder().account(account).password(password).address("").avatar("").build());
                System.out.println(account + ":" + password);
                resp.setContentType("text/html;charset=UTF-8");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write("<script>alert('注册成功，请登录！');location.href='/login-page'</script>");
            }

        }

    }
}