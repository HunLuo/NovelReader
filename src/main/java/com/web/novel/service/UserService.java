package com.web.novel.service;

import com.web.novel.pojo.Result;
import com.web.novel.pojo.User;

public interface UserService {

    public Result registerNewUser(User newUser);

    public Result loginCheck(User loginUser);
}
