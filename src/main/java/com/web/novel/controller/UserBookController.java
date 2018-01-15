package com.web.novel.controller;

import com.web.novel.ConstanSession;
import com.web.novel.pojo.User;
import com.web.novel.pojo.UserBook;
import com.web.novel.service.UserBookService;
import com.web.novel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserBookController {
    @Autowired
    UserBookService userBookService;
    @Autowired
    UserService userService;

    @RequestMapping("buy-book-success")
    public String buyBookSuccess(int bookId, HttpSession httpSession) {
        String facebookId = httpSession.getAttribute(ConstanSession.USER__FACEBOOKID).toString();
        User user = userService.getOneUserByFacebookId(facebookId);
        int userId = user.getUserId();
        UserBook userBook = new UserBook();
        userBook.setBookId(bookId);
        userBook.setUserId(userId);

        Boolean result = userBookService.addUserBook(userBook);
        if (result) {
            return "购买成功！";
        }
        else return "购买失败！";
    }
}
