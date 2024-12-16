package top.soft.class03response.reponse;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

/**
 * @author 86188
 * @description: TODO
 * @date 2024/9/28 14:54
 */
@WebServlet("/res")
public class ResponseTypeDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String type = req.getParameter("type");
        System.out.println(type);
        switch (type) {
            case "image":
                getImage(req, resp);
                break;
            case "pdf":
                getPdf(req, resp);
                break;
            case "txt":
                getdocx(req, resp);
                break;
            case "video":
                getvedio(req, resp);
                break;
            default:
                break;
        }

    }

    private void getvedio(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("video/mp4");
        String realPath = req.getServletContext().getRealPath("/video/video.mp4");
        File file4 = new File(realPath);
        InputStream in = new FileInputStream(file4);
        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read=in.read())!=-1){
            out.write(read);
        }
        out.flush();
        out.close();
    }

    private void getdocx(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        String realPath = req.getServletContext().getRealPath("/TXT/txt.docx");
        File file = new File(realPath);
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }
        out.flush();
        out.close();
    }

    private void getPdf(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/pdf");
        String realPath = req.getServletContext().getRealPath("/PDF/PDF.pdf");
        File file2 = new File(realPath);
        InputStream in = new FileInputStream(file2);
        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read=in.read())!=-1){
            out.write(read);
        }
        out.flush();
        out.close();
    }



    private void getImage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("image/jpg");
        String realPath = req.getServletContext().getRealPath("/images/image.jpg");
        File file = new File(realPath);
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = resp.getOutputStream();
        while ((read=in.read())!=-1){
            out.write(read);
        }
        out.flush();
        out.close();
    }
}