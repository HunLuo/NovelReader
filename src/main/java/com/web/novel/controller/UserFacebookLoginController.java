package com.web.novel.controller;



import com.google.gson.JsonObject;
import com.web.novel.ConstanSession;
import com.web.novel.pojo.User;
import com.web.novel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
/**
 *
 * @author lengxue
 * 用户登录
 */
public class UserFacebookLoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("user-login.do")
    @ResponseBody
    public String doLogin(String username, String facebookId, HttpSession httpSession,HttpServletResponse response) {
        JsonObject result = new JsonObject();
        response.setHeader("Access-Control-Allow-Origin", "*");//解决跨域访问问题

        try {
            //根据用户facebookId看用户是否存在表里，
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
                if("1".equals(user.getUserStatus())){
                    result.addProperty("result", "用户已登陆");
                    result.addProperty("username", username);
                    result.addProperty("resultCode", "100");
                    return result.toString();
                }else{
                    userService.updateByFacebookIdStatus(facebookId, "1");
                    result.addProperty("result", "OK");
                    result.addProperty("username", username);
                    result.addProperty("resultCode", "100");
                    httpSession.setAttribute(ConstanSession.USER__FACEBOOKID,facebookId);
                    httpSession.setAttribute(ConstanSession.USER_NAME,username);
                    return result.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.addProperty("result", "服务器错误，用户登录失败");
            result.addProperty("username", username);
            result.addProperty("resultCode", "101");
            return result.toString();
        }

    }


    @RequestMapping("user-logout.do")
    @ResponseBody
    public String doLogOut(String username, String facebookId, HttpSession httpSession,HttpServletResponse response) {
        JsonObject result = new JsonObject();
        response.setHeader("Access-Control-Allow-Origin", "*");//解决跨域访问题
        httpSession.setAttribute(ConstanSession.USER__FACEBOOKID,null);
        httpSession.setAttribute(ConstanSession.USER_NAME,null);
        result.addProperty("result", "退出");
        result.addProperty("resultCode", "100");
        return result.toString();


    }




}
