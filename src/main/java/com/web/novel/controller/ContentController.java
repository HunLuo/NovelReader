package com.web.novel.controller;

import com.google.gson.JsonObject;
import com.web.novel.pojo.Book;
import com.web.novel.pojo.Chapter;
import com.web.novel.service.BookService;
import com.web.novel.service.ChapterService;
import com.web.novel.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentController {
    @Autowired
    BookService bookService;

    @Autowired
    ContentService contentService;

    @Autowired
    ChapterService chapterService;

    @RequestMapping("get-content.do")
    @ResponseBody
    public String getContent(int chapterId) {
        JsonObject obj = new JsonObject();
        Chapter chapter = chapterService.getOneChapter(chapterId);
        Book book = bookService.getOneBookById(chapter.getBookId());

        String content = contentService.getContentByChapterId(chapterId);
        Boolean isCharge = chapter.getChapterIsCharge() != 0 ? true : false;
        obj.addProperty("isCharge", isCharge);
        if (chapter.getChapterNumber() == 1) {
            obj.addProperty("lastChapter", false);
        } else {
            obj.addProperty("lastChapter", true);
        }

        if (isCharge) {
            obj.addProperty("content", "购买后可下载全文！");
            obj.addProperty("nextChapter", false);
            obj.addProperty("chapterId", chapterId);
            obj.addProperty("imgUrl", chapter.getChapterImage());
            obj.addProperty("bookId", chapter.getBookId());
            obj.addProperty("bookName",book.getBookName());
            return obj.toString();
        } else {
            obj.addProperty("content", content);
            obj.addProperty("nextChapter", true);
            obj.addProperty("chapterId", chapterId);
            obj.addProperty("imgUrl", chapter.getChapterImage());
            obj.addProperty("bookId", chapter.getBookId());
            obj.addProperty("bookName",book.getBookName());
            return obj.toString();
        }
    }


}
