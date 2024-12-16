package top.soft.class02request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @author : xlf
 * @description :
 * @date : 2022/12/26
 */
@WebServlet("/requestDemo02")
public class RequestDemo02 extends HttpServlet {
    // 获取请求头数据
    //1.获取所有请求头数据名称
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            //根据名称获取请求头数据
            String header = req.getHeader(name);
            System.out.println(name+":"+header);
        }
        //2.根据名称获取请求头数据
        String header = req.getHeader("user-agent");
        if (header.contains("Edg")){
            System.out.println("Edg浏览器");
        }else {
            System.out.println("Chrome浏览器");
        }
        }
    }

