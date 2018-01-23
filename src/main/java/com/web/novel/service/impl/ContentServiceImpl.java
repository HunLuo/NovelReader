package com.web.novel.service.impl;

import com.web.novel.dao.BookMapper;
import com.web.novel.dao.ChapterMapper;
import com.web.novel.pojo.Book;
import com.web.novel.pojo.Chapter;
import com.web.novel.service.BookService;
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
    @Autowired
    private BookMapper bookMapper;

    public String getContentByChapterId(int chapterId){
        // 章节路径

        Chapter chapter = chapterMapper.selectByPrimaryKey(chapterId);
        String fileName = chapter.getChapterUrl();
        StringBuffer sb = new StringBuffer();
        int bookId = chapter.getBookId();
        Book book = bookMapper.selectByPrimaryKey(bookId);
        String path = book.getBookUrl();
         path = path.substring(0,path.lastIndexOf("/")+1);
        System.out.println(path+ fileName);

        try {
            // 从本地磁盘读取




            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(path+ fileName), "UTF-8"));
            String line = null;
            int i =0;
            sb.append("<center><h3>"+chapter.getChapterName()+"</h3></center>");
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()){
                line = "<p>" + line + "</p>";
                }
                System.out.println(line);
                sb.append(line);
                i++;
            }
            System.out.println(i);
            br.close();
        } catch (Exception e) {
        }
        return sb.toString();

    }







}
