package com.web.novel.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.web.novel.pojo.Book;
import com.web.novel.pojo.Chapter;
import com.web.novel.service.BookService;
import com.web.novel.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChapterController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("get-chapter-list.do")
    @ResponseBody
    public String getChapterList(int bookId){
        List<Chapter> chapterList =  chapterService.getChapters(bookId);
        Book book = bookService.getOneBookById(bookId);
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        String list =  gson.toJson(chapterList);
        jsonObject.addProperty("list",list);
        jsonObject.addProperty("bookName",book.getBookName());
        jsonObject.addProperty("bookId",book.getBookId());

        return jsonObject.toString();
    }
    @RequestMapping("get-free-chapter.do")
    @ResponseBody
    public String getFreeChapterList(int bookId){
        List<Chapter> chapterList =  chapterService.getFreeChapters(bookId);
        Gson gson = new Gson();
        String result =  gson.toJson(chapterList);
        return result;
    }
}
