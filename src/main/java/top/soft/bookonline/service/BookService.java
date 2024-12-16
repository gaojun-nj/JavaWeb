package top.soft.bookonline.service;

import top.soft.bookonline.entity.Book;

import java.util.List;

public interface BookService {
    List<top.soft.bookonline.entity.Book> getBooks();
    Book getBookById(int id);
    /**
     * 根据id查询图书详情
     */
}