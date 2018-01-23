package com.web.novel.dao;

import com.web.novel.pojo.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChapterMapper {
    int deleteByPrimaryKey(Integer chapterId);

    int insert(Chapter record);

    Chapter selectByPrimaryKey(Integer chapterId);

    List<Chapter> selectByBookId(Integer bookId);

    List<Chapter> selectByIsCharge(@Param("bookId") Integer bookId,@Param("isCharge") Integer isCharge);

    List<Chapter> selectAll();

    int updateByPrimaryKey(Chapter record);
}