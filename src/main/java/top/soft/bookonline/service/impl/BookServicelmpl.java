package top.soft.bookonline.service.impl;


import top.soft.bookonline.dao.BookDao;
import top.soft.bookonline.dao.impl.BookDaolmpl;
import top.soft.bookonline.entity.Book;
import top.soft.bookonline.service.BookService;

import java.util.List;

/**
 * @author Administrator
 * @description: TODO
 * @date 2024/10/26 14:29
 */
public class BookServicelmpl implements BookService {
    private final BookDao bookDao = new BookDaolmpl();


    @Override
    public List<Book> getBooks() {
        return bookDao.selectAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }
}
