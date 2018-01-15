package com.web.novel.service.impl;

import com.web.novel.dao.UserMapper;
import com.web.novel.pojo.User;
import com.web.novel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public Boolean addUser(String userName, String facebookId, String status) {
        int affectRow = userMapper.insert(userName, facebookId, status);
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

    public Boolean updateByPrimaryKey(Integer userId, String userName, String facebookId) {
        int affectRow = userMapper.updateByPrimaryKey(userId, userName, facebookId);
        if (affectRow > 0) {
            return true;
        }
        return false;
    }

    public Boolean updateByFacebookIdStatus(String facebookId, String status) {
        int affectRow = userMapper.updateByFacebookIdStatus(facebookId, status);
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
