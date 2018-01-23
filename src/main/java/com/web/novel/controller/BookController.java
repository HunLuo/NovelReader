package com.web.novel.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.web.novel.ConstanSession;
import com.web.novel.pojo.Book;
import com.web.novel.pojo.Chapter;
import com.web.novel.pojo.User;
import com.web.novel.service.BookService;
import com.web.novel.service.ChapterService;
import com.web.novel.service.UserBookService;
import com.web.novel.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserBookService userBookService;
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("get-book-details.do")
    @ResponseBody
    public String getBookDetails(int bookId) {

        List<Chapter> chapterList =  chapterService.getFreeChapters(bookId);
        Book book = bookService.getOneBookById(bookId);
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        String list =  gson.toJson(chapterList);
        String bookDetails = gson.toJson(book);
        jsonObject.addProperty("list",list);
        jsonObject.addProperty("book",bookDetails);
        return jsonObject.toString();
    }


    @RequestMapping(value = "download-book.do")
    public ResponseEntity<byte[]> download(Integer bookId, HttpSession httpSession) {
//        String facebookId = httpSession.getAttribute(ConstanSession.USER__FACEBOOKID).toString();
        String facebookId = "123";
        User user = userService.getOneUserByFacebookId(facebookId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        File file = null;
        System.out.println(user.getUserId());
        System.out.println(bookId);
        if (userBookService.isBought(user.getUserId(), bookId)) {
            Book book = bookService.getOneBookById(bookId);
            String path = book.getBookUrl();
            String fileName = path.substring(path.lastIndexOf("/") + 1, path.length());
            headers.setContentDispositionFormData("attachment", fileName);
            file = new File(path);
        }else {
            headers.setContentDispositionFormData("attachment", "download.txt");
            file = new File("download.txt");
        }

        try {
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                    headers, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
