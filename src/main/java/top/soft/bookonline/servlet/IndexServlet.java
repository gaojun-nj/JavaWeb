package top.soft.bookonline.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.bookonline.entity.Book;
import top.soft.bookonline.service.BookService;
import top.soft.bookonline.service.impl.BookServicelmpl;

import java.io.IOException;
import java.util.List;

/**
 * @author Administrator
 * @description: TODO
 * @date 2024/10/26 14:54
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServicelmpl();

        List<Book> books = bookService.getBooks();
        req.setAttribute("bookList", books);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
