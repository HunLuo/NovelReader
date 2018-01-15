package com.web.novel.service.impl;

import com.github.pagehelper.PageHelper;
import com.web.novel.dao.ChapterMapper;
import com.web.novel.pojo.Chapter;
import com.web.novel.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    public List<Chapter> getChapters(int BookId) {
        PageHelper.startPage(1,15);
        List<Chapter> chaptersList;
        chaptersList = chapterMapper.selectByBookId(BookId);
        return chaptersList;
    }
}
