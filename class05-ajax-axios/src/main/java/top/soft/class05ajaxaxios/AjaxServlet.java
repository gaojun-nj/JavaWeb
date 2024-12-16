package top.soft.class05ajaxaxios;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 86188
 * @description: TODO
 * @date 2024/11/9 13:41
 */
@WebServlet("/ajaxservlet")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rep, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("hello Ajax~");

    }

}