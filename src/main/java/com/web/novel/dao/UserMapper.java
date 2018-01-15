package com.web.novel.dao;

import com.web.novel.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {
    int insert(HashMap<String, Object> map);

    User selectByPrimaryKey(Integer userId);

    User selectByFacebookId(String facebookId);

    List<User> selectAll();

    int updateByPrimaryKey(User user1);

    int updateByFacebookIdStatus(HashMap<String, Object> map);

    int deleteByPrimaryKey(String userId);

    int deleteByFacebookId(String facebookId);
}