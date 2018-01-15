package com.web.novel.service.impl;

import com.web.novel.dao.UserMapper;
import com.web.novel.pojo.User;
import com.web.novel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public Boolean addUser(String userName, String facebookId, String status) {
        HashMap<String, Object> maps = new HashMap<String,Object>();
        maps.put("userName", userName);
        maps.put("facebookId", facebookId);
        maps.put("status", status);
        int affectRow = userMapper.insert(maps);
        if (affectRow > 0) {
            return true;
        }
        return false;
    }

    public User getOneUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public User getOneUserByFacebookId(String facebookId) {
        return userMapper.selectByFacebookId(facebookId);
    }

    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }

    public Boolean updateByPrimaryKey(Integer userId, String userName, String facebookId,String status) {

        User user =new User();
        user.setFacebookId(facebookId);
        user.setUserId(userId);
        user.setUserName(userName);
        int affectRow = userMapper.updateByPrimaryKey(user);
        if (affectRow > 0) {
            return true;
        }
        return false;
    }

    public Boolean updateByFacebookIdStatus(String facebookId, String status) {
        HashMap<String, Object> maps = new HashMap<String,Object>();
        maps.put("facebookId", facebookId);
        maps.put("status", status);
        int affectRow = userMapper.updateByFacebookIdStatus(maps);
        if (affectRow > 0) {
            return true;
        }
        return false;
    }

    public Boolean deleteByPrimaryKey(String userId) {
        int affectRow = userMapper.deleteByPrimaryKey(userId);
        if (affectRow > 0) {
            return true;
        }
        return false;
    }

    public Boolean deleteByFacebookId(String facebookId) {
        int affectRow = userMapper.deleteByFacebookId(facebookId);
        if (affectRow > 0) {
            return true;
        }
        return false;
    }




}
