package com.web.novel.service.impl;

import com.web.novel.dao.ChapterMapper;
import com.web.novel.pojo.Chapter;
import com.web.novel.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
   private ChapterMapper chapterMapper;

    public String getContentByChapterId(int chapterId){
        // 章节路径

        Chapter chapter = chapterMapper.selectByPrimaryKey(chapterId);
        String path = chapter.getChapterUrl();
        StringBuffer sb = new StringBuffer();
        try {
            // 从本地磁盘读取
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream("e:/"+ path), "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
        } catch (Exception e) {
        }
        return sb.toString();

    }




}
