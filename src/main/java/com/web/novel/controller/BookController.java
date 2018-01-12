package com.web.novel.controller;

import com.google.gson.Gson;
import com.web.novel.pojo.Book;
import com.web.novel.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("get-book-details.do")
    @ResponseBody
    public String getBookDetails(int bookId) {
        Book book = bookService.getOneBookById(bookId);
        Gson gson = new Gson();
        String result = gson.toJson(book);
        return result;
    }



}
