package com.web.novel.service;

import com.web.novel.pojo.Result;
import com.web.novel.pojo.User;

import java.util.List;

public interface UserService {

    Boolean addUser(String userName, String facebookId, String status);

    User getOneUserById(Integer userId);

    User getOneUserByFacebookId(String facebookId);

    List<User> getAllUsers();

    Boolean updateByPrimaryKey(Integer userId, String userName, String facebookId);

    Boolean updateByFacebookIdStatus(String facebookId, String status);

    Boolean deleteByPrimaryKey(String userId);

    Boolean deleteByFacebookId(String facebookId);
}
