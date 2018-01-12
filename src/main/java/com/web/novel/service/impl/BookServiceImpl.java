package com.web.novel.service.impl;

import com.web.novel.dao.BookMapper;
import com.web.novel.pojo.Book;
import com.web.novel.pojo.Result;
import com.web.novel.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    public Book getOneBookById(int bookId) {
        Book book = bookMapper.selectByPrimaryKey(bookId);
        if (book == null) {
            return null;
        }
        return book;
    }

}
