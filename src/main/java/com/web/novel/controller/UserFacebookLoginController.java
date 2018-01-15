package com.web.novel.controller;



import com.google.gson.JsonObject;
import com.web.novel.ConstanSession;
import com.web.novel.pojo.User;
import com.web.novel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class UserFacebookLoginController {
    @Autowired
    private UserService userService;
    
    @RequestMapping("user-login.do")
    @ResponseBody
    public String doLogin(String username, String facebookId, HttpSession httpSession) {
        JsonObject result = new JsonObject();
        try {
            User user = userService.getOneUserByFacebookId(facebookId);
            if (user == null) {
                userService.addUser(username, facebookId, "1");
                result.addProperty("result", "OK");
                result.addProperty("username", username);
                result.addProperty("resultCode", "100");
                httpSession.setAttribute(ConstanSession.USER__FACEBOOKID,facebookId);
                httpSession.setAttribute(ConstanSession.USER_NAME,username);
                return result.toString();

            } else {
                userService.updateByFacebookIdStatus(facebookId, "1");
                userService.addUser(username, facebookId, "1");
                result.addProperty("result", "OK");
                result.addProperty("username", username);
                result.addProperty("resultCode", "100");
                httpSession.setAttribute(ConstanSession.USER__FACEBOOKID,facebookId);
                httpSession.setAttribute(ConstanSession.USER_NAME,username);
                return result.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.addProperty("result", "服务器错误，用户登录失败");
            result.addProperty("username", username);
            result.addProperty("resultCode", "101");
            return result.toString();
        }

    }




}
