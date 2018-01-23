package com.web.novel.controller;

import com.web.novel.ConstanSession;
import com.web.novel.pojo.User;
import com.web.novel.pojo.UserBook;
import com.web.novel.service.UserBookService;
import com.web.novel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserBookController {
    @Autowired
    UserBookService userBookService;
    @Autowired
    UserService userService;

    @RequestMapping("buy-book-success.do")
    public ModelAndView buyBookSuccess(int bookId, HttpSession httpSession) {
//        String facebookId = httpSession.getAttribute(ConstanSession.USER__FACEBOOKID).toString();
        String facebookId = "123";
        User user = userService.getOneUserByFacebookId(facebookId);
        int userId = user.getUserId();
        UserBook userBook = new UserBook();
        userBook.setBookId(bookId);
        userBook.setUserId(userId);
        ModelAndView modelAndView = new ModelAndView();
        Boolean result = true;
        if (!userBookService.isBought(userId, bookId)) {
            result = userBookService.addUserBook(userBook);
        }
        if (result) {
            modelAndView.setViewName("forward:download-book.do?bookId=" + bookId);
            modelAndView.addObject("message", "购买成功！");
        } else {
            modelAndView.setViewName("result");
            modelAndView.addObject("message", "错误");
        }
        return modelAndView;
    }

    @RequestMapping("buy-book-fail.do")
    @ResponseBody
    public String buyBookFail(int bookId, HttpSession httpSession) {

        return "购买失败，请重新支付";

    }

    @RequestMapping("is-bought.do")
    @ResponseBody
    public String isBought(int bookId, HttpSession httpSession) {
        String facebookId = httpSession.getAttribute(ConstanSession.USER__FACEBOOKID).toString();
        User user = userService.getOneUserByFacebookId(facebookId);
        Boolean flag = userBookService.isBought(user.getUserId(), bookId);
        if (flag) {
            return "true";
        }
        return "false";
    }
}
