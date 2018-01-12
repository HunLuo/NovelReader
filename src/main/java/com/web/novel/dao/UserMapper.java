package com.web.novel.dao;

import com.web.novel.pojo.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    User selectByUserName(String userName);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}