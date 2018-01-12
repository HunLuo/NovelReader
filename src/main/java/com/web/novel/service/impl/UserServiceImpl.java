package com.web.novel.service.impl;

import com.web.novel.dao.UserMapper;
import com.web.novel.pojo.Result;
import com.web.novel.pojo.User;
import com.web.novel.service.UserService;
import com.web.novel.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public Result loginCheck(User loginUser){
        Result result = new Result();
        String loginUserName = loginUser.getUserName();
        String loginUserPwd = loginUser.getUserPwd();
        loginUserPwd = MD5.makeMD5(loginUserPwd);
        User user = userMapper.selectByUserName(loginUserName);
        if(user == null){
            result.setResult(false);
            result.setMessage("账号不存在！");
            return result;
        }
        if(!loginUserPwd.equals(user.getUserPwd())){
            result.setResult(false);
            result.setMessage("登录失败！请检查账号密码！");
            return result;
        }

        result.setResult(true);
        result.setMessage("登录成功！");
        return result;


    }




    public Result registerNewUser(User newUser){
        Result result = new Result();
        String userName = newUser.getUserName();
        String userPwd = newUser.getUserPwd();
        User user = userMapper.selectByUserName(userName);
        if(user != null){
            result.setResult(false);
            result.setMessage("账号已存在！");
           return result;
        }
        userPwd = MD5.makeMD5(userPwd);
        newUser.setUserPwd(userPwd);
        int affectRow = userMapper.insert(newUser);
        if(affectRow > 0){
            result.setResult(true);
            result.setMessage("注册成功！");
            return result;
        }

        result.setResult(false);
        result.setMessage("注册失败！ affectRow="+affectRow);
        return result;
    }
}
