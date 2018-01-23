package com.web.novel.service.impl;

import com.web.novel.dao.UserBookMapper;

import com.web.novel.pojo.User;
import com.web.novel.pojo.UserBook;
import com.web.novel.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBookServiceImpl implements UserBookService {
    @Autowired
    private UserBookMapper userBookMapper;

    public Boolean addUserBook(UserBook userBook) {

        int affectRow = userBookMapper.insert(userBook);
        if (affectRow > 0) {
            return true;
        }
        return false;
    }


    public Boolean isBought(int userId, int bookId){
        UserBook userBook =  userBookMapper.selectByUserIdAndBookId(userId,bookId);
        if (userBook!=null){
            return true;
        }
        return false;
    }

}
