package top.soft.class02request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author : xlf
 * @description :
 * @date : 2022/12/26
 */

@WebServlet("/requestDemo01")
public class RequestDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String method = request.getMethod();
       System.out.println("获取请求方法"+method);
       // 获取servlet路径
       String servletPath = request.getServletPath();
       System.out.println("获取servlet路径"+servletPath);
       // 获取get请求参数
       String queryString = request.getQueryString();
       System.out.println("获取请求参数"+queryString);
       // 获取请求URI与UPL
       String requestURI = request.getRequestURI();
       System.out.println("获取请求URI"+requestURI);
       StringBuffer requestURL = request.getRequestURL();
       System.out.println("获取请求URL"+requestURL);
       // 获取协议版本
       String protocol = request.getProtocol();
       System.out.println("版本协议"+protocol);
       // 获取虚拟项目
       String contextPath = request.getContextPath();
       System.out.println("获取虚拟项目"+contextPath);


    }
}
