package com.web.novel.controller;


import com.web.novel.pojo.Result;
import com.web.novel.pojo.User;
import com.web.novel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("login.do")
    @ResponseBody
    public String login(User loginUser) {
        Result result = userService.registerNewUser(loginUser);
        return result.getMessage();
    }

    @RequestMapping("register.do")
    @ResponseBody
    public String register(User registerUser) {
        Result result = userService.registerNewUser(registerUser);
        return result.getMessage();
    }


}
