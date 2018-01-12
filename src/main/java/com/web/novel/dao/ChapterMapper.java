package com.web.novel.dao;

import com.web.novel.pojo.Chapter;

import java.util.List;

public interface ChapterMapper {
    int deleteByPrimaryKey(Integer chapterId);

    int insert(Chapter record);

    Chapter selectByPrimaryKey(Integer chapterId);

    List<Chapter> selectByBookId(Integer bookId);

    List<Chapter> selectAll();

    int updateByPrimaryKey(Chapter record);
}