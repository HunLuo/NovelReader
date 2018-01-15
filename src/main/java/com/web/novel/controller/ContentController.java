package com.web.novel.controller;

import com.web.novel.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentController {
    @Autowired
    ContentService contentService;

    @RequestMapping("get-content.do")
    @ResponseBody
    public String getContent(int chapterId){
       String content = contentService.getContentByChapterId(chapterId);
       return content;
    }




}
