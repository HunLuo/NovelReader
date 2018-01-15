package com.web.novel.dao;

import com.web.novel.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insert(String userName, String facebookId, String status);

    User selectByPrimaryKey(Integer userId);

    User selectByFacebookId(String facebookId);

    List<User> selectAll();

    int updateByPrimaryKey(Integer userId, String userName, String facebookId);

    int updateByFacebookIdStatus(String facebookId, String status);

    int deleteByPrimaryKey(String userId);

    int deleteByFacebookId(String facebookId);
}