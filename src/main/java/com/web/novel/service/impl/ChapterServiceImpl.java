package com.web.novel.service.impl;

import com.github.pagehelper.PageHelper;
import com.web.novel.dao.ChapterMapper;
import com.web.novel.pojo.Chapter;
import com.web.novel.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    public List<Chapter> getChapters(int bookId) {
        List<Chapter> chaptersList;
        chaptersList = chapterMapper.selectByBookId(bookId);
        return chaptersList;
    }

    public List<Chapter> getFreeChapters(int bookId) {
        List<Chapter> chaptersList;
        chaptersList = chapterMapper.selectByIsCharge(bookId,0);
        return chaptersList;
    }

    public List<Chapter> getChargeChapters(int bookId) {
        List<Chapter> chaptersList;
        chaptersList = chapterMapper.selectByIsCharge(bookId,1);
        return chaptersList;
    }
    public Boolean isCharge(int chapterId){
        Chapter chapter = chapterMapper.selectByPrimaryKey(chapterId);
        int flag = chapter.getChapterIsCharge();
        if (flag==0){
            return false;
        }
        else{
            return true;
        }
    }
    public Chapter getOneChapter(int chapterId){
        return chapterMapper.selectByPrimaryKey(chapterId);
    }
}
