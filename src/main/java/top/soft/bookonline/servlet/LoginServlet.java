package top.soft.bookonline.servlet;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.service.UserService;
import top.soft.bookonline.service.impl.UserServicelmpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @author Administrator
 * @description: TODO
 * @date 2024/10/26 15:48
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService ;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServicelmpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        String captcha = req.getParameter("captcha");

        User user = userService.signIn(account, password);

        HttpSession session=req.getSession(false);

        if(session != null) {
            String storedCaptcha = (String) session.getAttribute("captchaCode");
            if (storedCaptcha != null && storedCaptcha.equals(captcha)) {


                if (user != null) {
                    req.getSession().setAttribute("user", user);

                    if (remember != null) {
                        Cookie usernameCookie = new Cookie("username", account);
                        Cookie passwordCookie = new Cookie("password", password);
                        usernameCookie.setMaxAge(60 * 60 * 24 * 7);
                        passwordCookie.setMaxAge(60 * 60 * 24 * 7);
                        resp.addCookie(usernameCookie);
                        resp.addCookie(passwordCookie);
                    }


                    resp.sendRedirect("/index");
                } else {
                    resp.setContentType("text/html;charset=UTF-8");
                    resp.setCharacterEncoding("UTF-8");
                    resp.getWriter().write("<script>alert('账号或密码错误');location.href='/'</script>");
                }
            } else {
                resp.setContentType("text/html;charset=UTF-8");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write("<script>alert('验证码错误');location.href='/login.html';</script>");
            }
        }else {
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("<script>alert('error:会话不存在');location.href='/';</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
