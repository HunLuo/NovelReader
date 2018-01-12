package com.web.novel.service;

import com.web.novel.pojo.Chapter;

import java.util.List;

public interface ChapterService {
    public List<Chapter> getChapters(int BookId);
}
