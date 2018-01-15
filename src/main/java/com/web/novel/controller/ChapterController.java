package com.web.novel.controller;

import com.google.gson.Gson;
import com.web.novel.pojo.Chapter;
import com.web.novel.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("get-chapter-list.do")
    @ResponseBody
    public String getChapterList(int bookId){
        List<Chapter> chapterList =  chapterService.getChapters(bookId);
        Gson gson = new Gson();
        String result =  gson.toJson(chapterList);
        return result;
    }
}
